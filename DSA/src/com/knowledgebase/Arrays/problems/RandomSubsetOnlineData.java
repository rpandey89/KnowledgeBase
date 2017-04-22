package com.knowledgebase.Arrays.problems;

import com.knowledgebase.Arrays.utils.ArrayFormation;

import java.util.*;

/**
 * Created by rahul.pandey on 3/24/17.
 */
public class RandomSubsetOnlineData {

    private static ArrayList<Integer> subset(int[] a, int k) {
        Random rand = new Random();
        int i = 0;
        ArrayList<Integer> b = new ArrayList<>();
        for (; i < k; i++) {
            b.add(a[i]);
        }
        int numRead = k;
        while (i < a.length) {
            numRead++;
            int x = rand.nextInt(numRead);
            if(x < k) {
                b.set(x, a[i]);
            }
            i++;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = ArrayFormation.createarray();
        ArrayFormation.displayArrayList(subset(a,3));
    }


}
