package org.example;

class Solution {
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length,n=mat[0].length;
        int [][] dp = new int [m+1][n+1];
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+mat[i-1][j-1];
                //(2,2) = (1,2)+(2,1)-(1,1)+(1,1)--> 3+5-1+5
            }
        }
        int [][] ret = new int [m][n];
          for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                int x1 = Math.max(0,i-k)+1;
                int y1= Math.max(0,j-k)+1;
                int x2= Math.min(m-1,i+k)+1;
                int y2 = Math.min(n-1,j+k)+1;//(2,2)
                ret [i][j] = dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
                //(0,0) = (2,2)-(0,2)-(2,0)+(0,0)
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] [] arr = new int [][]{{1,2,3},{4,5,6},{7,8,9}};
        matrixBlockSum(arr,1);
    }
}