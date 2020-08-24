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
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        List<TreeNode> res = new ArrayList<>();
        inOrder(pRootOfTree, res);
        // 只有一个根节点
        if (res.size() == 1) return res.get(0);
        for (int i = 0; i < res.size(); i++) {
            if (i == 0) {
                res.get(i).left = null;
                res.get(i).right = res.get(i + 1);
            } else if (i == (res.size() - 1)){
                res.get(i).left = res.get(i - 1);
                res.get(i).right = null;
            } else {
                res.get(i).left = res.get(i - 1);
                res.get(i).right = res.get(i + 1);
            }  
        }
        return res.get(0);
    }
    
    private void inOrder(TreeNode node, List<TreeNode> res) {
        if (node == null) return;
        inOrder(node.left, res);
        res.add(node);
        inOrder(node.right, res);
    }
}