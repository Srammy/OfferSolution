//========================================LeetCode上的实现 剑指 Offer 56 - I. 数组中数字出现的次数===========================================
//---------------------------------------方法1：异或操作------------------------------------------
class Solution {
    public int[] singleNumbers(int[] nums) {
        // 得到数组中所有数字异或的结果
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }

        // 找出res（二进制）中为1的最低位
        int div = 1;
        while ((div & res) == 0) {
            div = div << 1;
        }

        // 对nums数组元素进行分组
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if ((i & div) == 0) {
                a = a ^ i;
            } else {
                b = b ^ i;
            }
        }

        return new int[]{a, b};

    }
}
//--------------------------------------方法2：set去重---------------------------------------
class Solution { 
    public int[] singleNumbers(int[] nums) {
        int COUNT_OF_SINGLENUMBERS = 2;
        Set<Integer> res = new HashSet<>();
        for (int i : nums) {
            if (res.contains(i)) {
                res.remove(i);
            } else {
                res.add(i);
            }
        }

        int[] singleNum = new int[COUNT_OF_SINGLENUMBERS];
        int count = 0;
        for (int i : res) {
            singleNum[count++] = i;
        }

        return singleNum;
    }
}
//=========================================剑指offer上的实现=================================
//-----------------------方法1：异或操作------------------------------------------
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        // 得到数组中所有数字异或的结果
        int res = 0;
        for (int i : array) {
            res = res ^ i;
        }

        // 找出res（二进制）中为1的最低位
        int div = 1;
        while ((div & res) == 0) {
            div = div << 1;
        }

        // 对nums数组元素进行分组
        int a = 0;
        int b = 0;
        for (int i : array) {
            if ((i & div) == 0) {
                a = a ^ i;
            } else {
                b = b ^ i;
            }
        }
        
        num1[0] = a;
        num2[0] = b;
    }
}
//-------------------------方法2：set去重---------------------------------------
