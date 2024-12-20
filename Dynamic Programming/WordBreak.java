import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String args[]) {

        List<String> dic = Arrays.asList("leet", "code");
        String s = "leetcode";

        System.out.println("result is " + function(s, dic, 0));

        boolean dp[] = new boolean[s.length() + 1];
        ;
        Arrays.fill(dp, false);

        System.out.println("result is " + function_memo(s, dic, 0, dp));

        System.out.println("result is " + function_tabular(s, dic, 0, dp));

    }

    private static boolean function(String s, List<String> dic, int index) {

        if (index == s.length())
            return true;

        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);

            if (dic.contains(substring) && function(s, dic, i))
                return true;

        }

        return false;

    }

    private static boolean function_memo(String s, List<String> dic, int index, boolean dp[]) {

        if (index == s.length())
            return true;

        if (dp[index] == true)
            return true;

        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);

            if (dic.contains(substring) && function(s, dic, i)) {
                dp[index] = true;
                return true;
            }

        }

        dp[index] = false;

        return false;

    }

    private static boolean function_tabular(String s, List<String> dic, int index, boolean dp[]) {

        if (index == s.length())
            return true;

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                String substring = s.substring(j, i);

                if (dic.contains(substring) && dp[j] == true) {
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[s.length()];

    }

}
