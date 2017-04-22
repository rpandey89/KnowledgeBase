package com.knowledgebase.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 4/3/17.
 */
public class HotelBookings {
    private static int partition(ArrayList<Integer> points, int start, int end) {
        int pivotValue = points.get(end);
        int pIndex = start;
        for(int i=start;i<end;i++) {
            int currentDay = points.get(i);
            if(currentDay <= pivotValue) {
                points.set(i, points.get(pIndex));
                points.set(pIndex, currentDay);
                pIndex++;
            }
        }
        int endDay = points.get(end);
        points.set(end, points.get(pIndex));
        points.set(pIndex, endDay);
        return pIndex;
    }

    private static void sort(ArrayList<Integer> points, int start, int end) {
        if(start < end) {
            int pIndex = partition(points, start, end);
            sort(points, start, pIndex - 1);
            sort(points, pIndex + 1, end);
        }
    }

    private static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if(arrive.size() == 0 && depart.size() == 0 && K == 0) return true;
        if(arrive.size() == 0 || depart.size() == 0 || K == 0 || arrive.size() != depart.size()) return false;
        sort(arrive, 0, arrive.size() - 1);
        sort(depart, 0, depart.size() - 1);
        int i=0,j=0, count=0;
        while(i < arrive.size() && j < depart.size()) {
            while(j < depart.size() && depart.get(j) <= arrive.get(i)) {
                j++;
                count--;
            }

            while(i < arrive.size() && arrive.get(i) < depart.get(j)) {
                count++;
                i++;
                if(count > K) break;
            }
            if(count > K) break;
        }

        return count <= K;
    }

    public static void main(String[] args) {
        //Integer[] A = {30, 12, 15, 2, 21, 12, 1, 31, 7, 40, 29, 6, 48, 19, 23, 10, 26, 6, 20, 44, 44, 34, 44, 38};
        //Integer[] B = {36, 54, 47, 19, 66, 33, 41, 69, 23, 80, 64, 28, 93, 23, 62, 15, 49, 19, 58, 64, 60, 60, 57, 82};
        //int C = 23;
        Integer[] A = {1, 2, 3};
        Integer[] B = {2, 3, 4};
        int C = 1;
        System.out.println(hotel(new ArrayList<>(Arrays.asList(A)), new ArrayList<>(Arrays.asList(B)), C));
        /*ArrayList<Integer> arrive = new ArrayList<>(com.knowledgebase.Arrays.asList(A));
        ArrayList<Integer> depart = new ArrayList<>(com.knowledgebase.Arrays.asList(B));
        sort(arrive, depart, 0, A.length - 1);
        ArrayFormation.displayArrayList(arrive);
        ArrayFormation.displayArrayList(depart);*/
    }
}
