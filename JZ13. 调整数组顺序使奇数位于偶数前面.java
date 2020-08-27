//======================LeetCode上的实现（不需要维护奇数和偶数中的先后顺序------>不稳定）=======================
//---------------------方法1：双指针，空间复杂度O(N)--------------------------------------
class Solution {
    public int[] exchange(int[] nums) {
        int length = nums.length;

        int[] res = new int[length];
		// 头尾双指针
        int oddIndex = 0;
        int evenIndex = length - 1; 

        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 1) {
                res[oddIndex] = nums[i];
                oddIndex++;
            } else {
                res[evenIndex] = nums[i];
                evenIndex--;
            }
        }

        return res;
    }
}
//----------------------方法2：双指针，空间复杂度O(1)-----------------------
class Solution {
    public int[] exchange(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int temp = 0;

        while (left < right) {
			// 右移，直到偶数停止
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
			// 左移，直到奇数停止
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

			// 交换
            if (left < right) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            
        }

        return nums;
    }
}
//============================剑指offer上的实现（需要维护奇数和偶数中的先后顺序------->稳定）================
//---------------方法1：定义一个额外的数组。两次遍历原数组，第一次遍历把奇数放到新的数组，第二次遍历把偶数放到新的数组，最后再把新数组复制回原数组--------
//---------------方法2：按照冒泡排序（稳定）的思路-------------------------------------------------（）-------------------------------------------------
// 直接套用冒泡排序的框架
public class Solution {
    public void reOrderArray(int [] array) {
        int length = array.length;
        int temp = 0;
        boolean swapFlag = false;
        for (int i = 0; i < length - 1; i++) { // 控制轮数
            for (int j = 0; j <  length - 1 - i; j++) { // 每一轮操作
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapFlag = true;
                }
            }
            
            // 某一轮操作中没有交换，说明已经达到目标，直接结束操作
            if (!swapFlag) {
                return;
            } else { // 某一轮中有交换，则继续下一轮操作
                swapFlag = false;
            }
        }
    }
}