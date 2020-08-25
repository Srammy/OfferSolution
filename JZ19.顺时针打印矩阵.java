//-----------------------------------LeetCode上的实现------------------------------
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}

//链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/

//-----------------------------------剑指offer上的实现------------------------------------
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>(); // 最终遍历结果
        int l = 0; // 左边界
        int r = matrix[0].length - 1; // 右边界
        int t = 0; // 上边界
        int b = matrix.length - 1; // 下边界
        
        while (true) { 
            // 从左到右
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t++; // 上边界加1，也就是切换到下一行
            if (t > b) break; // 上边界超出下边界，说明遍历结束
            
            //从上到下
            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            r--; //右边界减1，也就是左移一行
            if (l > r) break; // 右边界超出左边界
            
            // 从右到左
            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            b--;
            if (t > b) break;
            
            // 从下到上
            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            l++;
            if (l > r) break;
        }
        return res;
    }
}