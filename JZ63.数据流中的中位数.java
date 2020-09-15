//===================================LeetCode上的实现  剑指 Offer 41. 数据流中的中位数=============================================
//链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
class MedianFinder {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap; 

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(
                    new Comparator<Integer>() {
                        public int compare(Integer e1, Integer e2) {
                        return e2 - e1;
                        }
                  });
    }
    
    public void addNum(int num) {
        if (minHeap.size() != maxHeap.size()) { // 没添加num时，数据量是个奇数，小顶堆比大顶堆多一个数
            // 大顶堆的size是要小于小顶堆的，所以最终是要向大顶堆中添加数据
            // 直接向大顶堆中添加num，此时这个num可能是属于小顶堆的，所以先向小顶堆添加，然后再把小顶堆的堆顶取出，添加到大顶堆中
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else { // 没添加num时，数据量是个偶数
            // 添加num后数据量是奇数
            // 应该向小顶堆中添加num，但是num这个数可能属于大顶堆的，所以先向大顶堆中添加，然后再把大顶堆的堆顶取出，添加到小顶堆中
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        return minHeap.size() != maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 
//========================================剑指offer上的实现==========================================
import java.util.*;
public class Solution {

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(
                    new Comparator<Integer>() {
                        public int compare(Integer e1, Integer e2) {
                        return e2 - e1;
                        }
                  });
    
    
    public void Insert(Integer num) {
        if (minHeap.size() != maxHeap.size()) { // 没添加num时，数据量是个奇数，小顶堆比大顶堆多一个数
            // 大顶堆的size是要小于小顶堆的，所以最终是要向大顶堆中添加数据
            // 直接向大顶堆中添加num，此时这个num可能是属于小顶堆的，所以先向小顶堆添加，然后再把小顶堆的堆顶取出，添加到大顶堆中
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else { // 没添加num时，数据量是个偶数
            // 添加num后数据量是奇数
            // 应该向小顶堆中添加num，但是num这个数可能属于大顶堆的，所以先向大顶堆中添加，然后再把大顶堆的堆顶取出，添加到小顶堆中
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        return new Double((minHeap.size() != maxHeap.size()) ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0);
    }

}