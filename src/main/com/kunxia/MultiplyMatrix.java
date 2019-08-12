package com.kunxia;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] A, int[][] B) throws IllegalArgumentException{
        int aRows=A.length;
        int aCols=A[0].length;
        int bRows=B.length;
        int bCols=B[0].length;

        int[][] C = new int[aRows][bCols];
        for(int i=0; i<aRows;i++){
            for(int j =0; j<bCols;j++){
                for(int k=0; k<aCols;k++){
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args){
        int[][] A={{4,3},{2,1}};
        int[][] B={{3,2},{6,3}};
        MultiplyMatrix.multiply(A,B);
    }
}
