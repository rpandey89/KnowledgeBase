package com.knowledgebase.Arrays.problems;

import com.knowledgebase.Arrays.utils.ArrayFormation;

import java.util.*;

/**
 * Created by rahul.pandey on 4/3/17.
 */
public class AntiDiagonals {

    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        /*ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();
        if(a == null || a.size() == 0 || a.get(0) == null || a.get(0).size() == 0) {
            //do nothing
            diagonals.add(new ArrayList<>());
        } else {
            int totalRows = 0, totalCols = 0;
            ArrayList<Integer> diagonal = new ArrayList<>();
            int row = totalRows, col = totalCols;
            while(true) {
                if (row > -1 && col < a.size()) {
                    diagonal.add(a.get(row--).get(col++));
                } else {
                    diagonals.add(diagonal);
                    if (totalRows < a.size()) totalRows++;
                    if (totalCols < a.size() && totalRows == a.size()) totalCols++;
                    if (totalRows > a.size() - 1 && totalCols > a.size() - 1) {
                        break;
                    }
                    row = totalRows < a.size() ? totalRows : totalRows - 1;
                    col = totalCols;
                    diagonal = new ArrayList<>();
                }
            }
        }
        return diagonals;*/
        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();
        if (a == null || a.size() == 0 || a.get(0) == null || a.get(0).size() == 0) {
            //do nothing
            diagonals.add(new ArrayList<>());
        } else {
            int totalRows = 0, totalCols = 0;
            ArrayList<Integer> diagonal = new ArrayList<>();
            int row = totalRows, col = totalCols;
            while (true) {
                //reduce col by 1 and inc row by 1
                if (col > -1 && row < a.size()) {
                    diagonal.add(a.get(row++).get(col--));
                } else {
                    diagonals.add(diagonal);
                    //inc till col > size
                    if (totalCols < a.size()) totalCols++;
                    //inc only after col > size and till row < size to move down to next diagonal
                    if (totalRows < a.size() && totalCols == a.size()) totalRows++;
                    if (totalRows > a.size() - 1 && totalCols > a.size() - 1) {
                        break;
                    }
                    row = totalRows;
                    //dec col to col - 1 when it becomes equal to size
                    col = totalCols < a.size() ? totalCols : totalCols - 1;
                    diagonal = new ArrayList<>();
                }
            }
        }
        return diagonals;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3};
        Integer[] b = {4,5,6};
        Integer[] c = {7,8,9};
        //Integer[] a = {1,2,3};
        //Integer[] b = {4,5,6};
        //Integer[] c = {7,8,9};
        //Integer[] a = {1};
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(a)));
        arr.add(new ArrayList<>(Arrays.asList(b)));
        arr.add(new ArrayList<>(Arrays.asList(c)));

        ArrayList<ArrayList<Integer>> arr1 = diagonal(arr);
        for (ArrayList<Integer> diagonal : arr1) {
            ArrayFormation.displayArrayList(diagonal);
        }

    }

}
