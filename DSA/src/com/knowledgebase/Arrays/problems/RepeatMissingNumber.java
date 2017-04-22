package com.knowledgebase.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 3/30/17.
 */
public class RepeatMissingNumber {
    private static ArrayList<Integer> check(final List<Integer> a) {
        //still giving overflow error
        ArrayList<Integer> list = new ArrayList<>();
        if (a.size() == 1) return list;
        double sqmDiff = 0, mdDiff = 0;
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            if (num < 1) return list;
            mdDiff += i+1 - num;
            if(i+1!=a.get(i)) {
                sqmDiff += ((i + 1) * (i + 1)) - num * num;
            }
        }
        if (mdDiff == 0) return list;
        double mdSum = sqmDiff / mdDiff;
        int first = (int) (mdSum + mdDiff) / 2;
        int second = (int) (first - mdDiff);
        if(mdDiff < 0) {
            list.add(Math.max(first,second));
            list.add(Math.min(first,second));
        } else {
            list.add(Math.min(first,second));
            list.add(Math.max(first,second));
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] a = {2, 2};
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(a));
        System.out.println(check(b));
    }
}
