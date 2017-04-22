package com.knowledgebase.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 3/31/17.
 */
public class LargestNumber {

    private static int partition(int start, int end, String[] a) {
        int pIndex = start;
        String pivotValue = a[end];
        for (int i = start; i < end; i++) {
            String str = a[i].concat(pivotValue);
            String str1 = pivotValue.concat(a[i]);
            if (str.compareTo(str1) < 1) {
                String temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                pIndex++;
            }
        }
        String temp = a[end];
        a[end] = a[pIndex];
        a[pIndex] = temp;
        return pIndex;
    }

    private static void sort(int start, int end, String[] a) {
        if (start < end) {
            int pIndex = partition(start, end, a);
            //int pIndex = randomizedPartition(start, end, a);
            sort(start, pIndex - 1, a);
            sort(pIndex + 1, end, a);
        }
    }

    // DO NOT MODIFY THE LIST
    public static String largestNumber(final List<Integer> a) {
        if (a.size() == 0) return "";
        StringBuilder builder1 = new StringBuilder();
        int sum = 0;
        for (Integer num : a) {
            sum += num;
            builder1.append(num).append(",");
        }
        if(sum == 0) return "0";
        String[] arr = builder1.toString().split(",");
        sort(0, a.size() - 1, arr);
        StringBuilder builder = new StringBuilder("");
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Integer[] a = {3, 30, 34, 5, 9};
        //Integer[] a = {0,0};
        System.out.println(largestNumber(new ArrayList<>(Arrays.asList(a))));
    }
}
