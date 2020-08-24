import java.util.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();  // 中序遍历中数值和索引对应关系
        for (int i = 0; i < in.length; i++) {
            inOrderMap.put(in[i], i);
        }
        
        return reConstruct(pre, inOrderMap, 0, 0, pre.length - 1);
    }
    
	/**
	 * @param pre 先序遍历
	 * @param inOrderMap 中序遍历中数值和索引对应关系
     * @param pre_index  先序遍历的索引
     * @param in_left_indec  中序遍历的索引
     * @param in_right_index 中序遍历的索引
     */
    private TreeNode reConstruct(int[] pre, Map<Integer, Integer> inOrderMap, int pre_index, int in_left_indec, int in_right_index) {
        if (in_left_indec > in_right_index) return null;
        // 在先序遍历中获取根节点
        TreeNode root = new TreeNode(pre[pre_index]);
        //根节点在中序遍历中的位置
        int rootIndexOfInoder = inOrderMap.get(pre[pre_index]);
        // 构建左子树。根节点是pre_index + 1，对应的左子树在中序遍历中的范围是in_left_indec, rootIndexOfInoder - 1
        root.left = reConstruct(pre, inOrderMap, pre_index + 1, in_left_indec, rootIndexOfInoder - 1);
        // 构建右子树。根节点是pre_index + rootIndexOfInoder - in_left_indec + 1（rootIndexOfInoder - in_left_indec是左子树的长度），对应的左子树在中序遍历中的范围是rootIndexOfInoder + 1, in_right_index
        root.right = reConstruct(pre, inOrderMap, pre_index + rootIndexOfInoder - in_left_indec + 1, rootIndexOfInoder + 1, in_right_index);
        return root;
    }
}