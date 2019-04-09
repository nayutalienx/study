package com.company;


import java.util.ArrayList;
import java.util.ListIterator;

public class IntellectMatr {
    private int[][] matr;
    public int[][] getMatr() { return matr; }
    public IntellectMatr(int[][] matr){
        this.matr = matr;
    }

    public int[] getColumnProductVector() {
        int[][] matrix = this.matr;
        int[] result = new int[matrix[0].length];
        for(int j = 0; j<matrix[0].length;j++){
            int tempSum = 0;
            for(int i = 0; i<matrix.length;i++){
                if(matrix[i][j] > 0 && i == 0){
                    tempSum += matrix[i][j];
                } else if(matrix[i][j] > 0){
                    tempSum = tempSum * matrix[i][j];

                }
            }
            result[j] = tempSum;
        }
        return result;
    }

    public int[][] toMakeZero(int A){
        int[][] matrix = this.matr;
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(Math.abs(matrix[i][j]) < A){
                    result[i][j] = 0;
                } else {
                    result[i][j] = matrix[i][j];
                }
            }
        }
        return result;
    }

    public int getRowSumAbove(int a){
        int result = 0;
        int[][] matrix = this.matr;
        for(int i = 0; i < matrix.length; i++){
            int tempSum = 0;
            for(int j = 0; j < matrix[0].length; j++){
                tempSum += matrix[i][j];
            }
            if(tempSum > a){
                return i + 1;
            }
        }
        return -1; // there aren't such rows
    }

    public int[][] deleteRowSumUnder(int a){
        int[][] result = null;
        int[][] matrix = this.matr;
        ArrayList<Integer> rowsToDelete = new ArrayList<Integer>();
        for(int i = 0; i < matrix.length; i++){
            int tempSum = 0;
            for(int j = 0; j < matrix[0].length; j++){
                tempSum += matrix[i][j];
            }
            if(tempSum > a){
                rowsToDelete.add(i);
            }
        }
        if(matrix.length - rowsToDelete.size() == 0) return null;
        result = new int[matrix.length - rowsToDelete.size()][matrix[0].length];
        int counter = 0; int rows = 0;
        for(int i = 0; i < matrix.length; i++){
            if(rowsToDelete.get(counter) == i){
                counter++;
                continue;
            } else {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[rows][j] = matrix[i][j];
                }
                rows++;
            }
        }


        return result;
    }

    public void putMatr(){
        if((matr == null) || (matr[0] == null)) return;
        for(int i = 0; i < matr.length;i++){
            for(int j = 0; j < matr[0].length; j++){
                System.out.printf("%7d", matr[i][j]);
            }
            System.out.println();
        }
    }
}
