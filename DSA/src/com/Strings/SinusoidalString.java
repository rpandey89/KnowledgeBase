package com.Strings;

/**
 * Created by rahul.pandey on 4/15/17.
 */
public class SinusoidalString {

    private static String getSinusoidalString(String s) {
        StringBuilder builder = new StringBuilder();
        for(int i=1;i<s.length();i+=4) {
            builder.append(s.charAt(i));
        }
        for(int i=0;i<s.length();i+=2) {
            builder.append(s.charAt(i));
        }
        for(int i=3;i<s.length();i+=4) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        //String s = "Hello World!";
        String s = "Rahul Pandey";
        System.out.println(getSinusoidalString(s));
    }
}
