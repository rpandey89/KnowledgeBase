package com.Strings;

/**
 * Created by rahul.pandey on 4/15/17.
 */
public class KMPSubstring {

    private static int[] getPrefixArr(String pattern) {
        if (pattern == null || pattern.length() == 0) return new int[1];
        int[] prefixArr = new int[pattern.length()];
        int j = 0;
        prefixArr[j] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            //move back till we find a match or we are the first index
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                //always check the previous index
                //as it gives the idea which substring is a prefix as well as suffix in the pattern
                j = prefixArr[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) j++;
            prefixArr[i] = j;
        }
        return prefixArr;
    }

    //prints all occurrences
    private static boolean getSubstringIndex(String text, String pattern) {
        if (text.length() < pattern.length()) return false;
        int[] prefixArr = getPrefixArr(pattern);
        int j = 0, k = -1;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && pattern.charAt(j) != text.charAt(i)) {
                j = prefixArr[j - 1];
                k = i - j;
            }
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == 0) k = i - j;
                j++;
            }
            if (pattern.length() == j) {
                System.out.println(k);
                j = prefixArr[j - 1];
                i--;//this is to keep the current index which increments by the above i++
            }
        }
        return k > -1;
    }

    public static void main(String[] args) {
        //String pattern = "acacabacacabacacac";
        //String pattern = "abcdabca";
        //String pattern = "abcaby";
        //String text = "abcxabcdabcdabcy";
        //String pattern = "abcdabcy";
        //String text = "ABABDABACDABABCABAB";
        //String pattern = "ABABCABAB";
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";


        //ArrayFormation.displayArray(getPrefixArr(subString));
        System.out.println(getSubstringIndex(text, pattern));
    }
}
