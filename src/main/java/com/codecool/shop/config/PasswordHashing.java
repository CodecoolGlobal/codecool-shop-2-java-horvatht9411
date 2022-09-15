package com.codecool.shop.config;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class PasswordHashing {

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return hash;
    }

    public static byte[] stringMatrixToHash(String string) {
        String joinedMinusBrackets = string.substring(1, string.length() - 1);
        String[] items = joinedMinusBrackets.split(", ");
        byte[] result = new byte[items.length];
        for (int i = 0; i < items.length; i++) {
            int intItem = Integer.parseInt(items[i]);
            result[i] = (byte) intItem;
        }
        return result;
    }
}
