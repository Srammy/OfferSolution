//===============LeetCode 剑指 Offer 39. 数组中出现次数超过一半的数字========================
//将数组排序，数组中点的元素一定为出现次数超过一半的数字。
class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int mid = 0;
       
        Arrays.sort(nums);
        mid = length / 2;

        return nums[mid];        
    }
}
//=============剑指offer=============================
//使用Map实现
import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> numAppearTimesMap = new HashMap<>();
        for (int num : array) {
            if (!numAppearTimesMap.containsKey(num)) {
                numAppearTimesMap.put(num, 1);
            } else {
                int appearTimes = numAppearTimesMap.get(num);
                appearTimes++;
                numAppearTimesMap.put(num, appearTimes);
            }
        }
        for (int num : array) {
            if (numAppearTimesMap.get(num) > array.length / 2) {
                return num;
            }
        }
        return 0;
    }
}