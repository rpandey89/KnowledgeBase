package com.Strings;

/**
 * Created by rahul.pandey on 4/12/17.
 */
public class StrtoInttoStr {

    private static int stringToInt(String numString) {
        int num = 0;
        for (int i = numString.charAt(0) == '-' ? 1 : 0; i < numString.length() - 1; i++) {
            //1 * 10 + 2 -> 12 * 10 + 3 = 123
            num = num * 10 + numString.charAt(i) - '0';
        }
        return (numString.charAt(0) == '-' ? -num : num);
    }

    private static String intToString(int num) {
        StringBuilder builder = new StringBuilder();
        if(num == 0) {
            return "0";
        } else {
            int r;
            boolean isNegative = (num < 0);
            while (num != 0) {
                r = Math.abs(num % 10);
                builder.append((char)(r + '0'));
                num /= 10;
            }
            return (isNegative ? builder.append('-').reverse().toString() : builder.reverse().toString());
        }

    }

    public static void main(String[] args) {
        String str = "-45682";
        int num = 456879433;
        System.out.println(stringToInt(str));
        System.out.println(intToString(num));
    }

}
