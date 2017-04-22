package com.knowledgebase.Arrays.problems;

import com.knowledgebase.Arrays.utils.ArrayFormation;

import java.util.*;

/**
 * Created by rahul.pandey on 4/1/17.
 */
public class MaxNonNegSubArray {
    //edge cases handling gone wrong
    private static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        if (a.size() == 0) return null;
        long maxSum = 0, maxStart = -1, maxEnd = -1, currSum = 0, currStart = 0, currEnd = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 0) {
                currSum += a.get(i);
                if (currSum > maxSum || (currSum == maxSum && currEnd - currStart > maxEnd - maxStart)) {
                    maxSum = currSum;
                    maxStart = currStart;
                    maxEnd = currEnd;
                }
            } else {
                currSum = 0;
                currStart = currEnd + 1;
            }
            currEnd++;
        }
        ArrayList<Integer> maxList = new ArrayList<>();
        if (maxSum >= 0 && maxEnd > -1) {
            for (long i = maxStart; i <= maxEnd; i++) {
                maxList.add(a.get((int) i));
            }
        }
        return maxList;
    }

    public static void main(String[] args) {
        //Integer[] a = {-1,-1,-1,-1};
        //Integer[] a = {756898537, -1973594324, -2038664370, -184803526, 1424268980};
        Integer[] a = {336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421};
        /*
        *  else if (currSum < 0) {
                currSum = a.get(i);
                currStart = i;
                maxSum = currSum;
                maxStart = currStart;
                maxEnd = i;
                currEnd = i;
            } else {

            }
*/

        /*if (a.get(i) >= 0) {
                if (i != currEnd + 1) {
                    currStart = i;
                    currSum = a.get(i);
                } else {
                    if (a.get(i) > currSum + a.get(i)) {
                        currStart = i;
                    }
                    currSum = Math.max(a.get(i), currSum + a.get(i));
                }
                currEnd = i;
            } else if (a.get(i) < 0) {
                if (currSum > maxSum ||
                        (currSum == maxSum && (maxEnd - maxStart < currEnd - currStart && currStart > maxStart))) {
                    maxSum = currSum;
                    maxStart = currStart;
                    maxEnd = currEnd;
                    if (i < a.size() && a.get(i) >= 0) {
                        i++;
                        currSum = a.get(i);
                        currEnd = i;
                        currStart = i;
                    }
                }
            }*/
        /*if (currSum > maxSum ||
                (currSum == maxSum && (maxEnd - maxStart < currEnd - currStart && currStart > maxStart))) {
            maxSum = currSum;
            maxStart = currStart;
            maxEnd = currEnd;
        }*/
        ArrayFormation.displayArrayList(maxset(new ArrayList<>(Arrays.asList(a))));
    }
}
