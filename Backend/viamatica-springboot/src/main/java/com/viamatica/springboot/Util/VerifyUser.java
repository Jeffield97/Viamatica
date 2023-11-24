package com.viamatica.springboot.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyUser {


    public static boolean isValidUsername(String username) {
        // Verify username without special characters
        if (containsSpecialCharacters(username)) {
            return false;
        }

        // Verify username has at least one number
        if (!containsNumber(username)) {
            return false;
        }

        // Verify username has at least one uppercase letter
        if (!containsUppercaseLetter(username)) {
            return false;
        }

        // Verify username has a length between 8 and 20 characters
        if (username.length() < 8 || username.length() > 20) {
            return false;
        }

        return true;
    }

    private static boolean containsSpecialCharacters(String username) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }

    private static boolean containsNumber(String username) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }

    private static boolean containsUppercaseLetter(String username) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }
}
