//=============================LeetCode上的实现 剑指 Offer 11. 旋转数组的最小数字=======================
//----------------------------方法1-----------------------------
class Solution {
    public int minArray(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}
//---------------------------方法2：二分法-----------------------
class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) left = mid + 1;
            else if (numbers[mid] < numbers[right]) right = mid;
            else right--;
        }
        return numbers[left];
    }
}