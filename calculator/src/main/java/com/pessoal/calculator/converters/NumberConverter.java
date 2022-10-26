package com.pessoal.calculator.converters;

public class NumberConverter {

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        }
        var number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[\\d]*\\.?[\\d]+");
    }

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        var number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }

}
