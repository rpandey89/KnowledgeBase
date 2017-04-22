package com.knowledgebase.Arrays.problems;

import com.knowledgebase.Arrays.utils.ArrayFormation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by rahul.pandey on 3/25/17.
 */
public class RandomSubset {

    private static int[] randomSubset(int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int rIndex = i + rand.nextInt(n - i);
            Integer el1 = map.get(i);
            Integer el2 = map.get(rIndex);
            //swap the values in the map if any of them are present
            if (el1 == null && el2 == null) {
                map.put(i, rIndex);
                map.put(rIndex, i);
            } else if (el1 == null && el2 != null) {
                map.put(i, el2);
                map.put(rIndex, i);
            } else if (el1 != null && el2 == null) {
                map.put(i, rIndex);
                map.put(rIndex, el1);
            } else {
                map.put(i, el2);
                map.put(rIndex, el1);
            }
        }
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = map.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        ArrayFormation.displayArray(randomSubset(10, 3));
    }

}
