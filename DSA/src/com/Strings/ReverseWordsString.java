package com.Strings;

import com.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 4/14/17.
 */
public class ReverseWordsString {

    private static int findSpace(char[] a, int start) {
        for (int i = start; i < a.length; i++) {
            if (a[i] == ' ') return i;
        }
        return -1;
    }

    private static void reverse(char[] a, int start, int end) {
        for (int i = start; i < end - ((end + start) / 2); i++) {
            char temp = a[i];
            a[i] = a[end - i - 1];
            a[end - i - 1] = temp;
        }
        /*end--;
        while(start < end) {
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }*/
    }

    private static void reverseWords(char[] a) {
        //reverse the char array
        reverse(a, 0, a.length);
        int start = 0, end = 0;
        //reverse each word
        while ((end = findSpace(a, start)) != -1) {
            reverse(a, start, end);
            start = end + 1;
        }
        //reverse last word
        reverse(a, start, a.length);
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', ' ', 'd', 'e', 'f', ' ', 'g', 'h', 'i'};
        reverseWords(a);
        ArrayFormation.displayArray(a);
    }
}
