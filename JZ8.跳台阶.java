//斐波那契数列
//---------------方法1：递归-----------------
public class Solution {
    public int JumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
//--------------方法3：带备忘录的递归-------------
import java.util.*;
public class Solution {
    public int JumpFloor(int target) {
        Map<Integer, Integer> memory = new HashMap<>();
        return helper(target, memory);
    }
    
    private int helper(int target, Map<Integer, Integer> memory) {
        if (target == 1 || target == 2) {
            return target;
        }
        
        if (memory.containsKey(target)) {
            return memory.get(target);
        }
        
        memory.put(target, helper(target - 1, memory) + helper(target - 2, memory));
        return memory.get(target);
    }
}
//--------------方法3：迭代---------------------
public class Solution {
    public int JumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        
        int n1 = 1;
        int n2 = 2;
        int sum = 0;
        
        for (int i = 3; i <= target; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        
        return sum;
    }
}