import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;

        int result = coinChange(coins, amount, coins.length - 1);
        System.out.println("Fewest number of coins: " + result);

        int dp[][] = new int[coins.length][amount + 1];
        for (int a[] : dp) {
            Arrays.fill(a, -1);

        }

       System.out.println("Fewest number of coins: " + coinChangedp(coins, amount, coins.length -1, dp));

    }

    private static int coinChange(int[] coins, int amount, int index) {

        // base condition
        if (index < 0) return Integer.MAX_VALUE; // No more coins to use

        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;

        int notaken = 0 + coinChange(coins, amount, index - 1);
        int taken = Integer.MAX_VALUE;

        if (amount >= coins[index])
            taken = 1 + coinChange(coins, amount - coins[index], index);

        return Math.min(notaken, taken);

    }

    private static int coinChangedp(int[] coins, int amount, int index, int dp[][]) {

        if (index < 0) return Integer.MAX_VALUE; // No more coins to use

        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
      
        if (dp[index][amount] != -1)
            return dp[index][amount];

        int notaken = 0 + coinChangedp(coins, amount, index - 1, dp);
        int taken = Integer.MAX_VALUE;

        if (amount >= coins[index])
            taken = 1 + coinChangedp(coins, amount - coins[index], index,dp);

        return dp[index][amount] = Math.min(notaken, taken);

    }
}
