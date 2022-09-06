package com.geofence;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestDrive {

    public static String convertIntegerToRomanNumerals(Integer arabicInteger, Map<String, Integer> numberByNumeral) {
        StringBuilder romanNumeralsBuilder = new StringBuilder();
        int remainder = arabicInteger;
        for (Map.Entry<String, Integer> numeralKeyArabicValue : numberByNumeral.entrySet()) {
            while (remainder >= numeralKeyArabicValue.getValue()) {
                romanNumeralsBuilder.append(numeralKeyArabicValue.getKey());
                remainder -= numeralKeyArabicValue.getValue();
            }
        }
        return romanNumeralsBuilder.toString();
    }

    public static Integer convertRomanNumeralsToInteger(String romanNumeralsString, Map<String, Integer> numberByNumeral) {
        Integer total = 0;
        String lastNumeral = "";
        char[] romanNumerals = romanNumeralsString.toUpperCase().toCharArray();
        for (int i = romanNumerals.length - 1; i > -1; i--) {
            String numeral = String.valueOf(romanNumerals[i]);
            total += getIntegerValueFromAdjacentNumerals(numeral, lastNumeral, numberByNumeral);
            lastNumeral = numeral;
        }
        return total;
    }

    private static Integer getIntegerValueFromAdjacentNumerals(String leftNumeral, String rightNumeral,Map<String, Integer> numberByNumeral) {
        Integer leftNumeralIntegerValue = numberByNumeral.get(leftNumeral);
        Integer rightNumeralIntegerValue = "".equals(rightNumeral) ? 0 : numberByNumeral.get(rightNumeral);
        return rightNumeralIntegerValue > leftNumeralIntegerValue ?
                -1 * leftNumeralIntegerValue : leftNumeralIntegerValue;
    }

    public static void main(String args[]) {
        Map<String, Integer> numberByNumeral = new LinkedHashMap<>();
        numberByNumeral.put("M", 1000);
        numberByNumeral.put("CM", 900);
        numberByNumeral.put("D", 500);
        numberByNumeral.put("CD", 400);
        numberByNumeral.put("C", 100);
        numberByNumeral.put("XC", 90);
        numberByNumeral.put("L", 50);
        numberByNumeral.put("XL", 40);
        numberByNumeral.put("X", 10);
        numberByNumeral.put("IX", 9);
        numberByNumeral.put("V", 5);
        numberByNumeral.put("IV", 4);
        numberByNumeral.put("I", 1);

        Map<String, Integer> numberByNumerals = Collections.unmodifiableMap(numberByNumeral);

        //String romanNumerals = convertIntegerToRomanNumerals(Integer.valueOf(args[0]),numberByNumerals);

        //System.out.println("Enter integer Number Param  : "+ Integer.valueOf(args[0])+" : Corresponding romanNumeral : "+romanNumerals);

        Integer numberInteger = convertRomanNumeralsToInteger(args[0], numberByNumerals);

        System.out.println(" Enter romanNumeral String : "+args[0]+" : Convert into Integer Value  : "+ numberInteger);

    }
}
