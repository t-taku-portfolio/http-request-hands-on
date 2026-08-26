package io.github.t_taku_portfolio.model;

import java.util.regex.Pattern;

public class Validator {
    // Hiragana : \\u3040-\\u309f, Katakana : \\u30A0-\\u30FF, Kanji : \\u4E00-\\u9FAF
    // Currently allow alphanumeric input only to simplify the configurations of each layer
    private static final Pattern WHITELIST_PATTERN = Pattern.compile("[^a-zA-Z0-9\\s]+$");

    public static void validatePath(String path) {
        if(path == null) {
            throw new IllegalArgumentException("[VALIDATION FAILURE] Path cannot be null");
        }

        if (path.contains("\u0000")) {
            throw new IllegalArgumentException("[VALIDATION FAILURE] Invalid path");
        }

        if (path.contains("../") || path.contains("..\\")) {
            throw new IllegalArgumentException("[VALIDATION FAILURE] Invalid path traversal");
        }
    }

    public static void validateMethod(String method) {
        if (method == null) {
            throw new IllegalArgumentException("[VALIDATION FAILURE] Method cannot be null");
        }
        // method need to be within GET and POST, DELETE, UPDATE.
        // the validation will be implemented later
    }

    public static void validateStudentName(String name) {
        // before Java 11, trim() is required to trim spaces
        if(name.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }
        if(name.length() > 20) {
            throw new IllegalArgumentException("name is too long");
        }
        if(!Validator.isMatchWhiteList(name)) {
            throw new IllegalArgumentException("character is invalid");
        }
    }

    public static boolean isMatchWhiteList(String input) {
        //string.isBlank() checks out null value too.
        if (input == null || input.isBlank()) {
            System.out.println("[VALIDATION FAILURE] Null or empty value is invalid");
            return false;
        }

        return WHITELIST_PATTERN.matcher(input).matches();
    }

    /*
    public static boolean isPunctuation(char ch) {
        int type = Character.getType(ch);
        return
            type == Character.CONNECTOR_PUNCTUATION ||
            type == Character.DASH_PUNCTUATION ||
            type == Character.END_PUNCTUATION ||
            type == Character.OTHER_PUNCTUATION ||
            type == Character.START_PUNCTUATION ||
            type == Character.FINAL_QUOTE_PUNCTUATION ||
            type == Character.INITIAL_QUOTE_PUNCTUATION;
     */
}
