import java.util.Scanner;

public class ClimbStairs {

    public static void main(String args[]) {

        System.out.println("enter no of steps");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int climbs = climbstairs(n);

        System.out.println("no of climbs : "+climbs);


        int climbsdp = optimal(n);

        
        System.out.println("no of climbs by dp : "+climbsdp);

    }

    private static int climbstairs(int n) {

        if (n == 0)
            return 1;
        else if (n == 1)
            return 1;

        return climbstairs(n - 1) + climbstairs(n - 2);

    }

    private static int optimal(int n){

        if( n == 0 || n ==1){
            return 1;
        }

        
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        

        for(int i = 2 ; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }

}