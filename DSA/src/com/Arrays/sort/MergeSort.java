package com.Arrays.sort;

/**
 * Created by rahul.pandey on 3/19/17.
 */
public class MergeSort {
    private static void merge(int[] left, int[] right, int[] main) {
        int nl = left.length, nr = right.length;
        int i = 0, j = 0, k = 0;
        while (i < nl && j < nr) {
            if (left[i] <= right[j]) {
                main[k] = left[i];
                i++;
            } else {
                main[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nl) {
            main[k] = left[i];
            k++;i++;
        }
        while (j < nr) {
            main[k] = right[j];
            k++;j++;
        }
    }

    private static void sort(int[] array) {
        int n = array.length;
        if (n < 2) return;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            right[i-mid] = array[i];
        }
        sort(left);
        sort(right);
        merge(left, right, array);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 12, -1, 0, 6, 2, 9, 20, 14, 3};
        sort(a);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
