package com.knowledgebase.Arrays.problems;

import com.knowledgebase.Arrays.utils.ArrayFormation;

import java.util.Random;

/**
 * Created by rahul.pandey on 3/24/17.
 */
public class RandomSubsetOfflineData {

    public static void subset(int[] a, int k) {
        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            ArrayFormation.swap(i,i + rand.nextInt(a.length - i), a);
        }
    }

    public static void main(String[] args) {
        int[] a = ArrayFormation.createarray();
        subset(a, 3);
        ArrayFormation.displayArray(a);
    }
}
