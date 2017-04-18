package com.Strings;

/**
 * Created by rahul.pandey on 4/15/17.
 */
public class RunLengthEncoding {

    private static String decode(String s) {
        if (s == null || s.length() < 1) return "";
        StringBuilder builder = new StringBuilder();
        int result = 0;
        for(int i=0;i<s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                result = result * 10 + s.charAt(i) - '0';
            } else {
                while(result > 0) {
                    builder.append(s.charAt(i));
                    result--;
                }
            }
        }
        return builder.toString();
    }

    private static String encode(String s) {
        if (s == null || s.length() < 1) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while(i+1<s.length() && s.charAt(i) == s.charAt(i+1)) {
                i++;
                count++;
            }
            builder.append(count);
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabcccaaaaaaaaaaaaaaabbbbbbbnnnnnnnmmmmmmm";
        System.out.println(encode(s));
        System.out.println(decode(encode(s)).equals(s));
    }
}
