//===========================剑指offer=================================
public class Solution {
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        
        if (exponent == 0) {
            return 1;
        }
        
        double res = 1;
        int flag = 0; // exponent正负标记。flag = 0，正数；flag = 1，负数
        
        if (exponent < 0) {
            flag = 1;
            exponent = 0 - exponent;
        }
        
        for (int i = 0; i < exponent; i++) {
            if (i == 0) {
                res = base * 1;
            } else {
                res = res * base;
            }
        }
        
        if (flag == 1) {
            res = 1 / res;
        }
        
        return res;
  }
}

//============================LeetCode 剑指 Offer 16. 数值的整数次方 =============================
// 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/fei-di-gui-he-di-gui-de-liang-chong-jie-jue-fang-s/
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        //如果n小于0，把它改为正数，并且把1/x提取出来一个
        if (n < 0)
            return 1 / x * myPow(1 / x, -n - 1);
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

}