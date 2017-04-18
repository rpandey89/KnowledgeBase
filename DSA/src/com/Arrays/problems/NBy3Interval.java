package com.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 4/5/17.
 */
public class NBy3Interval {

    private static int repeatedNumber(final List<Integer> a) {
        int num = -1;
        double numOccur = (double) a.size() / 3;
        if (a == null || a.size() == 0) {
            num = -1;
        } else if (a.size() < 3) {
            num = a.get(0);
        } else {
            int el1 = Integer.MAX_VALUE, el2 = Integer.MAX_VALUE;
            double c1 = 0, c2 = 0;
            for (int i = 0; i < a.size(); i++) {
                int currElement = a.get(i);
                if (el1 == currElement) {
                    c1++;
                } else if (el2 == currElement) {
                    c2++;
                } else if (currElement != el1 && currElement != el2) {
                    if (c1 > 0 && c2 > 0) {
                        c1--;
                        c2--;
                    } else if (c1 == 0) {
                        el1 = currElement;
                        c1++;
                    } else if (c2 == 0) {
                        el2 = currElement;
                        c2++;
                    }
                }
            }

            double ac1 = 0, ac2 = 0;
            for(int i=0;i < a.size();i++) {
                if(a.get(i) == el1) {
                    ac1++;
                    if(ac1 > numOccur) {
                        num = el1;
                        break;
                    }
                } else if(a.get(i) == el2) {
                    ac2++;
                    if(ac2 > numOccur) {
                        num = el2;
                        break;
                    }
                }

            }

            if (ac1 == 0 && ac2 == 0) {
                num = -1;
            }
        }

        return num;

    }


    public static void main(String[] args) {
        Integer[] a = {1, 1, 1, 2, 3, 5, 7};
        System.out.println(repeatedNumber(new ArrayList<>(Arrays.asList(a))));
    }
}
