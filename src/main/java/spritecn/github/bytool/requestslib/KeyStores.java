package spritecn.github.bytool.requestslib;

import  spritecn.github.bytool.requestslib.exception.TrustManagerLoadFailedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class KeyStores {

    /**
     * Load keystore from file.
     */
    public static KeyStore load(String path, char[] password) {
        try {
            return load(new FileInputStream(path), password);
        } catch (FileNotFoundException e) {
            throw new TrustManagerLoadFailedException(e);
        }
    }

    /**
     * Load keystore from InputStream, close the stream after load succeed or failed.
     */
    public static KeyStore load(InputStream in, char[] password) {

        try {
            KeyStore myTrustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            myTrustStore.load(in, password);
            return myTrustStore;
        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException e) {
            throw new TrustManagerLoadFailedException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignore) {
                }
            }
        }
    }
}
