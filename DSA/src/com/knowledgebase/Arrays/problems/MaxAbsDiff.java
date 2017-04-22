package com.knowledgebase.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 3/29/17.
 */
public class MaxAbsDiff {

    private static int maxArr(ArrayList<Integer> A) {
        if (A.size() == 1) return 0;
        int minPos = Integer.MAX_VALUE, maxPos = Integer.MIN_VALUE, minNeg = Integer.MAX_VALUE, maxNeg = Integer.MIN_VALUE;

        for (int i = 0; i < A.size(); i++) {
            minPos = Math.min(minPos, A.get(i) + i);
            minNeg = Math.min(minNeg, A.get(i) - i);
            maxPos = Math.max(maxPos, A.get(i) + i);
            maxNeg = Math.max(maxNeg, A.get(i) - i);

        }
        int ans = 0;
        ans = Math.max(ans, maxPos - minPos);
        ans = Math.max(ans, maxNeg- minNeg);
        return ans;
    }

    public static void main(String[] args) {
        Integer[] a = {-98, -5, 37, -97, 38, 22, 70, 42, 61, 84};
        System.out.println(maxArr(new ArrayList<>(Arrays.asList(a))));
    }
}
