import java.util.Arrays;

public class PartitionEqualSubsetSum{

    public static void main(String[] args) {
        int[] nums = {1,1};

        int n = nums.length;
        int totalsum = 0;
        boolean result = false;
        for(int i : nums) totalsum += i;
        
        if(totalsum % 2 != 0) result = false;
        
        int target = totalsum / 2;

        int[][] dp = new int[n + 1][target + 1];

        for(int[] i : dp) Arrays.fill(i, -1);

        result = function(n-1, target, nums , dp);

        System.out.println("result ===>" + result);

    }

    public static boolean function(int index, int target, int[] nums, int[][] dp){

        if(target == 0) return true;

        if(index == 0) return nums[index] == target ;

        if(dp[index][target] != -1) return dp[index][target] == 1;

        boolean notTaken = function(index - 1, target, nums, dp);

        boolean taken = false;

        if(nums[index] <= target) taken = function(index - 1, target - nums[index], nums, dp);

        dp[index][target] = (taken || notTaken ) ? 1 : 0;

        return taken || notTaken;

    }


}