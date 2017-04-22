package com.knowledgebase.Strings;

/**
 * Created by rahul.pandey on 4/12/17.
 */
public class BaseConversion {

    private static String helper(int num, int base) {
        return (num == 0 ? "" : (helper(num / base, base) +
                (char) (num % base >= 10 ? 'A' + (num % base) - 10 : '0' + num % base)));

    }

    private static String convertToBase(String str, int base1, int base2) {
        int num = 0;
        for (int i = str.charAt(0) == '-' ? 1 : 0; i < str.length(); i++) {
            num = num * base1 + (Character.isDigit(str.charAt(i)) ?
                    (str.charAt(i) - '0') : str.charAt(i) - 'A' + 10);
        }
        return ((str.charAt(0) == '-' ? "-" : "") +
                (num == 0 ? "0" : helper(num, base2)));

    }

    public static void main(String[] args) {
        String str = "615";
        System.out.println(convertToBase(str, 7, 13));
    }
}
