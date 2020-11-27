//=========================LeetCode 剑指 Offer 04. 二维数组中的查找 ===================================
// 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-b-3/
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;    // 行数
        int columns = matrix[0].length;    // 列数

        int row = 0;
        int col = columns - 1;

        while (row < rows && col >= 0) {
            int num = matrix[row][col];

            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else if (num < target) {
                row++;
            }
        }

        return false;
    }
}
//=============================================剑指offer========================================
public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int rows = array.length;    // 行数
        int columns = array[0].length;    // 列数

        int row = 0;
        int col = columns - 1;

        while (row < rows && col >= 0) {
            int num = array[row][col];

            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else if (num < target) {
                row++;
            }
        }

        return false;
    }
}