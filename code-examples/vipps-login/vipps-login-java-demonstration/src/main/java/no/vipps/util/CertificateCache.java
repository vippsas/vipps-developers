package no.vipps.util;

import org.jsonbuddy.JsonObject;
import org.jsonbuddy.parse.JsonParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.HashMap;

public class CertificateCache {
    private static HashMap<String, PublicKey> publicKeys = new HashMap<String, PublicKey>();
    private static CertificateFactory certificateFactory;

    public static PublicKey get(String keyId, String iss) throws GeneralSecurityException {
        if (!publicKeys.containsKey(keyId)) {
            try {
                URL jwksUrl = new URL(fetchOpenidConfiguration(iss).requiredString("jwks_uri"));
                publicKeys.put(keyId, getKey(jwksUrl, keyId));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return publicKeys.get(keyId);
    }

    private static PublicKey getKey(URL jwksUrl, String keyId) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, CertificateException {
        if (certificateFactory == null) {
            certificateFactory = CertificateFactory.getInstance("X.509");
        }
        JsonObject jsonObject = JsonParser.parseToObject(jwksUrl);
        JsonObject key = jsonObject.requiredArray("keys")
                .objectStream()
                .filter(o -> o.requiredString("kid").equals(keyId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Can't find " + keyId + " in " + jwksUrl));

        if (key.containsKey("x5c")) {
            String certificate = key.requiredArray("x5c").requiredString(0);
            return certificateFactory.generateCertificate(
                    new ByteArrayInputStream(Base64.getMimeDecoder().decode(certificate))).getPublicKey();
        } else {
            BigInteger modulus = new BigInteger(1, Base64.getUrlDecoder().decode(key.requiredString("n")));
            BigInteger exponent = new BigInteger(1, Base64.getUrlDecoder().decode(key.requiredString("e")));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(new RSAPublicKeySpec(modulus, exponent));
        }
    }

    private static JsonObject fetchOpenidConfiguration(String iss) throws IOException {
        return JsonParser.parseToObject(new URL(iss + "/.well-known/openid-configuration"));
    }
}
