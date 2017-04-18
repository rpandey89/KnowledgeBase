package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;
import java.util.*;

/**
 * Created by rahul.pandey on 3/22/17.
 */
public class DeleteDupSortArray {
    private static int deleteDuplicates(int[] a) {
        /*
        this will print num of valid elements but adds zeroes at duplicated elements
        int numValidElements = a.length;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] == a[i + 1]) {
                if(i < a.length - 1) {
                    a[i] = a[i+1];
                }
                a[i+1] = 0;
                numValidElements--;
            }
            //System.out.println("");
            //ArrayFormation.displayArray(a);
        }*/
        int numValidElements = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[numValidElements-1] != a[i]) {
                a[numValidElements++] = a[i];
                //numValidElements++;
            }
        }
        return numValidElements;
    }

    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> a) {
        int validElements = 1;
        int length = a.size();
        for(int i=1;i<length;i++) {
            if(a.get(validElements - 1) != a.get(i)) {
                Collections.swap(a, i, validElements);
                validElements++;
            }
        }
        return new ArrayList<>(a.subList(0, validElements));
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 5, 5, 7, 11, 11, 11, 13};
        Integer[] b = {2, 5, 5, 5, 7, 11, 11, 11, 13};
        System.out.println(deleteDuplicates(a));
        ArrayFormation.displayArray(a);
        ArrayFormation.displayArrayList(removeDuplicates(new ArrayList<>(Arrays.asList(b))));
    }
}
