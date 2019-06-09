package no.vipps;

import no.vipps.util.CertificateCache;
import org.jsonbuddy.JsonNode;
import org.jsonbuddy.JsonObject;
import org.jsonbuddy.parse.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.GeneralSecurityException;
import java.security.Signature;
import java.time.Instant;
import java.util.Base64;
import java.util.Optional;

public class JwtToken {
    private static final Logger logger = LoggerFactory.getLogger(JwtToken.class);

    private final JsonObject payload;
    private final JsonObject header;
    private String token;

    public JwtToken(String token, boolean validate) {
        this.token = token;
        String[] tokenParts = token.split("\\.");

        this.header = (JsonObject) JsonParser.parseFromBase64encodedString(tokenParts[0]);
        this.payload = (JsonObject) JsonParser.parseFromBase64encodedString(tokenParts[1]);

        if (validate) {
            safeVerifySignature(alg(), iss(), header.requiredString("kid"), tokenParts);
            verifyTimeValidity(Instant.now());
        }
    }

    public String alg() {
        return header.requiredString("alg");
    }

    /**
     * The "iss" (issuer) claim identifies the principal that issued the
     * JWT.  The processing of this claim is generally application specific.
     * The "iss" value is a case-sensitive string containing a StringOrURI
     * value.  Use of this claim is OPTIONAL.
     * https://tools.ietf.org/html/rfc7519
     */
    public String iss() {
        return payload.requiredString("iss");
    }

    /**
     * The "sub" (subject) claim identifies the principal that is the
     * subject of the JWT.  The claims in a JWT are normally statements
     * about the subject.  The subject value MUST either be scoped to be
     * locally unique in the context of the issuer or be globally unique.
     * The processing of this claim is generally application specific.  The
     * "sub" value is a case-sensitive string containing a StringOrURI
     * value.  Use of this claim is OPTIONAL.
     * https://tools.ietf.org/html/rfc7519
     */
    public String sub() {
        return payload.requiredString("sub");
    }

    /**
     * Audience(s) that this ID Token is intended for. It MUST contain the OAuth 2.0 client_id
     * of the Relying Party as an audience value. It MAY also contain identifiers for other
     * audiences. In the general case, the aud value is an array of case sensitive strings.
     * In the common special case when there is one audience, the aud value MAY be a single
     * case sensitive string.
     * https://tools.ietf.org/html/rfc7519
     */
    public String aud() {
        return payload.requiredString("aud");
    }

    private void safeVerifySignature(String alg, String iss, String keyId, String[] tokenValues) {
        try {
            if (!verifySignature(alg, iss, keyId, tokenValues)) {
                throw new JwtTokenValidationException("Failed to verify signature");
            } else {
                logger.debug("Verified signature");
            }
        } catch (GeneralSecurityException e) {
            logger.warn("Failed to validate token {}", payload, e);
            throw new JwtTokenValidationException("Failed to verify signature", e);
        }
    }

    private boolean verifySignature(String alg, String iss, String keyId, String[] tokenValues) throws GeneralSecurityException {
        if (!alg.equals("RS256")) {
            throw new IllegalArgumentException("Illegal algorithm " + alg);
        }
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(CertificateCache.get(keyId, iss));
        signature.update((tokenValues[0] + "." + tokenValues[1]).getBytes());
        return signature.verify(Base64.getUrlDecoder().decode(tokenValues[2]));
    }

    private void verifyTimeValidity(Instant now) {
        boolean earliestTime = now.isBefore(nbf().orElse(authTime().orElse(Instant.EPOCH)));
        if (earliestTime) {
            throw new JwtTokenValidationException("JWT not valid yet! " + earliestTime + " " + payload);
        }
        if (now.isAfter(exp())) {
            throw new JwtTokenValidationException("JWT not valid yet! " + exp() + " " + payload);
        }
    }

    /**
     * The "nbf" (not before) claim identifies the time before which the JWT
     * MUST NOT be accepted for processing.  The processing of the "nbf"
     * claim requires that the current date/time MUST be after or equal to
     * the not-before date/time listed in the "nbf" claim.  Implementers MAY
     * provide for some small leeway, usually no more than a few minutes, to
     * account for clock skew.  Its value MUST be a number containing a
     * NumericDate value.  Use of this claim is OPTIONAL.
     * https://tools.ietf.org/html/rfc7519
     */
    private Optional<Instant> nbf() {
        return payload.longValue("nbf").map(Instant::ofEpochSecond);
    }

    /**
     * The "iat" (issued at) claim identifies the time at which the JWT was
     * issued.  This claim can be used to determine the age of the JWT.  Its
     * value MUST be a number containing a NumericDate value.  Use of this
     * claim is OPTIONAL.
     * https://tools.ietf.org/html/rfc7519
     */
    public Instant iat() {
        return Instant.ofEpochSecond(payload.requiredLong("iat"));
    }

    public Optional<Instant> authTime() {
        return payload.longValue("auth_time").map(Instant::ofEpochSecond);
    }

    /**
     * The "exp" (expiration time) claim identifies the expiration time on
     * or after which the JWT MUST NOT be accepted for processing.  The
     * processing of the "exp" claim requires that the current date/time
     * MUST be before the expiration date/time listed in the "exp" claim.
     * Implementers MAY provide for some small leeway, usually no more than
     * a few minutes, to account for clock skew.  Its value MUST be a number
     * containing a NumericDate value.  Use of this claim is OPTIONAL.
     * https://tools.ietf.org/html/rfc7519
     */
    public Instant exp() {
        return Instant.ofEpochSecond(payload.requiredLong("exp"));
    }

    public JsonNode getPayload() {
        return payload;
    }

    public JsonNode getHeader() {
        return header;
    }
}
