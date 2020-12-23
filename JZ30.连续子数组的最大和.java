import java.util.*;
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];  // dp数组的含义是:dp[i]表示到array[i]为止，所有子数组的和的最大值； array[i] 为结尾的「最大子数组和」为 dp[i]
        
        Arrays.fill(dp, Integer.MIN_VALUE);
        
        dp[0] = array[0]; // base case
        
        // 归纳法的使用
        for (int i = 1; i < dp.length; i++) {
           dp[i] = Math.max(dp[i-1] + array[i], array[i]);
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}