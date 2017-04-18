package com.Strings;

/**
 * Created by rahul.pandey on 4/15/17.
 */
public class LookAndSaySequence {

    private static String sequence(String s) {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            int count = 1;
            while(i+1 < s.length() && s.charAt(i+1) == s.charAt(i)) {
                count++;
                i++;
            }
            builder.append(count);
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    private static String lookNdSay(int n) {
        if(n <= 0) return "";
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = sequence(s);
        }
        return s;
    }

    public static void main(String[] args) {
        int number = 8;
        System.out.println(lookNdSay(number));
    }

}
