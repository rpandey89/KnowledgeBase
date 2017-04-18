package com.Arrays.sort;

/**
 * Created by rahul.pandey on 3/19/17.
 */
public class SelectionSort {
    private static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) { // number of passes should be n - 1 as the last element will already be in the correct position
            for (int j = i + 1; j < a.length; j++) { // compare from i + 1 to the end of array
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 12, -1, 0, 6, 2, 9, 20, 14, 3};
        sort(a);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
