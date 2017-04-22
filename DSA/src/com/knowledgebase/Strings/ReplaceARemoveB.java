package com.knowledgebase.Strings;

import com.knowledgebase.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 4/12/17.
 */
public class ReplaceARemoveB {

    private static void replaceRemove(char[] a) {
        //get the valid elements and number of counts of a
        //while removing b
        int aCount = 0, validEl = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 'b' && a[i] != ' ') {
                a[validEl++] = a[i];
            }
            if (a[i] == 'a') aCount++;
        }

        //now start from validEl - 1
        //and add from index + aCount as we have to replace one a with two d's
        int index = validEl - 1;
        validEl = index + aCount;
        while (index >= 0) {
            if (a[index] == 'a') {
                a[validEl--] = 'd';
                a[validEl--] = 'd';
            } else {
                a[validEl--] = a[index];
            }
            index--;
        }
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd', 'a', 'd', ' '};
        replaceRemove(a);
        ArrayFormation.displayArray(a);
    }
}
