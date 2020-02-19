import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 17:17
 */
public class LeetCode91 implements Important {
    private static boolean canDecode(char a, char b) {
        int x = a - '0';
        if(x == 0) {
            return false;
        }

        int y = b - '0';
        int s = 10 * x + y;
        return s <= 26;
    }

    private static boolean canDecode(char a) {
        return a - '0' != 0;
    }

    public int numDecodings(String str) {
        int len = str.length();

        char[] s = str.toCharArray();
        int[] dp = new int[len + 1];
        dp[len] = 1;

        if(canDecode(s[len - 1])) {
            dp[len - 1] = 1;
        }

        if(len == 1) {
            return dp[0];
        }

        for (int i = len - 2; i >= 0; i--) {
            if(!canDecode(s[i])) {
                dp[i] = 0;
                continue;
            }

            if(canDecode(s[i], s[i + 1])) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode91().numDecodings("112101210123"));
    }

}
