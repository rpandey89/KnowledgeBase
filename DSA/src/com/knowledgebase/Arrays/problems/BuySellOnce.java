package com.knowledgebase.Arrays.problems;

/**
 * Created by rahul.pandey on 3/23/17.
 */
public class BuySellOnce {

    private static double calculateMaxProfit(int[] a) {
        double minAmount = Double.MAX_VALUE, maxProfit = 0;
        for(int i = 0; i < a.length; i++) {
            maxProfit = Math.max(maxProfit, a[i] - minAmount);
            minAmount = Math.min(minAmount, a[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = {310, 315, 295, 260, 270, 290, 230, 255, 250};
        System.out.println("max profit is " + calculateMaxProfit(a));
    }
}
