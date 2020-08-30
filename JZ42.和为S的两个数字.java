//=================================LeetCode上的实现:剑指 Offer 57. 和为s的两个数字=============================
// 左右指针
// 只输出一组即可
class Solution {
    public int[] twoSum(int[] nums, int target) { 
        int left = 0;
        int right = nums.length - 1;
        
		// 注意，这里的终止条件没有等号。right采用的是nums.length - 1，闭区间，终止条件left == right，此时（left == right）如果还进行操作，会造成重复
		// 可以试试数组为{1, 2, 3, 6, 7, 8, 9}, target为6时，如果加了等号，结果会出现3,3，有了重复 
        while (left < right) { 
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }
        }
        return new int[2];
    }
}


// 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/

//============================剑指offer===============================================
// 考虑所有满足target的情况

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if (array == null || array.length == 0) return new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        ArrayList<int[]> allRes = new ArrayList<>(); // 所有和为sum的结果
        ArrayList<Integer> res = new ArrayList<>(); // 乘积最小的结果
        while (left < right) {
            int val = array[left] + array[right];
            if (val == sum) {
                allRes.add(new int[]{array[left], array[right]});
                left++;   // 这两句很重要
                right--;
            } else if (val < sum) {
                left++;
            } else if (val > sum) {
                right--;
            }
        }
		
		// 如果没有符合要求的，直接返回
        if (allRes.size() == 0) return res;
		
		// 找出乘积最小的
        int min = allRes.get(0)[0] * allRes.get(0)[1];
        int minVal1 = allRes.get(0)[0];
        int minVal2 = allRes.get(0)[1];
        for (int i = 1; i < allRes.size(); i++) {
            int first = allRes.get(i)[0];
            int second = allRes.get(i)[1];
            int mul = first * second;
            if (mul < min) {
                min = mul;
                minVal1 = first;
                minVal2 = second;
            }
        }
        res.add(minVal1);
        res.add(minVal2);
        return res;
    }
    
    
}