import java.util.*;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//----------------------------------方法1------------------------------------------
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int level = 0;
        int everyLevelSize = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            level++;
            everyLevelSize = q.size();
            for(int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.poll();
                
                if(cur.left != null) {
					q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return level;
    }
}
//------------------------------------方法2------------------------------------
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}