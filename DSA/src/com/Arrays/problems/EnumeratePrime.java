package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rahul.pandey on 3/23/17.
 */
public class EnumeratePrime {
    private static ArrayList<Integer> enumerateUsingNormal(int n) {
        ArrayList<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        ArrayList<Integer> primeList = new ArrayList<>();
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int i = 2; i <= n; i++) {
            if (isPrime.get(i)) {
                primeList.add(i);
                for (int j = i; j <= n; j += i) {
                    isPrime.set(j, false);
                }
            }
        }
        return primeList;
    }

    private static ArrayList<Integer> enumerateUsingFunky(int n) {
        int size = (int) Math.floor(0.5 * (n - 3) + 1); //this is because we have eliminated all evens from 1 to n and 0,1,2 too
        ArrayList<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));
        ArrayList<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        for (int i = 0; i < size; i++) {
            if (isPrime.get(i)) {
                int p = 2 * i + 3; // this is the form of numbers other than evens
                primeList.add(p);
                //check from square of numbers less than that are already covered by other primes
                //for e.g. 3 covers 15 so no need to check for that for 5
                //index of these squares and above is 2*i^2 + 6*i + 3
                for (int j = ((2 * i * i) + (6 * i) + 3); j <= size; j += p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primeList;
    }


    public static void main(String[] args) {
        //ArrayList<Integer> primesFromNormal = enumerateUsingNormal(100000);
        //ArrayFormation.displayArrayList(primesFromNormal);
        ArrayList<Integer> primesFromFunky = enumerateUsingFunky(100000);
        ArrayFormation.displayArrayList(primesFromFunky);
    }
}
