//====================剑指offer===================
//---------------------方法1------------------------
public class Solution {
    public int Add(int num1,int num2) {
        return Integer.sum(num1, num2);
    }
}
//---------------------方法2---------------------
public class Solution {
    public int Add(int num1,int num2) {
        if (num1 == 0) {
            return num2;
        }

        if (num2 == 0) {
            return num1;
        }

        int sum = 0;    // 无符号和
        int carry = 0;    // 进位

        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }

        return num1;
    }
}
//=================LeetCode 剑指 Offer 65. 不用加减乘除做加法======================
//链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
class Solution {
    public int add(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        int sum = 0;    // 无符号和
        int carry = 0;    // 进位

        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
}