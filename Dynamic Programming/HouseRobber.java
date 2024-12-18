import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] house = { 1, 2, 3, 1 };
        int result = totalAmount(house);
        System.out.println("result : "+result);
        int dp[] = new int[house.length];
        Arrays.fill( dp, -1);
        int result2 = totalAmountDp(house, dp);
        System.out.println("result : "+result2);

    }

    public static int totalAmountDp(int[] house, int[] dp){

        dp[0] = house[0];

        dp[1] = Math.max(house[0], house[1]);


        for(int i = 2 ; i < house.length; i++){

            dp[i] = Math.max(dp[i-2] + house[i], dp[i-1]);
        }

        return dp[house.length - 1];



    }





    private static int totalAmount(int[] house) {
        
        int prev = house[0];
        int prev2 = 0;
        for(int i = 1 ; i < house.length; i++){

            int taken = house[i];
            if(taken > 1)
                taken += prev2;
            int notTaken = prev ;

            int current = Math.max(taken, notTaken);

            prev2 = prev;
            prev = current;

        }

        return prev;


    }



}
