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
/**我的思考过程
*很明显是个递归操作
*先考虑只有三个节点的树，对这种情况的操作，就是
*TreeNode p = root.left;
*root.left = root.right;
*root.right = p;
*这之后，就是对根节点的左右子节点进行同样的操作。
*/
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        Mirror(root.left);
        Mirror(root.right);
    }
}