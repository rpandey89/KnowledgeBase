package com.Arrays.problems;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by rahul.pandey on 3/31/17.
 */
public class WaveArray {
    private static ArrayList<Integer> wave(ArrayList<Integer> a) {
        int size = a.size();
        if(size == 1) return a;
        Collections.sort(a);
        for(int i=0;i<size - (size % 2) - 1;i = i + 2) {
            Collections.swap(a, i, i + 1);
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
