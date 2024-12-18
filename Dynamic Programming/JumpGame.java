import java.util.Arrays;

public class JumpGame {

    public static void main(String args[]) {

        int a[] = { 2, 3, 1, 1, 4 };

        System.out.println("min path :" + function(a, a.length - 1));

        int dp[] = new int[a.length + 1];

        Arrays.fill(dp, -1);

        System.out.println("min path using memo :" + functionDP(a, a.length - 1, dp));

        System.out.println("min path using tabulization:" + functionDPT(a, a.length - 1, dp));


    }

    public static int functionDPT(int[] nums, int index, int[] dp) {

        // base

        if (index == 0)
            return 0;

        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            int previous = Math.abs(nums[i] - nums[i - 1]) + dp[i - 1];
            int secondPrevious = 0;
            if (i > 1)
                secondPrevious = Math.abs(nums[i] - nums[i - 2]) + dp[i - 2];

            dp[i] = Math.min(previous, secondPrevious);
        }

        //

        return dp[nums.length-1];
    }

    public static int functionDP(int[] nums, int index, int[] dp){

        //base

        if(index == 0) return 0;

        if(dp[index] == 0) return dp[index];

        //
        int previous =  Math.abs(nums[index] - nums[index - 1]) + functionDP(nums, index  - 1, dp);

        int secondPrevious = 0;
        if(index > 1)
            secondPrevious = Math.abs(nums[index] - nums[index - 2]) + functionDP(nums, index  - 2, dp);
            
        dp[index] = Math.min(previous, secondPrevious);

        return Math.min(previous, secondPrevious);
            
      
    }

    public static int function(int nums[], int index) {

        if (index == 0)
            return 0;

        int i = function(nums, index - 1) + Math.abs(nums[index] - nums[index - 1]);

        int j = 0;
        if (index > 1)
            j = function(nums, index - 2) + Math.abs(nums[index] - nums[index - 2]);

        return Math.min(i, j);
    }





}