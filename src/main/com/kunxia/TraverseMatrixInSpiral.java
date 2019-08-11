package com.kunxia;

public class TraverseMatrixInSpiral {
    public static void printMatrixInSpiral(int[][] matrix, int i, int j, int m,int n){
        if(i>=m || j>=n){
            return;
        }

        //print first row
        for(int p=i; p <n; p++){
            System.out.print(matrix[i][p]+" ");
        }

        //print last col
        for(int p=i+1;p<m; p++){
            System.out.print(matrix[p][n-1]+" ");
        }

        //print last row if last and first row are not the same. special about the ending condition.
        if(m-1!=i){
            for(int p=n-2;p>=j;p--){
                System.out.print(matrix[m-1][p]+" ");
            }
        }

        //print first column if last and first column are not the same
        if(n-1!=j){
            for(int p=m-2;p>i;p--){
                System.out.print(matrix[p][j]+" ");
            }
        }

        printMatrixInSpiral(matrix,i+1,j+1,m-1,n-1);
    }

    public static void main(String[] args){
        int a[][] = { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };
        TraverseMatrixInSpiral.printMatrixInSpiral(a,0,0,3,6);
    }
}
