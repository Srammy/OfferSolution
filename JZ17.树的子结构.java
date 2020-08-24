/**
*这道题是判断子结构，不是子树。
可以与leetCode的1367题二叉树中的列表，一起分析
*二者区别：参见https://blog.csdn.net/qq_34597865/article/details/91153702
*/
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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null) return false;
        if(root2 == null) return false;
	    // root2是root1的子结构= 从根节点就满足 || root2是root1左子树的子结构 || root2是root1右子树的子结构
        return isSub(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    
	// node2为根的树，是node1为根的树的子结构
	// => 根节点一样+（&&）node2左子树是node1左子树的子结构+（&&）node2右子树是node1右子树的子结构
    public boolean isSub(TreeNode node1, TreeNode node2) {
        // 这个`tree2==null`是递归终止条件， 真正判断空树在遍历大树的时候做的
        if(node2 == null) return true; // 必须先写node2的判断
        if(node1 == null) return false;
        //if(node2 == null) return true; // 后写node2的判断，报错
        if(node1.val != node2.val) return false;
        
        return isSub(node1.left, node2.left) && isSub(node1.right, node2.right);
    }
}