package com.knowledgebase.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 3/28/17.
 */
public class NobleInteger {
    private static int solve(ArrayList<Integer> a) {
        /*if (a.size() > 1) {
            if (a.get(0) == 0) {
                ArrayList<Integer> c = new ArrayList<Integer>();
                Iterator<Integer> it = a.iterator();
                int index = 0;
                while (it.hasNext() && it.next() == 0) {
                    index++;
                }
                a = new ArrayList<>(a.subList(index, a.size()));
            }
            Collections.sort(a);
            int validElements = 1;
            int length = a.size();
            for (int i = 1; i < length; i++) {
                if (a.get(validElements - 1) != a.get(i)) {
                    Collections.swap(a, i, validElements);
                    validElements++;
                }
            }
            a = new ArrayList<>(a.subList(0, validElements));
            length = a.size();
            for (int i = 0; i < length; i++) {
                int num = a.get(i);
                if ((i > 0 && num == a.get(i - 1))) continue;
                if (length - i - 1 == Math.abs(num)) {
                    return 1;
                }
            }
        }
        return -1;
        */
        if(a.size() == 1 && a.get(0) ==0) {
            return 1;
        } else if (a.size() > 1) {
            /*if (a.get(0) == 0) {
                ArrayList<Integer> c = new ArrayList<Integer>();
                Iterator<Integer> it = a.iterator();
                int index = 0;
                while (it.hasNext() && it.next() == 0) {
                    index++;
                }
                a = new ArrayList<>(a.subList(index, a.size()));
            }*/
            Collections.sort(a);
            int length = a.size();
            for (int i = 0; i < length; i++) {
                int num = a.get(i);
                while (i < length - 1 && num == a.get(i + 1)) {
                    i++;
                }

                if (length - i - 1 == num) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] a = {-6, -1, 4};
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(a));
        System.out.println(solve(b));
    }
}
