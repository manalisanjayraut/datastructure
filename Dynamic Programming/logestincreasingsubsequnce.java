import java.util.Arrays;

public class logestincreasingsubsequnce {



    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = function(nums);

        System.out.println("result ===>" + result);

    }

    public static int function(int[] nums){

        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1 ; i < n ; i++ ){
            for(int j = 0; j < i ; j++){
                if(nums[i] > nums[j])
                   dp[i] = Math.max( dp[i], dp[j] + 1);
            }
        }
           

        int max = 0;
        for(int i : dp){
            max = Math.max(max, i);
        }
        return max;

    }
    
}
