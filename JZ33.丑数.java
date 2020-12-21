//============================LeetCode 剑指 Offer 49. 丑数 =================
//链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
//=========================剑指offer ==============================
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        int a = 0;
        int b = 0;
        int c = 0;
        
        int[] dp = new int[index];
        dp[0] = 1;
        
        for (int i = 1; i < index; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            
            dp[i] = Math.min(Math.min(n2, n3), n5);
            
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        
        return dp[index - 1];
    }
}