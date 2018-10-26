# Vipps SFTP Report Service

The SFTP report service is used for downloading settlement reports. SFTP-users
are created, associated with a public key, and given access to the reports of
one or more merchants. The reports are generated dynamically upon request.

More information about SFTP: [SSH File Transfer Protocol](https://en.wikipedia.org/wiki/SSH_File_Transfer_Protocol).

# How to set up users for connecting to the SFTP server

1. Login to https://portal.vipps.no and click Bedriftsinfo under Bedrift and Organization name

![Velg profil](images/01_velg_profil.png "Velg profil")

2. Click the link under the information to add users for SFTP-access.

![Lag tilgang](images/02_SFTP_tilgang.png "Lag tilgang")

3. In the next window you can add the public keys of the user(s). We support RSA, EdDSA and Ed25519 keys in OpenSSH format (and reject DSA keys). After this you should see the newly created user.

![Bruker opprettet](images/03_bruker_opprettet.png "bruker opprettet")

# Connecting to the SFTP server

The address of the SFTP server is `sftp.vipps.no`.

This is the directory structure:
```
/settlements/[inbox|archive]/[file extension]/[orgnum]/[sales unit serial]/[sales unit serial]-[settlement number].[file extension]
```

# How to use it

Reports under `/settlements/inbox` can be "deleted" (actually hidden) in order
to keep track of already processed reports. They are deleted by using the `rm`
command in SFTP or the delete function in your SFTP interface. Reports under
`/settlements/archive` cannot be removed.
