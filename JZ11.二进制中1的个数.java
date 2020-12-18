//=================================LeetCode 剑指 Offer 15. 二进制中1的个数=============================
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String tb = Integer.toBinaryString(n);
        int numberOf1 = 0;
        for (int i = 0;  i < tb.length(); i++) {
            if (tb.charAt(i) == '1') {
                numberOf1 = numberOf1 + 1;
            }
        }
        return numberOf1;
    }
}

//===========================剑指offer======================
public class Solution {
    public int NumberOf1(int n) {
        String tb = Integer.toBinaryString(n);
        int numberOf1 = 0;
        for (int i = 0;  i < tb.length(); i++) {
            if (tb.charAt(i) == '1') {
                numberOf1 = numberOf1 + 1;
            }
        }
        return numberOf1;
    }
}