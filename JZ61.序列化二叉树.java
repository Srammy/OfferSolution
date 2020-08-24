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
//----------------------------------方法1：先序遍历-----------------------------------------
public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        inOrder(root, res);
        return res.toString();
    }
    
    TreeNode Deserialize(String str) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : str.split("!")) {
            nodes.add(s);
        }
        return deserialize(nodes);
    }
 
    private void inOrder(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("#");
            res.append("!"); // 双引号是字符串
        } else {
            res.append(root.val);
            res.append("!");
            inOrder(root.left, res);
            inOrder(root.right, res);
        }
        
    }
    
    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        
        String first = nodes.removeFirst(); // 移除并返回此列表的第一个元素
        if ("#".equals(first)) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(first).intValue()); // 或者Integer.parseInt(first)
        
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        
        return root;
        
    }
}
//--------------------------------------方法2：后序遍历--------------------------
/* 辅助函数，将二叉树存入 StringBuilder */
void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
        sb.append(NULL).append(SEP);
        return;
    }

    serialize(root.left, sb);
    serialize(root.right, sb);

    /****** 后序遍历位置 ******/
    sb.append(root.val).append(SEP);
    /***********************/
}

/* 主函数，将字符串反序列化为二叉树结构 */
TreeNode deserialize(String data) {
    LinkedList<String> nodes = new LinkedList<>();
    for (String s : data.split(SEP)) {
        nodes.addLast(s);
    }
    return deserialize(nodes);
}

/* 辅助函数，通过 nodes 列表构造二叉树 */
TreeNode deserialize(LinkedList<String> nodes) {
    if (nodes.isEmpty()) return null;
    // 从后往前取出元素
    String last = nodes.removeLast();
    if (last.equals(NULL)) return null;
    TreeNode root = new TreeNode(Integer.parseInt(last));
    // 先构造右子树，后构造左子树
    root.right = deserialize(nodes);
    root.left = deserialize(nodes);

    return root;
}
//-------------------------------------方法3：层序遍历-----------------------
String SEP = ",";
String NULL = "#";

/* 将二叉树序列化为字符串 */
String serialize(TreeNode root) {
    if (root == null) return "";
    StringBuilder sb = new StringBuilder();
    // 初始化队列，将 root 加入队列
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        TreeNode cur = q.poll();

        /* 层级遍历代码位置 */
        if (cur == null) {
            sb.append(NULL).append(SEP);
            continue;
        }
        sb.append(cur.val).append(SEP);
        /*****************/

        q.offer(cur.left);
        q.offer(cur.right);
    }

    return sb.toString();
}

/* 将字符串反序列化为二叉树结构 */
TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    String[] nodes = data.split(SEP);
    // 第一个元素就是 root 的值
    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

    // 队列 q 记录父节点，将 root 加入队列
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    for (int i = 1; i < nodes.length; ) {
        // 队列中存的都是父节点
        TreeNode parent = q.poll();
        // 父节点对应的左侧子节点的值
        String left = nodes[i++];
        if (!left.equals(NULL)) {
            parent.left = new TreeNode(Integer.parseInt(left));
            q.offer(parent.left);
        } else {
            parent.left = null;
        }
        // 父节点对应的右侧子节点的值
        String right = nodes[i++];
        if (!right.equals(NULL)) {
            parent.right = new TreeNode(Integer.parseInt(right));
            q.offer(parent.right);
        } else {
            parent.right = null;
        }
    }
    return root;
}
//------------------------中序遍历可以实现序列化，但无法实现反序列化。因为无法再序列化中确认根节点的位置------------------------------