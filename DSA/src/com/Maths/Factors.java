package com.Maths;

import com.Arrays.utils.ArrayFormation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rahul.pandey on 3/26/17.
 */
public class Factors {

    private static ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(a);i++) {
            if(a%i==0) {
                al.add(i);
                if(i!=(a/i)) {
                    al.add(a/i);
                }
            }
        }
        Collections.sort(al);
        return al;
    }

    public static void main(String[] args) {
        int n = 1245;
        ArrayFormation.displayArrayList(allFactors(n));
    }
}
