//============================LeetCode上的实现  剑指 Offer 12. 矩阵中的路径==============================
//----------------------------DFS 回溯-----------------------------------
// 完全按照回溯的框架来编写
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<int []> starts = new ArrayList<>(); // 起点列表，起点保存的是borad中元素值与word的第一个值相等的位置索引

		// 填充起点列表
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    starts.add(new int[]{i, j});
                }
            }
        }
		
		// 从每个起点开始访问
        for (int[] start : starts) {
            int row = start[0];
            int col = start[1];
			// 起点已访问
            visited[row][col] = true; 
			// 从起点开始dfs，找到就返回true，没有找到就退出
            if (dfs(row, col, new StringBuffer().append(String.valueOf(word.charAt(0))), word, 1, visited, board, moves)) {
                return true;
            }
			// 没找到退出后，把起点标为未访问
            visited[row][col] = false;
        }

		// 从每个起点开始访问，但是都没找到，直接返回false
        return false;
    }

	// 回溯框架
	/**
	* @param i,j 起点坐标
	* @param path 已访问节点路径
	* @param word 目标字符串
	* @param 前进步数
	*/
    private boolean dfs(int i, int j, StringBuffer path, String word, int step, boolean[][] visited, char[][] board , int[][] moves) {
        // 结束条件
		if (word.equals(path.toString())) {
            return true;
        }
		
		// 做选择。在每个位置上都有四个选择
        for (int[] move : moves) {
            int newRow = i + move[0];
            int newCol = j + move[1];
			
			// 跳过不合理的选择
            if (!checkBound(newRow, newCol, board.length, board[0].length) || visited[newRow][newCol] == true || board[newRow][newCol] != word.charAt(step)) {
                continue;
            }
			
			// 做选择。把选择加入路径
            path.append(String.valueOf(board[newRow][newCol]));
			// 做出的选择标为已访问
            visited[newRow][newCol] = true;
			// 从做出的选择处继续访问，找到（dfs返回true），就层层递归返回true
            if (dfs(newRow, newCol, path, word, step + 1, visited, board, moves)) {
                return true;
            }
			// 没找到。把选择标为未访问
            visited[newRow][newCol] = false;
			// 并从路径中删除
            path.deleteCharAt(path.length() - 1);
        }

		// 从当前节点出发没找到，返回false
        return false;
    }

    private boolean checkBound(int i, int j, int m, int n) {
        if (i >=0 && i < m && j >= 0 && j < n) {
            return true;
        } else {
            return false;
        }
    }
}