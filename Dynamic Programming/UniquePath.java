import java.util.Arrays;

public class UniquePath {

    public static void main (String args[]){

        int m = 3, n= 7;
        int dp[][] = new int[m + 1][n + 1];

        for(int[] i : dp) Arrays.fill(i, -1);

        int result = function(m-1, n-1, dp);

        System.out.println("result of unique path : " + result);

    }

    public static int function(int i , int j , int[][] dp){

        if( i < 0 || j < 0) return 0;

        if(i == 0 && j == 0) return 1;

        if(dp[i][j] != -1 ) return dp[i][j];

        int up = function(i - 1, j, dp);
        int left = function(i, j - 1, dp);

        dp[i][j] = up + left;

        return up + left;

    }
    
}
