package com.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 4/1/17.
 */
public class MaxDistance {

    /*public static int partition(int[] a, int start, int end, int[] indexArr) {
        int pivotValue = a[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (a[i] <= pivotValue) {
                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                temp = indexArr[i];
                indexArr[i] = indexArr[pIndex];
                indexArr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = a[end];
        a[end] = a[pIndex];
        a[pIndex] = temp;
        temp = indexArr[end];
        indexArr[end] = indexArr[pIndex];
        indexArr[pIndex] = temp;
        return pIndex;
    }

    public static void sort(int[] a, int start, int end, int[] indexArr) {
        if (start < end) {
            int pIndex = partition(a, start, end, indexArr);
            sort(a, start, pIndex - 1, indexArr);
            sort(a, pIndex + 1, end, indexArr);
        }
    }

    // DO NOT MODIFY THE LIST
    public static int maximumGap(final List<Integer> a) {
        if (a.size() == 0) return -1;
        int[] newArr = new int[a.size()];
        int[] indexArr = new int[a.size()];
        int[] indexMaxArr = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            indexArr[i] = i;
            newArr[i] = a.get(i);
        }
        sort(newArr, 0, a.size() - 1, indexArr);
        int maxInd = Integer.MIN_VALUE;
        for (int i = indexArr.length - 1; i >= 0; i--) {
            maxInd = Math.max(maxInd, indexArr[i]);
            indexMaxArr[i] = maxInd;
        }

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < indexArr.length; i++) {
            maxDiff = Math.max(maxDiff, indexMaxArr[i] - indexArr[i]);
        }
        return maxDiff < 0 ? -1 : maxDiff;
    }*/

    public static int maximumGap(final List<Integer> a) {
        if (a.size() == 0) return -1;

        int[] minArr = new int[a.size()];
        int[] maxArr = new int[a.size()];

        //
        minArr[0] = a.get(0);
        for (int i = 1; i < minArr.length; i++) {
            minArr[i] = Math.min(a.get(i), minArr[i - 1]);
        }

        maxArr[a.size() - 1] = a.get(a.size() - 1);
        for (int i = maxArr.length - 2; i >= 0; i--) {
            maxArr[i] = Math.max(a.get(i), maxArr[i + 1]);
        }

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < minArr.length && j < maxArr.length; ) {
            if (minArr[i] <= maxArr[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff < 0 ? -1 : maxDiff;
    }

    public static void main(String[] args) {
        Integer[] a = {1};
        System.out.println(maximumGap(new ArrayList<>(Arrays.asList(a))));
    }

}
