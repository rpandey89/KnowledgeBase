package com.Strings;

/**
 * Created by rahul.pandey on 4/12/17.
 */
public class SpreadsheetColEncoding {

    private static int getDecodedInt(String encoding) {
        int result = 0;
        for (int i = 0; i < encoding.length(); i++) {
            result = result * 26 + encoding.charAt(i) - 'A' + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ZZ";
        System.out.println(getDecodedInt(str));
    }

}
