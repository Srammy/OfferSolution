//===========================剑指offer ============================
// 链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
public class Solution {
    public int Sum_Solution(int n) {
        boolean x = n > 1 && (n += Sum_Solution(n - 1)) > 0;
        return n;
    }
}