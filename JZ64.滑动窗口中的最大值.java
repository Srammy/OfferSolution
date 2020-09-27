//======================================LeetCode上的实现 剑指 Offer 59 - I. 滑动窗口的最大值===============================================
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>(); // 第一个值是当前窗口的最大值
        int[] res = new int[nums.length - k + 1];
        // 没有构成一个窗口
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.add(nums[i]);
        }
        // 上一个for循环结束后，已经构成了第一个窗口，q中记录着这个窗口中的最大值
        res[0] = q.peekFirst();
        // 构成窗口后
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == q.peekFirst()) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.add(nums[i]);
            res[i-k+1] = q.peekFirst();
        }
        return res;

    }
}
// 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/

//=========================剑指offer上的实现=====================
// 采用了大顶堆来实现
import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num.length == 0 || size == 0 || size > num.length) return new ArrayList<>();
        // 大小为size的大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){     //大顶堆，容量11
                                            @Override
                                            public int compare(Integer i1,Integer i2){
                                                return i2-i1;
                                            }
                                        });
        // 返回结果
        ArrayList<Integer> res = new ArrayList<>();
        
        // 初始化堆中元素
        for (int i = 0; i < size; i++) {
            maxHeap.add(num[i]);
        } 
        
        for (int i = size; i < num.length; i++) {
            res.add(maxHeap.peek());
            maxHeap.remove(num[i-size]);
            maxHeap.add(num[i]);
            
        }
        
        res.add(maxHeap.peek());
        return res;
    }
}