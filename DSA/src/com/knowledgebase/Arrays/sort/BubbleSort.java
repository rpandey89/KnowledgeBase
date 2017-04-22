package com.knowledgebase.Arrays.sort;

/**
 * Created by rahul.pandey on 3/19/17.
 */
public class BubbleSort {

    private static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) { //n - 1 passes as we will have sorted array after that
            int flag = 0; //to improve further
            for (int j = 0; j < a.length - i - 1; j++) {
                //for(int j=0; j<a.length-1;j++) { //till n-2 because we can't do i+1 on n-1 element
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) break; //that means array is already sorted
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

