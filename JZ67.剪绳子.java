import java.util.*;
public class Solution {
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        
        if (target == 3) {
            return 2;
        }
        
        int[] dp = new int[target + 1];  // dp数组的含义是:dp[i]表示长度为i时，可以得到的最大乘积
        Arrays.fill(dp, Integer.MIN_VALUE);
        
		// base case
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for (int i = 4; i <= target; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i-j] * dp[j], dp[i]);
            }
        }
        
        return dp[target];
    }
}