package dev.sethaker;

import java.util.Random;


public class MatrixBuilder {

    public int[][] buildBasicMatrix(int rowNums, int columnNums, int insideNums) {
        int[][] matrix = new int[rowNums][columnNums];
        for (int i = 0; i < rowNums; i++) {
            for (int j = 0; j < columnNums; j++) {
                matrix[i][j] = insideNums;
            }
        }
        return matrix;
    }

    public int[][] buildRandomMatrix(int rowNums, int columnNums, int numLimit) {
        Random rand = new Random();
        int[][] matrix = new int[rowNums][columnNums];
        for (int i = 0; i < rowNums; i++) {
            for (int j = 0; j < columnNums; j++) {
                matrix[i][j] = rand.nextInt(numLimit);
            }
        }
        return matrix;
    }
}
