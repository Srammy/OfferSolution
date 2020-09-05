//==================================暴力求解===============================
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       if (array == null || array.length == 0) return 0;
       int count = 0;
       for (int i : array) {
           if (i == k) {
               count++;
           }
           
           if (i > k) break;
       }
        
        return count;
    }
}
//====================================二分查找==========================
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        
        if (array == null || array.length == 0) return 0;
        int count = 0;
        int left = 0;
        int right = array.length;
        int kFirstAppearIndex = 0; // k第一次出现时的索引
        
        // 找k第一次出现时的索引（第一个k的索引，因为可能会有重复）
        while (left < right) { 
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                right = mid;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid; 
            }
        }
        // while循环结束后，left保存的是k第一次出现时的索引 left的取值范围是[0, array.length]
		
        // k比所有数都大
        if (left == array.length) return 0; 
        
		// 处理left = 0的情况。
        if (array[left] == k) kFirstAppearIndex = left; 
        else return 0;  // 没找到k
        
        for (int i = kFirstAppearIndex; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
            if (array[i] > k) break;
            
        }
        return count;
    }
}