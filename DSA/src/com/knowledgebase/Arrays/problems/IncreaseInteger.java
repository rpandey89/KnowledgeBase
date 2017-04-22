package com.knowledgebase.Arrays.problems;

import com.knowledgebase.Arrays.utils.ArrayFormation;

/**
 * Created by rahul.pandey on 3/22/17.
 */
public class IncreaseInteger {

    //this is for positive integer
    private static int[] increaseInteger(int[] a) {
        a[a.length - 1] = a[a.length - 1] + 1;
        for (int i = a.length - 1; i > 0 && a[i] == 10; i--) {
            a[i] = 0;
            a[i-1] = a[i-1] + 1;
        }
        if(a[0] == 10) {
            int[] b = new int[a.length+1];
            a[0] = 0; b[0] = 1;
            for(int i = a.length - 1 ; i >= 0 ; i--) {
                b[i+1] = a[i];
            }
            return b;
        }
        return a;
    }

    /*public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        if (a.get(0) >= 0) {
            if(a.get(0) == 0 && a.size()>1) {
                ArrayList<Integer> c = new ArrayList<Integer>();
                Iterator<Integer> it = a.iterator();
                int index = 0;
                while(it.hasNext() && it.next() == 0) {
                    index++;
                }
                a = new ArrayList<Integer>(a.subList(index,a.size()));
            }
            int sum = a.get(a.size() - 1) + 1;
            a.set(a.size() - 1, sum);
            for (int i = a.size() - 1; i > 0 && sum == 10; i--) {
                if (sum == 10) {
                    a.set(i, 0);
                    sum = a.get(i - 1) + 1;
                    a.set(i - 1, sum);
                }
            }
            if (a.get(0) == 10) {
                a.set(0, 0);
                ArrayList<Integer> b = new ArrayList<>();
                b.add(1);
                for (Integer el : a) {
                    b.add(el);
                }
                a = b;
            }
        }
        return a;
    }*/

    public static void main(String[] args) {
        int[] a = {9, 9, 9};
        a = increaseInteger(a);
        ArrayFormation.displayArray(a);
    }
}
