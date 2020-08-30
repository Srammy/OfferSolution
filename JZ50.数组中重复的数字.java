//================================LeetCode上的实现==================================
//+++++++++++++剑指 Offer 03. 数组中重复的数字+++++++++++++++++++++++++++
// 方法1：两次遍历
class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> numAppearTimesMap = new HashMap<>(); // 记录数组中每个值的出现次数
        int numAppearTimes = 0;
        for (int i : nums) {
            if (!numAppearTimesMap.containsKey(i)) {
                numAppearTimesMap.put(i, 1);
            } else {
                numAppearTimes = numAppearTimesMap.get(i);
                numAppearTimes++;
                numAppearTimesMap.put(i, numAppearTimes);
            }
        }

        for (Integer key : numAppearTimesMap.keySet()) {
            numAppearTimes = numAppearTimesMap.get(key);
            if (numAppearTimes > 1) {
                return key;
            }
        }

        return -1;
    }
}

// 方法2：一次遍历
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> hasIndexedValueSet = new HashSet<>(); // 几轮已经没有重复的数字
        for (int i : nums) {
            if (hasIndexedValueSet.contains(i)) { // 这个数字已经出现过了，说明重复了，直接返回这个值即可
                return i;
            } else {
                hasIndexedValueSet.add(i);
            }
        }
        return -1;
    }
}
// 方法3：最佳
// 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/yuan-di-zhi-huan-shi-jian-kong-jian-100-by-derrick/
class Solution {
    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return -1;
    }
}

//================================剑指offer上的实现==================================
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) return false;

        int temp = 0;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        // 没有重复值
        duplication[0] = -1;
        return false;
    }
}
