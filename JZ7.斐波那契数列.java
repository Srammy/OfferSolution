//---------------------------方法1：带数组备忘录的递归----------------------
public class Solution {
    public int Fibonacci(int n) {
        int[] memory = new int[40]; //数组中默认值为0
        return memoryFibo(n, memory);
        
    }
    
    private int memoryFibo(int n, int[] memory) {
        if (n == 0) {
            memory[0] = 0;
            return 0;
        }
        if (n == 1) {
            memory[1] = 1;
            return 1;
        }
        if (memory[n] != 0) return memory[n];
        else {
            memory[n] = memoryFibo(n - 1, memory) + memoryFibo(n - 2, memory);
            return memory[n];
        }
    }
        
}
//--------------------------------方法2：带数组备忘录的递归-------------------------------------------
import java.util.*;
public class Solution {
    public int Fibonacci(int n) {
        Map<Integer, Integer> memmoryMap = new HashMap<>();
        return memoryFibo(n, memmoryMap);
        
    }
    
    private int memoryFibo(int n, Map<Integer, Integer> memory) {
        if (n == 0) {
            memory.put(0, 0);
            return 0;
        }
        if (n == 1) {
            memory.put(1, 1);
            return 1;
        }
        if (memory.get(n) != null) return memory.get(n); // Map中的值是包装类型，所以这里比较时应该是null
        else {
            memory.put(n, memoryFibo(n - 1, memory) + memoryFibo(n - 2, memory));;
            return memory.get(n);
        }
    }
        
}
//-------------------------------方法3；单纯的递归（重复计算）--------------------------------
public class Solution {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }       
}