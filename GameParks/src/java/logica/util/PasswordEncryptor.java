package logica.util;

import logica.cfg.Config;
import logica.cfg.ConfigKey;
import logica.cfg.ConfigSection;

import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncryptor {

    private static final String FIXED_SALT = "aF3nJC45kFJ3GJNZ8q3R";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 255;

    public PasswordEncryptor() { }

    private byte[] hash(char[] password) {
        PBEKeySpec spec = new PBEKeySpec(password, FIXED_SALT.getBytes(), ITERATIONS, KEY_LENGTH);
        byte[] hash = null;
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = skf.generateSecret(spec).getEncoded();
            spec.clearPassword();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        }
        return hash;
    }

    public String generateSecurePassword(String password) {
        byte[] securePassword = hash(password.toCharArray());
        return Base64.getEncoder().encodeToString(securePassword);
    }

    public String decodePassword(String password){
        return new String(Base64.getDecoder().decode(password));
    }

    public boolean verifyPassword(String encryptedPassword, String securedPassword) {
        String password = decodePassword(encryptedPassword);
        String newSecurePassword = generateSecurePassword(password);
        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }
}
