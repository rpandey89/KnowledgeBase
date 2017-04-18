package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 3/21/17.
 */
public class DutchNationalFlag {

    //O(n^2)
    private static void dutchPartition(int[] a, int pivotIndex) {
        int pivotValue = a[pivotIndex];
        System.out.println("pivot value " + pivotValue);

        //move the large values at the end
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < pivotValue) {
                    ArrayFormation.swap(i, j, a);
                    break;
                }
            }
        }

        //move the small values at the beginning
        for (int i = a.length - 1; i >= 0 && a[i] >= pivotValue;    i--) {
            for (int j = i - 1; j >= 0 && a[j] >= pivotValue; j--) {
                if (a[j] > pivotValue) {
                    ArrayFormation.swap(i, j, a);
                    break;
                }
            }
        }
    }

    //O(n)
    private static void dutchPartitionFast(int[] a, int pivotIndex) {
        int pivotValue = a[pivotIndex], small = 0, equal = 0, large = a.length - 1;
        System.out.println("pivot value " + pivotValue);
        while (equal < large) {
            if (a[equal] < pivotValue) {
                ArrayFormation.swap(small++, equal++, a);
            } else if (a[equal] == pivotValue) {
                equal++;
            } else {
                ArrayFormation.swap(large--, equal, a);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = ArrayFormation.createarray();
        //ArrayFormation.displayArray(a);
        dutchPartition(a, 5);
        ArrayFormation.displayArray(a);
        int[] b = ArrayFormation.createarray();
        dutchPartitionFast(b, 5);
        System.out.println("");
        ArrayFormation.displayArray(b);
    }
}
