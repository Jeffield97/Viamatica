package com.viamatica.springboot.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyPassword {
    public static boolean isValidPassword(String password) {
        return hasMinimumLength(password)
                && containsUppercaseLetter(password)
                && doesNotContainSpaces(password)
                && containsAtLeastOneSpecialCharacter(password);
    }

    private static boolean hasMinimumLength(String password) {
        return password.length() >= 8;
    }

    private static boolean containsUppercaseLetter(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private static boolean doesNotContainSpaces(String password) {
        return !password.contains(" ");
    }

    private static boolean containsAtLeastOneSpecialCharacter(String password) {
        Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
