//链接：https://blog.csdn.net/qq_41181772/article/details/105182230
//滑动窗口
import java.util.ArrayList;
public class Solution {
    
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        
        while (left < right) {
            int ans = (left+right)*(right-left+1)/2;
            if(ans == sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = left; i <= right; i++)
                    temp.add(i);
                res.add(temp);
                left++;
                right++;
            } else if(ans < sum) {
                right++;
            } else {
                left++;
            }
        }
        
        return res;
    }
}