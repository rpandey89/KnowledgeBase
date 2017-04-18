package com.Arrays.problems;

import com.Arrays.utils.ArrayFormation;

import java.util.ArrayList;

/**
 * Created by rahul.pandey on 3/31/17.
 */
public class FlipString {

    private static ArrayList<Integer> flip(String A) {
        int length = A.length();
        ArrayList<Integer> indices = new ArrayList<>();
        if(length == 1) return indices;
        int count = 0;
        for(int i=0; i< length; i++) {
            if(Integer.parseInt(String.valueOf(A.charAt(i))) == 1) count++;
        }
        if(count == length) return indices;
        int sum = Integer.parseInt(String.valueOf(A.charAt(0)));
        sum = sum == 1 ? -1 : 1;
        int startIndex = 0, currMax = sum, prevSum = sum, endIndex = 0;
        for (int i = 1; i < length; i++) {
            int num = Integer.parseInt(String.valueOf(A.charAt(i)));
            num = num == 1 ? -1 : 1;
            sum = sum + num;
            if (currMax < num) {
                currMax = num;
                if (startIndex != i + 1 && sum < currMax) {
                    startIndex = i;
                    sum = Math.max(currMax, sum);
                }
            }
            if (prevSum < sum) {
                prevSum = sum;
                endIndex = i;
            }
        }
        indices.add(startIndex + 1);
        indices.add(endIndex + 1);
        return indices;

    }

    public static void main(String[] args) {
        ArrayFormation.displayArrayList(flip("0111000100010"));
        //01110101011111
        //0111000100010
        //Work In Progress
    }

}

/*
public class Solution {

    public ArrayList<Integer> flip(String A) {

        char[] nums= A.toCharArray();

        ArrayList<Integer> result = new ArrayList<Integer>();

        if(isAllOnes(nums))

            return result;



        // Left, Right, Max

        int L=0,R=0,max =0;



        // Current Left, Current Right, current Max;

        int cL =0,cR=0,currentMax = 0;

        for(int i=0;i<nums.length;i++) {

            currentMax = currentMax + (nums[i] == '0'? 1: -1);

            // if currentMax is greater than zero, currentRight should be I

            // in order to pass it to the Right when currentMax> Max  (during the future iterations)

            if(currentMax>=0)

                cR = i;

            //  currentMax is zero, so currentLeft should begin with i+1

            //  in order to pass it to the Left, when currentMax > max (during the future iterations)

            else {

                currentMax =0;

                cL = i+1;

            }

            if(currentMax>max) {

                max = currentMax;

                L = cL;

                R = cR;

            }

        }

        result.add(L+1);

        result.add(R+1);

        return result;



    }



    public boolean isAllOnes(char[] nums) {

        for(int i = 0;i<nums.length;i++) {

            if(nums[i]=='0') return false;

        }

        return true;

    }

}


* */