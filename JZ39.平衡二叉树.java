//-------------------------------方法1---------------------------------------------
import java.util.*;
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        int heightDiff = leftHeight - rightHeight;
        return (heightDiff == 1 || heightDiff == -1 || heightDiff == 0) && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    private int treeHeight(TreeNode node) {
        if (node == null) return 0;
        int level = 0;
        int everyLevelSize = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        
        while (!q.isEmpty()) {
            level++;
            everyLevelSize = q.size();
            for (int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.poll();
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null) q.offer(cur.left);
            }
        }
        return level;
    }
}
//--------------------------------方法2：在1基础上修改了求高度的方法-------------------
class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

//-----------------------------方法3:1和2都是自顶向下求解，方法3是自底向上求解，是最优的。-----------------------------
