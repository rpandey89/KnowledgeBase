package com.Arrays.problems;

/**
 * Created by rahul.pandey on 3/25/17.
 */
public class SudokuChecker {

    private static boolean checkRowConstraint(int[][] partialSudoku) {
        for (int i = 0; i < partialSudoku.length; i++) {
            if (!checkIfPresent(partialSudoku, i, 0, i + 1, partialSudoku[0].length)) return false;
        }
        return true;
    }

    private static boolean checkColumnConstraint(int[][] partialSudoku) {
        for (int i = 0; i < partialSudoku[0].length; i++) {
            if (!checkIfPresent(partialSudoku, 0, i, partialSudoku.length, i + 1)) return false;
        }
        return true;
    }

    private static boolean checkAreaConstraint(int[][] partialSudoku) {
        double areaRow = Math.sqrt(partialSudoku.length);
        double areaCol = Math.sqrt(partialSudoku[0].length);
        for (int i = 0; i < areaRow; i++) {
            double rowStart = i * areaRow;
            for (int j = 0; j < areaCol; j++) {
                double colStart = j * areaCol;
                if (!checkIfPresent(partialSudoku, rowStart, colStart, rowStart + areaRow, colStart + areaCol))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkIfPresent(int[][] partialSudoku, double startRow, double startCol, double endRow, double endCol) {
        boolean[] presentArray = new boolean[partialSudoku.length + 1];
        for (int i = (int) startRow; i < endRow; i++) {
            for (int j = (int) startCol; j < endCol; j++) {
                if (partialSudoku[i][j] > 0 && !presentArray[partialSudoku[i][j]])
                    presentArray[partialSudoku[i][j]] = true;
                else if (presentArray[partialSudoku[i][j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] partialSudoku = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        if (checkRowConstraint(partialSudoku) && checkColumnConstraint(partialSudoku) && checkAreaConstraint(partialSudoku)) {
            System.out.println("valid sudoku");
        } else {
            System.out.println("Invalid sudoku");
        }
    }

}
