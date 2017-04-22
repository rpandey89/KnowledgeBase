package com.knowledgebase.Strings;

import java.util.*;

/**
 * Created by rahul.pandey on 4/7/17.
 */
public class StringPermuteOther {

    //can be solved by sorting and checking for lengths
    private static boolean hashTableMethod(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        Map<Integer, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (charCountMap.get((int) str1.charAt(i)) == null || charCountMap.get((int) str1.charAt(i)) == 0) {
                charCountMap.put((int) str1.charAt(i), 1);
            } else {
                charCountMap.put((int) str1.charAt(i), charCountMap.get(str1.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (charCountMap.get((int) str2.charAt(i)) == null || charCountMap.get((int) str2.charAt(i)) == -1) {
                return false;
            } else {
                charCountMap.put((int) str2.charAt(i), -1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcd", str2 = "";
        System.out.println("str1 permute of other ? " + hashTableMethod(str1, str2));

    }
}
