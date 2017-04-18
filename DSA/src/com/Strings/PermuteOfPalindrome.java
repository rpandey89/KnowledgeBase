package com.Strings;

/**
 * Created by rahul.pandey on 4/7/17.
 */
public class PermuteOfPalindrome {

    private static boolean checkPermuteOfPalindrome(String input) {
        int vector = 0;
        //set the bits in the vector
        //only one bit in the vector should be set if string is permutation of palindrome
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                int val = input.charAt(i) - 'a';
                int mask = 1 << val;
                if((vector & mask) == 0) {
                    vector |= mask;
                } else {
                    vector &= ~mask;
                }
            }
        }
        System.out.println();
        return (vector & (vector - 1)) == 0;
    }

    public static void main(String[] args) {
        String input = "itkip";
        System.out.println("String is permute of palindrome ? " + checkPermuteOfPalindrome(input));
    }
}
