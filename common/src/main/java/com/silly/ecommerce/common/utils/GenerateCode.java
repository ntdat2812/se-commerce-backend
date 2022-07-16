package com.silly.ecommerce.common.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class GenerateCode {
    private static final int DEFAULT_SIZE = 10;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static SecureRandom rnd = new SecureRandom();

    private String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(ALPHABET.charAt(rnd.nextInt(ALPHABET.length())));
        return sb.toString();
    }

    private String generateNumber(int length) {
        long timeSeed = System.nanoTime();
        double randSeed = Math.random() * 1000;
        long midSeed = (long) (timeSeed * randSeed);
        return String.valueOf(midSeed).substring(0, length);
    }

    public String generateRandomCode(String prefix) {
        StringBuilder randomCode = new StringBuilder();
        randomCode.append(prefix).append(randomString(3)).append(generateNumber(DEFAULT_SIZE - prefix.length() - 3));
        return randomCode.toString().toUpperCase();
    }

}
