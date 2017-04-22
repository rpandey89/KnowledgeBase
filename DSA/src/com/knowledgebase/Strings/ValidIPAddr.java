package com.knowledgebase.Strings;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by rahul.pandey on 4/15/17.
 */
public class ValidIPAddr {


    private static boolean isValidIPSubString(String s) {
        //substring can't be greater than 3 in length
        if (s.length() > 3) return false;
        //00 001 are invalid except 0
        if (s.startsWith("0") && s.length() > 1) return false;
        int num = Integer.parseInt(s);
        //check whether the substring lies in the range of 0 and 255
        if (num < 0 || num > 255) return false;
        return true;
    }

    private static List<String> getValidIPAddr(String decimalString) {
        List<String> list = new ArrayList<>();
        if (decimalString == null || decimalString.length() < 1) return list;
        for (int i = 1; i < 4; i++) {
            String first = decimalString.substring(0, i);
            if (isValidIPSubString(first)) {
                for (int j = 1; j < 4 && i + j < decimalString.length(); j++) {
                    String second = decimalString.substring(i, i + j);
                    if (isValidIPSubString(second)) {
                        for (int k = 1; k < 4 && i + k + j < decimalString.length(); k++) {
                            String third = decimalString.substring(i + j, i + j + k);
                            String fourth = decimalString.substring(i + j + k);
                            if (isValidIPSubString(third) && isValidIPSubString(fourth)) {
                                list.add(first + '.' + second + '.' + third + '.' + fourth);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String decimalString = "19216811";
        List<String> list = getValidIPAddr(decimalString);
        for (String el : list) {
            System.out.println(el);
        }
    }

}
