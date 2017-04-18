package com.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 4/2/17.
 */
public class MaxConsecutiveGap {
    private static int maximumGap(final List<Integer> a) {
        if (a == null || a.size() < 2) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        //find the max and min
        for (int i = 0; i < a.size(); i++) {
            max = Math.max(a.get(i), max);
            min = Math.min(a.get(i), min);
        }
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        if (max - min == 0) return 0;
        //divide numbers into equally spaced gaps, which will be used to find the interval further
        double gap = (max - min) / (double) (a.size() - 1);
        int absoluteGap = gap >= 0 && gap < 1 ? 1 : (int) Math.round(gap);
        Integer[] negArr = {-1, -1};
        //initialize the buckets size 0 to n
        for (int i = 0; i < a.size(); i++) {
            bucketList.add(new ArrayList(Arrays.asList(negArr)));
        }
        //add the numbers in their respective intervals
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            double temp = (num - min) / (double) absoluteGap;
            int interval = (int) Math.round(temp);
            if (interval >= bucketList.size()) {
                Integer[] arrV = {num, num};
                bucketList.add(new ArrayList(Arrays.asList(arrV)));
            } else {
                ArrayList<Integer> pair = bucketList.get(interval);
                int first = pair.get(0), second = pair.get(1);
                if (first == -1 && second == -1) {
                    pair.set(0, num);
                    pair.set(1, num);
                } else {
                    pair.set(0, Math.min(num, first));
                    pair.set(1, Math.max(num, second));
                }
            }
        }
        int maxDiff = Integer.MIN_VALUE, prev = bucketList.get(0).get(1);
        //now calculate the diff
        for (int i = 1; i < bucketList.size(); i++) {
            ArrayList<Integer> pair = bucketList.get(i);
            int first = pair.get(0), second = pair.get(1);
            maxDiff = Math.max(maxDiff, first - prev);
            maxDiff = Math.max(maxDiff, second - first);
            if (second != -1) prev = second;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 1, 2};
        System.out.println(maximumGap(new ArrayList<>(Arrays.asList(a))));

    }
}
