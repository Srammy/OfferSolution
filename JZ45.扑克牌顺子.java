//====================LeetCode 剑指 Offer 61.扑克牌中的顺子==============================
/*
注意：
1.数组中值为0的，表示这是joker
2.joker可以在数组中的任意位置
*/
// 参考链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
//========方法1 数组排序====================
class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0) joker++; // 排序后，大小王一定在数组前面。统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
//==========方法2：集合去重=================
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> numSet = new HashSet<>();  // 牌面集合
        int max = 0; // 记录目前的最大值
        int min = 14; // 记录目前的最小值
        for (int num : nums) {
            // 跳过大小王（值为0）
            if (num == 0) {
                continue;
            }
            // 如果这张牌已经出现过，说明重复了，直接返回false
            if (numSet.contains(num)) {
                return false;
            }
            // 更新最大、最小值
            max = Math.max(max, num);
            min = Math.min(min, num);
            // 添加到牌面集合中
            numSet.add(num);
        }
        // 最大牌 - 最小牌 < 5 && 没有重复，则可构成顺子
        return max - min < 5;
    }
}

//=================================剑指offer======================================
import java.util.*;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        
        Set<Integer> numSet = new HashSet<>();  // 牌面集合
        int max = 0; // 记录目前的最大值
        int min = 14; // 记录目前的最小值
        for (int num : numbers) {
            // 跳过大小王（值为0）
            if (num == 0) {
                continue;
            }
            // 如果这张牌已经出现过，说明重复了，直接返回false
            if (numSet.contains(num)) {
                return false;
            }
            // 更新最大、最小值
            max = Math.max(max, num);
            min = Math.min(min, num);
            // 添加到牌面集合中
            numSet.add(num);
        }
        // 最大牌 - 最小牌 < 5 && 没有重复，则可构成顺子
        return max - min < 5;
    }
}