package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 3/25/17.
 */
public class Rotate2DArray {

    private static void rotateClockWise90(int[][] a) {
        int size = a.length-1;
        for (int i = 0; i < a.length / 2; i++) {
            for (int j = i; j < size - i; j++) {
                int el1 = a[i][j];
                int el2 = a[j][size - i];
                int el3 = a[size - i][size - j];
                int el4 = a[size - j][i];
                a[i][j] = el4;
                a[j][size - i] = el1;
                a[size - i][size - j] = el2;
                a[size - j][i] = el3;
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = ArrayFormation.create2DArray(4, 4);
        ArrayFormation.display2DArray(matrix);
        rotateClockWise90(matrix);
        ArrayFormation.display2DArray(matrix);
    }
}
