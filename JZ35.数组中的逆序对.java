//+++++++++++++++++++++++++++++++++++++LeetCode上的实现++++++++++++++++++++++++++++++++++++++
//===============剑指 Offer 51. 数组中的逆序对===========================
// 归并排序
// 在”并“的过程中计算逆序对数
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[nums.length];

        return reversePairs(copy, 0, nums.length - 1, temp);
    }

    /**
    * @desc: 计算数组nums[left, right]中的逆序对数，并对其排序
    *
    * @param nums: 给定数组
    * @param left：数组左索引
    * @param right：数组的右索引
    * @param temp: 中间数组
    * @return：nums[left, right]中的逆序对数
    */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        // 切分到只剩下一个数了，逆序对数为0
        if (left == right) return 0;

        int mid = left + (right - left) / 2;

        // 对左边子数组nums[left, mid]进行排序，并计算逆序对
        int leftCount = reversePairs(nums, left, mid, temp);
        // 对右边子数组nums[mid+1, right]进行排序，并计算逆序对
        int rightCount = reversePairs(nums, mid + 1, right, temp);

        // 排序后左边子数组的最后一个数小于排序后右边子数组的第一个值，说明数组nums[left, right]整体已经有序
        if (nums[mid] < nums[mid + 1]) {
            return leftCount + rightCount;
        }

        // 将nums[left, mid], nums[mid+1, right]这两个有序子数组合并为一个整体有序的数组nums[left, right],并计算逆序对  
        int mergeCount = merge(nums, left, mid, right, temp);
        
        // 组nums[left, right]中的逆序对数
        return mergeCount + leftCount + rightCount;
    }

    // 借助temp数组，将nums[left, mid], nums[mid+1, right]这两个有序子数组合并为一个整体有序的数组nums[left, right],并计算逆序对
    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int l = left; // 指向左边子数组nums[left, mid]的第一个值
        int r = mid + 1; // 指向右边子数组nums[mid+1, right]的第一个值
        int count = 0; // 记录逆序对的个数

        for (int j = left; j <= right; j++) {
            if (l < mid + 1 && r < right + 1 && temp[l] <= temp[r]) { // 注意：这里是<=
                nums[j] = temp[l];
                l++;
            } else if (l < mid + 1 && r < right + 1 && temp[l] > temp[r]) {
                nums[j] = temp[r];
                r++;
                // 计算逆序对数
                count = count + (mid - l + 1);
            } else if (l == mid + 1) { // 左边子数组已经走完了
                // 把右边子数组剩下的都到nums[left, right]中
                nums[j] = temp[r];
                r++;
            } else if (r == right + 1) { // 右边子数组走完了
                // 把右边子数组剩下的都到nums[left, right]中
                nums[j] = temp[l];
                l++;
            }
        }

        return count;
    }
}


//链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
