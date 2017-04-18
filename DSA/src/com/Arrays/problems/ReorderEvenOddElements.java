package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 3/20/17.
 */

//this is without using another array
public class ReorderEvenOddElements {
    private static void reorder(int[] a) {
        int nEven=0, nOdd=a.length-1;
        while(nEven < nOdd) {
            if(a[nEven] % 2 == 0) {
                nEven++;
            } else {
                ArrayFormation.swap(nEven,nOdd--,a);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = ArrayFormation.createarray();
        reorder(a);
        ArrayFormation.displayArray(a);
    }
}
