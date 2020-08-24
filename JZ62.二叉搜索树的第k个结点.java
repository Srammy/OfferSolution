import java.util.*;
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
//-------------------方法1：二叉搜索树的中序遍历是由小到大的顺序排列的-------------------------
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k <= 0) return null;
        TreeNode kthNode = null;
        List<TreeNode> res = new ArrayList<>();
        inOrder(pRoot, res);
        if (k <= res.size()) kthNode = res.get(k - 1);
        return kthNode;
    }

    // 中序遍历
    private void inOrder(TreeNode node, List<TreeNode> res) {
        if (node == null) return;
        inOrder(node.left, res);
        res.add(node);
        inOrder(node.right, res);
    }

}
//----------------------方法2:到k时停止中序遍历----------------------------------
public class Solution {
    TreeNode treeNode = null;
    int count = 0;
 
    void inOrder(TreeNode pRoot, int k) {
        if (pRoot == null) return;
        if (count < k) {
            inOrder(pRoot.left, k);
        }
 
		// 这儿是先++。因为最开始count=0，而题目中是第K小的数（k从1开始）。
        if (++count == k) {
            treeNode = pRoot;
        }
 
        if (count < k) {
            inOrder(pRoot.right, k);
        }
    }
 
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
 
        inOrder(pRoot, k);
        return treeNode;
    }

}