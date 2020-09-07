//+++++++++++++++++++++++++++++++++++++LeetCode上的实现++++++++++++++++++++++++++++++++++++++
//===============剑指 Offer 51. 数组中的逆序对===========================
/**
归并排序
在”并“的过程中计算逆序对数
方法1和方法2只是用了两种不同的归并排序写法，本质上是一样的
*/
//-------------------------------方法1--------------------------------------
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

//------------------------------方法2------------------------------------------------------
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        return MergeSort(nums, 0, nums.length-1);
    }

    private int MergeSort(int[] array, int start, int end){
        if(start>=end) return 0;
        int mid = (start+end)/2;
        int leftCount = MergeSort(array, start, mid);
        int rightCount = MergeSort(array, mid+1, end);
        
        if (array[mid] < array[mid + 1]) {
            return leftCount + rightCount;
        }
        
        int crossPairs = MergeOne(array, start, mid, end);
        return leftCount + rightCount + crossPairs;
    }
    
    private int MergeOne(int[] array, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int k=0,i=start,j=mid+1;
        int count = 0;
        while(i<=mid && j<= end) { 
            //如果前面的元素小于后面的不能构成逆序对
            if(array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {  //如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                temp[k++] = array[j++];
                count = count + (mid-i+1);
            }
        }
        while(i<= mid)
            temp[k++] = array[i++];
        while(j<=end)
            temp[k++] = array[j++];
        for(int l=0; l<k; l++) { 
            array[start+l] = temp[l];
        }
        
        return count;
    }
}

