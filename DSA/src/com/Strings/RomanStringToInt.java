package com.Strings;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by rahul.pandey on 4/15/17.
 */
public class RomanStringToInt {

    //double brace initialization should not be used
    private static final Map<Character, Integer> romMap = new HashMap() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    private static boolean isValidRomanString(String romStr) {
        int count = 1;
        for (int i = romStr.length() - 2; i >= 0; i--) {
            if (romMap.get(romStr.charAt(i)) < romMap.get(romStr.charAt(i + 1)) && count < 2) {
                switch (romStr.charAt(i)) {
                    case 'I':
                        if (romStr.charAt(i + 1) != 'V' && romStr.charAt(i + 1) != 'X') return false;
                        break;
                    case 'X':
                        if (romStr.charAt(i + 1) != 'L' && romStr.charAt(i + 1) != 'C') return false;
                        break;
                    case 'C':
                        if (romStr.charAt(i + 1) != 'D' && romStr.charAt(i + 1) != 'M') return false;
                        break;
                }
                count++;
            } else if (romMap.get(romStr.charAt(i)) > romMap.get(romStr.charAt(i + 1))) {
                count = 1;
            } else if (count >= 2) {
                return false;
            }
        }
        return true;
    }

    public static int getNumFromRoman(String romStr) {
        if(!isValidRomanString(romStr)) return 0;
        int num = romMap.get(romStr.charAt(romStr.length() - 1));
        for (int i = romStr.length() - 2; i >= 0; i--) {
            if (romMap.get(romStr.charAt(i)) < romMap.get(romStr.charAt(i + 1))) {
                num -= romMap.get(romStr.charAt(i));
            } else {
                num += romMap.get(romStr.charAt(i));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String romString = "IXC";
        System.out.println(getNumFromRoman(romString));
    }

}
