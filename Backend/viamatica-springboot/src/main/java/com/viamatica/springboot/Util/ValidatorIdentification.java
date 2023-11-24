package com.viamatica.springboot.Util;

import java.util.regex.Pattern;

public class ValidatorIdentification {
    public static boolean isValidIdentification(String identification) {
        return hasExactDigits(identification, 10)
                && containsOnlyNumbers(identification)
                && doesNotHaveRepeatingDigits(identification, 4);
    }

    private static boolean hasExactDigits(String identification, int digitCount) {
        return identification.length() == digitCount;
    }

    private static boolean containsOnlyNumbers(String identification) {
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(identification).matches();
    }

    private static boolean doesNotHaveRepeatingDigits(String identification, int repeatCount) {
        Pattern pattern = Pattern.compile("(\\d)\\1{" + (repeatCount - 1) + ",}");
        return !pattern.matcher(identification).find();
    }
}
