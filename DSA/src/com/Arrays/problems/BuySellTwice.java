package com.Arrays.problems;

import java.util.ArrayList;

/**
 * Created by rahul.pandey on 3/23/17.
 */
public class BuySellTwice {

    private class Interval {
        public int minIndex;
        public int maxIndex;
    }

    private static double calculateMaxProfitTwice(int[] a) {

        double maxProfit = 0;
        double minAmount = Double.MAX_VALUE, maxAmount = Double.MIN_VALUE;
        /*
        O(n) time, O(n) space*/
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            maxProfit = Math.max(maxProfit, a[i] - minAmount);
            minAmount = Math.min(minAmount, a[i]);
            result[i] = maxProfit;
        }
        maxProfit = 0;
        for (int i = a.length - 1; i > 0; i--) {
            maxAmount = Math.max(maxAmount, a[i]);
            maxProfit = Math.max(maxProfit, maxAmount - a[i] + result[i - 1]);
        }
        /*O(n) time O(1) space
        int i = 0, j = a.length - 1;
        while(i<a.length && j>0) {

        }*/
        return maxProfit;

    }

    //This is for multiple times
    //O(n) time
    private ArrayList<Interval> calculateProfitForNTrans(int[] a) {
        ArrayList<Interval> pairs = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < a.length - 1; ) {
            while (i < a.length - 1 && a[i] >= a[i + 1]) {
                i++;
            }
            if (i == a.length - 1) {
                break;
            }
            Interval interval = new Interval();
            interval.minIndex = i++;
            while (i < a.length && a[i] >= a[i - 1]) {
                i++;
            }
            interval.maxIndex = i - 1;
            pairs.add(interval);
            count++;
        }
        return pairs;
    }

    //This is an example of Dynamic programming
    //original formula is
    //Max(profit[i][j - 1] - No transaction, max(previous day profit profit[i-1][m] + a[j] - current day - a[m] previous days))
    //where m is 0...j-1
    //reducing further gives the below formula, as we have already calculated in earlier calculation
    //O(k * days) time and space otherwise O(k * day ^ 2) time using original formula
    private static int calculateMaxProfitkTrans(int[] a, int k) {
        int[][] profit = new int[k + 1][a.length];
        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < a.length; j++) {
                prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - a[j - 1]);
                profit[i][j] = Math.max(profit[i][j - 1], prevDiff + a[j]);
            }
        }
        return profit[k][a.length - 1];
    }

    public static void main(String[] args) {
        int[] a = {12, 11, 13, 9, 12, 8, 14, 13, 15};
        System.out.println("Max profit is " + calculateMaxProfitTwice(a));
        BuySellTwice b = new BuySellTwice();
        int[] b1 = {100, 180, 260, 310, 40, 535, 695};
        ArrayList<Interval> pairs = b.calculateProfitForNTrans(b1);
        for (Interval pair : pairs) {
            System.out.println("pair " + pair.minIndex + " " + pair.maxIndex);
        }
        int[] price = {12, 14, 17, 10, 14, 13, 12, 15};
        int k = 3;
        System.out.println("Max profit " + k + " times is : " + calculateMaxProfitkTrans(a, k));
    }
}
