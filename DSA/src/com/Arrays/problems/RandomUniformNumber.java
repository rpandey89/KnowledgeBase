package com.Arrays.problems;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by rahul.pandey on 3/25/17.
 */
public class RandomUniformNumber {

    private static int randUniformNumber(int[] n, double[] p) {
        ArrayList<Double> sp = new ArrayList<>();
        sp.add(p[0]);
        for(int i=1;i<p.length;i++) {
            sp.add(p[i-1] + p[i]);
        }
        Random rand = new Random();
        double prob = rand.nextDouble();
        //get the interval
        int index = Collections.binarySearch(sp,prob);
        if(index<0) {
            //this is because binary search returns -(insertion point) - 1 in case there is not key match at insertion point
            return n[(Math.abs(index-1)-1)];
        } else {
            return n[index];
        }
    }

    public static void main(String[] args) {
        int[] n = {1,3,5,7};
        double[] p = {0.5,0.33,0.11,.056};
        System.out.println("Number is " + randUniformNumber(n,p));
    }
}
