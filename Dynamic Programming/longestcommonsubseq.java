public class longestcommonsubseq {

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        int result = function(text1, text2);

        System.out.println("result is : " + result);

    }

    public static int function(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    /*
                     * Why Diagonal?
                     * When s1[i-1] == s2[j-1], it means that the characters from both strings at
                     * this position match. Therefore, the LCS of the first i characters of s1 and
                     * the first j characters of s2 can be extended by this matching character.
                     * The new LCS length is the LCS of the previous i-1 characters of s1 and the
                     * previous j-1 characters of s2 (this is found in the diagonal cell
                     * dp[i-1][j-1]), plus one (for the matched character).
                     * Example:
                     * If s1 = "ABC" and s2 = "AC", at i=3 and j=2, both s1[2] = 'C' and s2[1] = 'C'
                     * match.
                     * So, dp[3][2] = dp[2][1] + 1 = 1 + 1 = 2.
                     */
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    /*
                     * 
                     * Why Left?
                     * 
                     * When s1[i-1] != s2[j-1], it means that you cannot extend the LCS by including
                     * s1[i-1] or s2[j-1]. Instead, you need to decide whether it is better to:
                     * Exclude the current character of s1 (move up in the table), or
                     * Exclude the current character of s2 (move left in the table).
                     * Since we are looking for the longest subsequence, we take the maximum of the
                     * two possibilities:
                     * dp[i - 1][j]: The LCS excluding the current character from s1 (move up).
                     * dp[i][j - 1]: The LCS excluding the current character from s2 (move left).
                     * Example:
                     * 
                     * If s1 = "ABC" and s2 = "AC", at i=2 and j=2, we have s1[1] = 'B' and s2[1] =
                     * 'A' which don't match.
                     * In this case, dp[2][2] = Math.max(dp[1][2], dp[2][1]) = Math.max(0, 1) = 1,
                     * meaning the LCS length is 1 up to this point.
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[n][m];

    }

}