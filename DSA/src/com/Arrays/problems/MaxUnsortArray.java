package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rahul.pandey on 4/2/17.
 */
public class MaxUnsortArray {

    private static ArrayList<Integer> unsortArr(ArrayList<Integer> A) {
        ArrayList<Integer> indices = new ArrayList<>();
        if (A.size() == 0) {
            indices.add(-1);
        } else {
            int l = 0, r = A.size();
            //first find the element which is greater than its next value l -> r
            for (int i = 0; i < A.size() - 1; i++) {
                if (A.get(i) > A.get(i + 1)) {
                    l = i;
                    break;
                }
            }
            if (l == A.size() - 1) {
                indices.add(-1);
            } else {
                //now find the element which is smaller than its previous value r -> l
                for (int i = A.size() - 1; i > 0; i--) {
                    if (A.get(i) < A.get(i - 1)) {
                        r = i;
                        break;
                    }
                }
                if (r == A.size()) {
                    indices.add(-1);
                } else {
                    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                    for (int i = l; i <= r; i++) {
                        max = Math.max(A.get(i), max);
                        min = Math.min(A.get(i), min);
                    }
                    //adjust to see if there is a number greater than min in 0 to l - 1
                    for (int i = 0; i < l; i++) {
                        if (A.get(i) > min) {
                            l = i;
                            break;
                        }
                    }
                    //adjust to see if there is a number less than max from r + 1 to n - 1
                    for (int i = A.size() - 1; i > r; i--) {
                        if (A.get(i) < max) {
                            r = i;
                            break;
                        }
                    }
                    indices.add(l);
                    indices.add(r);
                }
            }

        }
        return indices;

    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 4, 5, 6, 8, 7, 3};
        //Integer[] a = {3, 1, 2, 6, 5, 4};
        ArrayFormation.displayArrayList(unsortArr(new ArrayList<>(Arrays.asList(a))));

    }
}
