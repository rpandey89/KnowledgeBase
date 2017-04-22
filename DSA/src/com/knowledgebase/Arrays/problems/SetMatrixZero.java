package com.knowledgebase.Arrays.problems;

import com.knowledgebase.Arrays.utils.ArrayFormation;

import java.util.*;

/**
 * Created by rahul.pandey on 4/3/17.
 */
public class SetMatrixZero {
    /*
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    if (a == null || a.size() == 0 || a.get(0) == null || a.get(0).size() == 0) {
	        return;
	    } else {
	        long count = 0;
	        int row = a.size(), col = a.get(0).size();
	        for(int i=0; i<row;i++) {
	            for(int j=0; j<col;j++) {
	                if(a.get(i).get(j) == 0) {
	                    count++;
	                }
	            }
	        }
	        if(count > 0 || count < row * col) {
	            for(int i=0;i<row;i++) {
	                for(int j=0;j<col;j++) {
	                    if(a.get(i).get(j) == 0) {
	                        ArrayList<Integer> subSec = a.get(i);
	                        for(int k = 0; k < col; k++) {
	                            if(k!=j && subSec.get(k) != 0) subSec.set(k, -1);
	                        }
	                        for(int l = 0; l < row; l++) {
	                            subSec = a.get(l);
	                            if(l!=i && subSec.get(j) != 0) subSec.set(j, -1);
	                        }
	                    }
	                }
	            }

	            for(int i=0; i<row;i++) {
	                for(int j=0; j<col;j++) {
	                    if(a.get(i).get(j) == -1) {
	                        ArrayList<Integer> subSec = a.get(i);
	                        subSec.set(j, 0);
	                    }
	                }
	            }
	        }
	    }
	}
    * */

    private static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0 || a.get(0) == null || a.get(0).size() == 0) {
            return;
        } else {
            long count = 0;
            int row = a.size(), col = a.get(0).size();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (a.get(i).get(j) == 0) {
                        count++;
                    }
                }
            }
            if (count > 0 || count < row * col) {
                int rowZero = 1, colZero = 1;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (a.get(i).get(j) == 0) {
                            if(i==0) rowZero = 0;
                            if(j==0) colZero = 0;
                            ArrayList<Integer> subSec = a.get(i);
                            subSec.set(0, 0);
                            subSec = a.get(0);
                            subSec.set(j, 0);
                        }
                    }
                }


                for (int i = 1; i < row; i++) {
                    for (int j = 1; j < col; j++) {
                        if(a.get(i).get(0) != 1 || a.get(0).get(j) != 1) {
                            ArrayList<Integer> subSec = a.get(i);
                            subSec.set(j, 0);
                        }
                    }
                }

                //if anything in row 0 is zero then set everything to zero
                //if col is zero then set everything to zero in col zero
                //the reason we are doing this because these cells represent type of values in respective rows and columns
                if(rowZero == 0) {
                    for(int i=0;i<col;i++) {
                        ArrayList<Integer> subSec = a.get(0);
                        subSec.set(i, 0);
                    }
                }

                if(colZero == 0) {
                    for(int j=0;j<row;j++) {
                        ArrayList<Integer> subSec = a.get(j);
                        subSec.set(0, 0);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1,1,0};
        Integer[] b = {1,1,1};
        Integer[] c = {1,0,1};
        //Integer[] a = {1,2,3};
        //Integer[] b = {4,5,6};
        //Integer[] c = {7,8,9};
        //Integer[] a = {1};
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(a)));
        arr.add(new ArrayList<>(Arrays.asList(b)));
        arr.add(new ArrayList<>(Arrays.asList(c)));

        setZeroes(arr);
        for (ArrayList<Integer> diagonal : arr) {
            ArrayFormation.displayArrayList(diagonal);
        }


    }
}
