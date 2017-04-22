package com.knowledgebase.Arrays.sort;

/**
 * Created by rahul.pandey on 3/19/17.
 */
public class InsertionSort {
    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) { //here 1 to n-1 because last element can still be small
            int spInd = i, value = a[i];
            while (spInd > 0 && value < a[spInd - 1]) { //move the larger elements to right
                a[spInd] = a[spInd - 1];
                spInd--;
            }
            a[spInd] = value; //set the element at the correct position
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
