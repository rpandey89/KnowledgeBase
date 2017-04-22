package com.knowledgebase.Arrays.problems;

import com.knowledgebase.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 3/24/17.
 */
public class NextPermutation {

    private static void nextPermutation(int[] a) {
        int minIndex = a.length - 2;
        while (minIndex >= 0 && a[minIndex] >= a[minIndex + 1]) {
            minIndex--;
        }
        if (minIndex == -1) return;
        int maxIndex = minIndex + 1;
        while (maxIndex < a.length - 1 && a[minIndex] <= a[maxIndex]) {
            maxIndex++;
        }
        ArrayFormation.swap(minIndex, maxIndex, a);
        minIndex++;
        //reverse from minIndex+1
        maxIndex = a.length - 1;
        while (minIndex < maxIndex) {
            ArrayFormation.swap(minIndex, maxIndex, a);
            minIndex++;
            maxIndex--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3};
        nextPermutation(a);
        ArrayFormation.displayArray(a);

    }

}
