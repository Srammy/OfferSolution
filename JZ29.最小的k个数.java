//++++++++++++++++++++++++++++++++++LeetCode上的实现+++++++++++++++++++++++++++++++++++++
//================================方法1：快速选择（借鉴了快速排序的思想）==========================================
//链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];

        partionArray(arr, 0, arr.length - 1, k - 1);

        // arr数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    
    private void partionArray(int[] arr, int left, int right, int k) {
        int pivot = getArrayPivot(arr, left, right); //  // 此时数组前 pivot 个数，就是最小的 pivot 个数
        if (pivot == k) return; 
        else if (pivot < k) partionArray(arr, pivot + 1, right, k);    // 在右侧数组中寻找最小的 k-m 个数
        else if (pivot > k) partionArray(arr, left, pivot - 1, k);    // 最小的 k 个数一定在前 m 个数中，递归划分
    }

    /* 快速排序中切分数组
    * @return: 数组的索引。该索引左侧的数都比该索引的数小，该索引右侧的数都比该索引的数大
    */
    private int getArrayPivot(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] < temp) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        // i=j
        arr[i] = temp;
        return i; 
    }          
}
//==============================方法2：大顶堆====================================================
//链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }

}
/*方法1和方法2比较：
两种方法的优劣性比较
在面试中，另一个常常问的问题就是这两种方法有何优劣。看起来分治法的快速选择算法的时间、空间复杂度都优于使用堆的方法，但是要注意到快速选择算法的几点局限性：

第一，算法需要修改原数组，如果原数组不能修改的话，还需要拷贝一份数组，空间复杂度就上去了。

第二，算法需要保存所有的数据。如果把数据看成输入流的话，使用堆的方法是来一个处理一个，不需要保存数据，只需要保存 k 个元素的最大堆。而快速选择的方法需要先保存下来所有的数据，再运行算法。当数据量非常大的时候，甚至内存都放不下的时候，就麻烦了。所以当数据量大的时候还是用基于堆的方法比较好。
*/

//===========================方法3：先升序排序，然后取前K个数================================================
//============================方法4：计数排序===============================================
class Solution {
    
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001]; // 数组初始默认值为0
        for (int num: arr) {
            counter[num]++;
        }
		
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }
}

// 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/

//+++++++++++++++++++++++++++++++++剑指offer上的实现++++++++++++++++++++++++++++++++
//=============================方法1====================================
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return new ArrayList<>();
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        getPartionArray(input, 0, input.length - 1, k - 1);
        
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        
        return res;
    }
    
    private void getPartionArray(int[] input, int left, int right, int k) {
        int pivot = getPivot(input, left, right);
        if (pivot == k) return;
        else if (pivot < k) getPartionArray(input, pivot + 1, right, k);
        else getPartionArray(input, left, pivot - 1, k);
    }
    
    private int getPivot(int[] input, int left, int right) {
        int i = left;
        int j = right;
        int temp = input[left];
        
        while (i < j) {
            while (i < j && input[j] >= temp) {
                j--;
            }
            if (i < j) {
                input[i] = input[j];
                i++;
            }
            
            while (i < j && input[i] < temp) {
                i++;
            }
            if (i < j) {
                input[j] = input[i];
                j--;
            }
        }
        input[i] = temp;
        return i;
    }
}
//===========================方法2==========================================================
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return new ArrayList<>();
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });
        
        for (int i : input) {
            if (maxHeap.isEmpty() || maxHeap.size() <= k || i < maxHeap.peek()) {
                maxHeap.offer(i);
            }
            
            if (maxHeap.size() > k) {
                maxHeap.poll(); // 弹出最大值
            }
        }
        
        for (int i : maxHeap) {
            res.add(i);
        }
        
        return res;
    }

}
