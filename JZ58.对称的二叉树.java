/*
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
    boolean isSymmetrical(TreeNode pRoot)
    {
        // 对称二叉树的先序遍历和对称先序遍历是一模一样的
        return isSymmetrical(pRoot, pRoot);
    }
    
    // 对node1为根的树进行根-左-右的先序遍历，对node2为根的树进行根-右-左的对称先序遍历
    boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        // 根
        if (node1 == null && node2 == null) {
            return true;
        }
        
        if (node1 == null || node2 == null) {
            return false;
        }
        
        if (node1.val != node2.val) {  
            return false;
        }
        // node1->左-右;node2->右-左
        return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }
}