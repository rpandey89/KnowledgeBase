package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 3/26/17.
 */
public class PascalTriangle {
    private static void getPascalTriangle(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] a = new int[n][n];
        getPascalTriangle(a, n);
        ArrayFormation.display2DArray(a);
    }
}
