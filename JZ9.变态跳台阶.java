//------------方法1；递归----------------
public class Solution {
    public int JumpFloorII(int target) {
        if (target == 0) {
            return 1;
        }
        
        if (target == 1 || target == 2) {
            return target;
        }
        
        int sum = 0;
        
        for (int i = target-1; i >= 0; i--) {
            sum = sum + JumpFloorII(i);
        }
        
        return sum;
    }
}
//--------------方法2：带备忘录的递归---------------
import java.util.*;
public class Solution {
    public int JumpFloorII(int target) {
        Map<Integer, Integer> memory = new HashMap<>();
        return helper(target, memory);
    }
    
    private int helper(int target, Map<Integer, Integer> memory) {
        if (target == 0) {
            return 1;
        }
        
        if (target == 1 || target == 2) {
            return target;
        }
        
        if (memory.containsKey(target)) {
            return memory.get(target);
        }
        int sum = 0;
        
        for (int i = target-1; i >= 0; i--) {
            sum = sum + JumpFloorII(i);
        }
        
        memory.put(target, sum);
        return memory.get(target);
    }
}