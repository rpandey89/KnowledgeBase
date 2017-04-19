package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

import java.util.ArrayList;

/**
 * Created by rahul.pandey on 3/31/17.
 */
public class FlipString {

    //the idea is to flip 0's to 1 and 1's to -1
    //to maximize number of 1s we have to find sub array with maximum sum
    //for that we use Kadane's algo
    private static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> indices = new ArrayList<>();
        if(A != null && A.trim().length() > 0) {
            int currStart = 0, currEnd = 0, currSum = 0, maxSum = 0, maxEnd = -1, maxStart = -1;
            while(currEnd < A.length()) {
                currSum += ((A.charAt(currEnd) - '0') == 0 ? 1 : -1);
                if(currSum < 0) {
                    currSum = 0;
                    currStart = currEnd + 1;
                } else {
                    if(maxSum < currSum) {
                        maxSum = currSum;
                        maxStart = currStart;
                        maxEnd = currEnd;
                    }
                }
                currEnd++;
            }
            if(maxSum >=0 && maxEnd > -1) {
                indices.add(maxStart + 1);
                indices.add(maxEnd + 1);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        ArrayFormation.displayArrayList(flip("0111000100010"));
    }

}