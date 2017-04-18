package com.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 3/28/17.
 */
public class MinStepsInfiniteGrid {
    private static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if (X.size() != Y.size()) return 0;
        int minSteps = 0, index = 0;
        while (index < X.size() - 1) {
            int x1 = X.get(index), x2 = X.get(index + 1), y1 = Y.get(index), y2 = Y.get(index + 1);
            int xStep = x1 < x2 ? x2 - x1 : x1 - x2;
            int yStep = y1 <= y2 ? y2 - y1 : y1 - y2;
            minSteps += Math.max(Math.abs(xStep), Math.abs(yStep));
            index++;
        }
        return minSteps;
    }

    public static void main(String[] args) {
        Integer[] a = {2, -7, -13};
        Integer[] b = {2, 1, -5};
        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(a));
        ArrayList<Integer> Y = new ArrayList<>(Arrays.asList(b));
        System.out.println(coverPoints(X, Y));
    }
}
