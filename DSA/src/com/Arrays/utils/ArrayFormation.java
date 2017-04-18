package com.Arrays.utils;

import java.util.ArrayList;

/**
 * Created by rahul.pandey on 3/20/17.
 */
public class ArrayFormation {

    public static int[] createarray() {
        //int[] a = {1, 4, 12, -1, 0, 6, 2, 9, 20, 14, 3};s
        return new int[]{3, 3, 1, -1, 0, 2, 1, 2};
    }

    public static int[][] create2DArray(int row, int col) {
        int[][] matrix = new int[row][col];
        int count = 0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                matrix[i][j] = count++;
            }
        }
        return matrix;
    }

    public static void displayArray(int[] a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void displayArray(char[] a) {
        for (char num : a) {
            System.out.print(num + " ");
        }
    }

    public static void displayArray(boolean[] a) {
        for (boolean num : a) {
            System.out.print(num + " ");
        }
    }

    public static void displayArrayList(ArrayList<Integer> list) {
        System.out.println("");
        if(list == null) return;
        for(Integer el : list) {
            System.out.print(el.toString() + " ");
        }
    }

    public static void display2DArray(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void swap(int first, int second, int[] a) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void swap(int first, int second, char[] a) {
        char temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
}
