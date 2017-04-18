package com.Strings;

/**
 * Created by rahul.pandey on 4/12/17.
 */
public class PalindromicStrings {

    private static boolean palindromicString(String str) {
        if (str == null || str.length() == 0) return false;
        int i = 0, j = str.length() - 1;
        while (i < j) {
            int Ai = 0, Aj = 0;
            while (true) {
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    Ai = str.charAt(i) - 'A';
                    break;
                } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    Ai = str.charAt(i) - 'a';
                    break;
                }
                i++;
            }

            while (true) {
                if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') {
                    Aj = str.charAt(j) - 'A';
                    break;
                } else if (str.charAt(j) >= 'a' && str.charAt(j) <= 'z') {
                    Aj = str.charAt(j) - 'a';
                    break;
                }
                j--;
            }
            if (Ai != Aj) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        //String str = "A man, a plan, a canal, Panama";
        //String str = "Ray a Ray";
        String str = "Able was I, ere I saw Elba!";
        System.out.println(palindromicString(str));
    }
}
