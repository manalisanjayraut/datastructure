import java.util.Arrays;

public class HouseRobber2 {

    
    public static void main(String[] args) {
        int[] house = { 1, 2, 3, 1 };
        int n = house.length;
        int result = totalAmount(house, 0, n-2);
        int result1 = totalAmount(house, 1, n-1);
        System.out.println("result : "+ Math.max(result, result1));

        int dp[] = new int[house.length];
        Arrays.fill( dp, -1);
        
        int result2 = totalAmountDp(house, dp , 0, n-2);

        int dp2[] = new int[house.length];
        Arrays.fill( dp2, -1);
       
        int result3 = totalAmountDp(house, dp2 , 1, n-1);
        System.out.println("result : "+ Math.max(result2, result3));

    }

    private static int totalAmount(int[] house, int start, int end){

        int prev2 = 0;
        int prev = house[start];

        for( int i = start + 1 ; i <= end ; i ++){
            int taken = house[i];

            if(taken > 1)
                taken += prev2;
            
            int notTaken = 0 + prev;

            int current = Math.max(taken, notTaken);

            prev2 = prev;
            prev = current;
        }
        return prev;

    }
    public static int totalAmountDp(int[] house, int[] dp, int start, int end){

        dp[start] = house[start];

        if(start + 1 <= end)
        dp[start + 1] = Math.max(dp[start], dp[start + 1]);

        for(int i = start + 2; i <=end ; i ++){

            dp[i] = Math.max(dp[i-2] + house[i], dp[i-1]);
        }

        return dp[end];

    }

    
}
