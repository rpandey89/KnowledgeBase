package com.Arrays.problems; /**
 * Created by rahul.pandey on 3/19/17.
 */
import java.util.*;

public class Spiral2DArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        a.add(arr);
        arr = new ArrayList<>();
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        a.add(arr);
        arr = new ArrayList<>();
        arr.add(9);
        arr.add(10);
        arr.add(11);
        arr.add(12);
        a.add(arr);
        arr = new ArrayList<>();
        arr.add(13);
        arr.add(14);
        arr.add(15);
        arr.add(16);
        a.add(arr);
        System.out.println("Result " + sol.spiralOrder(a));

    }
}

class Solution {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int bottomRowPointer = a.size() - 1, rightColPointer = a.get(0).size() - 1, topRowPointer = 0, leftColPointer = 0;
        int dir = 0;
        while(topRowPointer <= bottomRowPointer && leftColPointer <= rightColPointer) {
            if(dir == 0) {
                for(int i = leftColPointer; i <= rightColPointer; i++) {
                    result.add(a.get(topRowPointer).get(i));
                }
                dir = 1;
                topRowPointer++;
            } else if(dir == 1) {
                for(int i = topRowPointer; i <= bottomRowPointer; i++) {
                    result.add(a.get(i).get(rightColPointer));
                }
                dir = 2;
                rightColPointer--;
            } else if(dir == 2) {
                for(int i = rightColPointer; i >= leftColPointer; i--) {
                    result.add(a.get(bottomRowPointer).get(i));
                }
                dir = 3;
                bottomRowPointer--;
            } else if(dir == 3) {
                for(int i = bottomRowPointer; i >= topRowPointer; i--) {
                    result.add(a.get(i).get(leftColPointer));
                }
                dir = 0;
                leftColPointer++;
            }
        }
        // Populate result;
        return result;
    }
}
