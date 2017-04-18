package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 3/25/17.
 */
public class RandomPermutation {

    private static int[] randPerm(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        RandomSubsetOfflineData.subset(a, a.length);
        return a;
    }

    public static void main(String[] args) {
        ArrayFormation.displayArray(randPerm(10));
    }

}
