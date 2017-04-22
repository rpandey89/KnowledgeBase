package com.knowledgebase.Strings;

/**
 * Created by rahul.pandey on 4/15/17.
 */
public class RabinKarpSubstring {

    private static boolean isSimilar(String text, String pattern, int index) {
        if (index < 0) return false;
        int j = 0;
        for (int i = index; i < index + pattern.length(); i++) {
            if (text.charAt(i) != pattern.charAt(j)) return false;
            j++;
        }
        return true;
    }


    private static int getSubstringIndex(String text, String pattern) {
        if (text.length() < pattern.length()) return -1;
        //have a big prime number to calculate the hash code to avoid collisions
        int prime = 31, pHash = 0, tHash = 0;
        for (int i = 0; i < pattern.length(); i++) {
            //calculate hash code of the pattern
            //and first pattern.length() chars' hashcode
            pHash += pattern.charAt(i) * Math.pow(prime, i);
            tHash += text.charAt(i) * Math.pow(prime, i);
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (tHash == pHash && isSimilar(text, pattern, i - pattern.length())) {
                return i - pattern.length();
            }
            tHash = ((tHash - text.charAt(i - pattern.length())) / prime) +
                    (int) (text.charAt(i) * Math.pow(prime, pattern.length() - 1));
        }
        //check for the last one
        if (tHash == pHash && isSimilar(text, pattern, text.length() - pattern.length())) {
            return text.length() - pattern.length();
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABCDAEF";
        String pattern = "F";
        System.out.println(getSubstringIndex(text, pattern));
    }
}
