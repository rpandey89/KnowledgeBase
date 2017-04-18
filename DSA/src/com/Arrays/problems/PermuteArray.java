package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 3/24/17.
 */
public class PermuteArray {

    private static void permuteArray(char[] a, int[] p) {
        for (int i = 0; i < a.length; i++) {
            int next = i;
            while (p[next] >= 0) {
                ArrayFormation.swap(i,p[next],a);
                int temp = p[next];
                p[next] = p[next] - p.length;
                next = temp;
            }
        }
        //we can restore the array p
        for(int i=0;i<p.length;i++) {
            p[i] = p[i] + p.length;
        }
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd'};
        int[] p = {2, 0, 1, 3};
        permuteArray(a, p);
        ArrayFormation.displayArray(a);
    }

}
