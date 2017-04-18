package com.Arrays.problems;

/**
 * Created by rahul.pandey on 3/22/17.
 */
public class AdvanceInArrayEndPossible {

    private static String isReachable(int[] a) {
        int furthestIndex = 0, index = 0;
        //we can only increase index to furthestIndex as anyways it is not reachable from furthestIndex
        while(index <= furthestIndex && furthestIndex < a.length) {
            furthestIndex = Math.max(furthestIndex, index + a[index]);
            index++;

        }
        return furthestIndex >= a.length ? "reachable" : "not reachable";

    }

    public static void main(String[] args) {
        //int[] a = {3, 3, 1, 0, 2, 0, 1};
        int[] a = {3, 2, 0, 0, 2, 0, 1};
        System.out.println(isReachable(a));
    }
}
