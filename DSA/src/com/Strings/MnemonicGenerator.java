package com.Strings;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by rahul.pandey on 4/15/17.
 */
public class MnemonicGenerator {

    private static final String[] mnemonicMapping = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    private static void mnemonicsHelper(String phoneNumber, int digit, char[] partialResult, List<String> mnemonics) {
        if (digit == phoneNumber.length()) {
            mnemonics.add(new String(partialResult));
        } else {
            int index = phoneNumber.charAt(digit) - '0';
            if (index == 0 || index == 1) {
                partialResult[digit] = phoneNumber.charAt(digit);
                mnemonicsHelper(phoneNumber, digit + 1, partialResult, mnemonics);
            } else {
                for (int i = 0; i < mnemonicMapping[index].length(); i++) {
                    partialResult[digit] = mnemonicMapping[index].charAt(i);
                    mnemonicsHelper(phoneNumber, digit + 1, partialResult, mnemonics);
                }
            }

        }
    }

    private static List<String> getMnemonics(String phoneNumber) {
        List<String> mnemonics = new ArrayList<>();
        if(phoneNumber.length() > 0) {
            char[] partialResult = new char[phoneNumber.length()];
            mnemonicsHelper(phoneNumber, 0, partialResult, mnemonics);

        }
        return mnemonics;
    }


    public static void main(String[] args) {
        //String phoneNumber = "010110";
        String phoneNumber = "2276696";
        //String phoneNumber = "";
        List<String> mnemonics = getMnemonics(phoneNumber);
        for (String el : mnemonics) {
            System.out.println(el);
        }
    }
}
