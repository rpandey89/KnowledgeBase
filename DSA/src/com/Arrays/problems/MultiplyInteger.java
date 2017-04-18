package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul.pandey on 3/22/17.
 */
public class MultiplyInteger {

    private static List<Integer> multiplyNums(int[] a, int[] b) {
        //xor to get -1 & -1 +ve and -1 & 1 as -ve
        int sign = a[0] < 0 ^ b[0] < 0 ? -1 : 1;
        //get the absolute values
        a[0] = Math.abs(a[0]);
        b[0] = Math.abs(b[0]);
        int[] result = new int[a.length + b.length + 1];
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                //first store the result
                result[i + j + 1] = (result[i + j + 1] + a[i] * b[j]);
                //then do the carryover to next digit
                result[i + j] = result[i + j] + result[i + j + 1] / 10;
                //then do a final remainder of the sum at respective location
                result[i + j + 1] = result[i + j + 1] % 10;
            }
        }

        ArrayFormation.displayArray(result);

        //remove trailing zeroes
        int index = 0;
        while (result[index] == 0 && index < result.length) {
            index++;
        }
        if(index == result.length) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(index < result.length) {
            list.add(result[index++]);
        }
        list.set(0, list.get(0) * sign);
        return list;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 3, 7, 0, 7, 7, 2, 1};
        int[] b = {-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7};
        System.out.println(multiplyNums(a, b));
    }

}
