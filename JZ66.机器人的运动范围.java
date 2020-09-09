//===================================LeetCode 剑指 Offer 13. 机器人的运动范围====================================================
//---------------------------方法1：BFS-------------------------------------------------
class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] matrix = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        matrix[0][0] = 1;
        int step = 0;
        int everyLevelSize = 0;
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            step++; // 每访问一个点，step就+1
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int[] move : moves) {
                int nextRow = row + move[0];
                int nextCol = col + move[1];

                if (checkBound(nextRow, nextCol, m, n) && matrix[nextRow][nextCol] != 1 && checkRowAndColSum(nextRow, nextCol, k)) {
                    matrix[nextRow][nextCol] = 1;
                    q.offer(new int[]{nextRow, nextCol});
                }  
            }
            
        }

        return step;
    }

    private boolean checkBound (int nextRow, int nextCol, int m, int n) {
        if (0 <= nextRow && nextRow < m && nextCol >= 0 && nextCol < n) {
            return true;
        } else {
            return false;
        }
    }

	/*
    private boolean checkRowAndColSum(int row, int col, int target) {
        String rowStr = Integer.toString(row);
        String colStr = Integer.toString(col);
        int sum = 0;
        for (int i = 0; i < rowStr.length(); i++) {
            sum = sum + Integer.parseInt(String.valueOf(rowStr.charAt(i)));     // char转字符串，字符串转int
        }

        for (int i = 0; i < colStr.length(); i++) {
            sum = sum + Integer.parseInt(String.valueOf(colStr.charAt(i)));
        }

        return sum <= target ? true : false;
    }*/
	
	 private boolean checkRowAndColSum(int row, int col, int target) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col != 0) {
            sum += col % 10;
            col /= 10;
        }

        return sum <= target ? true : false;
    }
}

//--------------------------方法2：BFS-----------------------------------------------
public int movingCount(int m, int n, int k) {
    //临时变量visited记录格子是否被访问过
    boolean[][] visited = new boolean[m][n];
    return dfs(0, 0, m, n, k, visited);
}

// 从[i][j]出发，计算可以运动的步数
public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
    //i >= m || j >= n是边界条件的判断，k < sum(i, j)判断当前格子坐标是否
    // 满足条件，visited[i][j]判断这个格子是否被访问过
    if (i >= m || j >= n || k < sum(i, j) || visited[i][j])
        return 0;
    //标注这个格子被访问过
    visited[i][j] = true;
    //沿着当前格子的右边和下边继续访问从[i][j]出发，可以运动的步数 = 1(当前的点算一步) + 从右边的点出发可以运动的步数 + 从下边的点出发可以运动的步数
    return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
}

//计算两个坐标数字的和
private int sum(int i, int j) {
    int sum = 0;
    while (i != 0) {
        sum += i % 10;
        i /= 10;
    }
    while (j != 0) {
        sum += j % 10;
        j /= 10;
    }
    return sum;
}

//链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/dfshe-bfsliang-chong-jie-jue-fang-shi-by-sdwwld/
