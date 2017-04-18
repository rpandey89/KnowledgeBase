package com.Arrays.sort;

import com.Arrays.utils.ArrayFormation;

import java.util.Random;

/**
 * Created by rahul.pandey on 3/20/17.
 */
public class QuickSort {

    //make the position of pivot be random to increase the efficiency in worst case
    //which is usually O(n^2)
    private static int randomizedPartition(int start, int end, int[] a) {
        int pIndex = new Random().nextInt(end - start) + start;
        ArrayFormation.swap(pIndex, end, a);
        return partition(start, end, a);
    }

    private static int partition(int start, int end, int[] a) {
        int pIndex = start;
        int pivotValue = a[end];
        for (int i = start; i < end; i++) {
            if (a[i] <= pivotValue) {
                ArrayFormation.swap(i, pIndex, a);
                pIndex++;
            }
        }
        ArrayFormation.swap(pIndex, end, a);
        return pIndex;
    }

    private static void sort(int start, int end, int[] a) {
        if (start < end) {
            //int pIndex = partition(start, end, a);
            int pIndex = randomizedPartition(start, end, a);
            sort(start, pIndex - 1, a);
            sort(pIndex + 1, end, a);
        }
    }

    public static void main(String[] args) {
        int[] a = ArrayFormation.createarray();
        sort(0, a.length - 1, a);
        ArrayFormation.displayArray(a);

    }

}

