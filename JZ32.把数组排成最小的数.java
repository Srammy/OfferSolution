//---------------------------这段代码对没有重复值的numbers是可用的，不适用于有重复值的numbers--------------------------
import java.util.ArrayList;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> trace = new ArrayList<>();
        ArrayList<String> joinValue = new ArrayList<>();
        backTrace(numbers, trace, res);
        // System.out.println(res);
        for (ArrayList<Integer> i : res) {
            // System.out.println(i);
            String joinVal = "";
            for (int val : i) {
                joinVal = joinVal + val;
            }
            // System.out.println(joinVal);
            joinValue.add(joinVal);
        }
        
        int min = Integer.parseInt(joinValue.get(0));
        int minIndex = 0;
        for (int i = 1; i <= joinValue.size() - 1; i++) {
            if (Integer.parseInt(joinValue.get(i)) < min) {
                min = Integer.parseInt(joinValue.get(i));
                minIndex = i;
            }
        }
        return joinValue.get(minIndex);
    }
    
	// 回溯，求出所有的组合
    private void backTrace(int[] numbers, ArrayList<Integer> trace, ArrayList<ArrayList<Integer>> res) {
        if (trace.size() == numbers.length) {
            res.add((ArrayList<Integer>)trace.clone());
            return;
        }
        
        for (int j = 0; j < numbers.length; j++) {
            if (trace.contains(numbers[j])) continue;
            trace.add(numbers[j]);
            backTrace(numbers, trace, res);
            trace.remove(trace.size() - 1);
        }
    }
}

//-------------------------------------正确解法-----------------------------------
// 对字符串数组进行升序排序。这里采用了快速排序。
// 比较规则是 x + y > y + x, 则x > y; x + y < y + x, 则x < y
// 字符串的compareTo方法: str1.compareTo(str2)  =0,二者相同；>0,str1大于str2；<0,str1小于str2

import java.util.ArrayList;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            strs[i] = String.valueOf(numbers[i]);
		// 对字符串数组升序排序（快速排序）
        fastSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    
	// 快速排序
    void fastSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--; // j比l大时，j--。从右边开始，找到比l小的。
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++; // i比l小时，i++。从左边开始，找到比l大的。
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
		// 上面的while结束时，i=j
        strs[i] = strs[l];
        strs[l] = tmp;
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);
    }
}


//链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
