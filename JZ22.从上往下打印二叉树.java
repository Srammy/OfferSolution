/**
*本方法仅使用了ArrayList
*/
import java.util.ArrayList;
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
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();    
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            TreeNode cur = q.get(0);
            res.add(cur.val);
            q.remove(0);
            
            if(cur.left != null) {
                q.add(cur.left);
            }
            if(cur.right != null) {
                q.add(cur.right);
            }
        }
        return res;
    }
}