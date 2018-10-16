package ui.utils;

import java.security.SecureRandom;

public class StringGenerator {
    private static final String domain = "ukr.net";

    public static String generateEmail() {
        return String.format("%s@%s", generateOnlyString(15), domain);
    }

    public static String generateOnlyString(int size) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        return generateString(chars, size);
    }

    private static String generateString(char[] chars, int size) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString().trim();
    }
}
