package com.knowledgebase.Strings;

/**
 * Created by rahul.pandey on 4/7/17.
 */
public class UniqueChars {

    private static boolean checkUniqueBooleanArray(String uniqueString) {
        if (uniqueString.length() > 128) {
            return false;
        }
        boolean[] flags = new boolean[128];
        for (int i = 0; i < uniqueString.length(); i++) {
            int val = uniqueString.charAt(i);
            if (flags[val]) return false;
            flags[val] = true;
        }
        return true;
    }

    private static boolean checkUniqueBitVector(String uniqueString) {
        //assumes char set a-z lowercase
        if(uniqueString.length() > 128) return false;
        int p = 0;
        for(int i=0;i<uniqueString.length();i++) {
            int val = uniqueString.charAt(i) - 'a';
            if((p & (1 << val)) > 0) return false;
            p |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        String uniqueString = "abcdef";
        String nonUniqueString = "abcfaa";
        System.out.println("String unique " + checkUniqueBooleanArray(uniqueString));
        System.out.println("String non unique " + checkUniqueBitVector(uniqueString));
        System.out.println("String unique " + checkUniqueBooleanArray(nonUniqueString));
        System.out.println("String non unique " + checkUniqueBitVector(nonUniqueString));
    }

}
