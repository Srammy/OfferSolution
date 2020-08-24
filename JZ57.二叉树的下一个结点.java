/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
//------------------------方法一：比较复杂的逻辑-------------------
/*
这个过程中还掺杂着判null，为了处理特殊情况
1.叶子节点
（1）该节点是其父节点的左子节点，下一个结点就是其父节点
（2）该节点是父节点的右子节点，则一直向上找，直到找到一个parent是grandParent的左节点的parent节点
2.非叶子节点
（1）该节点右子节点不为空
     【1】右子节点为叶子节点，下一个节点是该节点的右子节点
	 【2】右子节点不为叶子节点，下一个节点是该节点右子树的最左边的节点
（2）该节点右子节点为空
     【1】该节点是其父节点的左子节点，下一节点就是其父节点
	 【2】该节点是其父节点的右子节点，下一节点需要一直向上找，直到找到一个parent是grandParent的左节点的parent节点
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        TreeLinkNode nextNode = null;
        // 该节点是叶子节点
        if(pNode.left == null && pNode.right == null) {
            TreeLinkNode parent = pNode.next; // 该节点的父节点
            if(parent == null) return null; // 只有一个节点的树
            TreeLinkNode grandParent = parent.next; //该节点的父节点的父节点->爷爷结点
            // 该节点是其父节点的左子节点
            if(parent.left == pNode) {
                // 下一个结点就是其父节点
                nextNode = parent;
            }
            // 该节点是父节点的右子节点
            if(parent.right == pNode) {
                // 一直向上找，直到找到一个parent是grandParent的左节点的parent节点
                while(grandParent != null && grandParent.left != parent) {
                    grandParent = grandParent.next;
                    parent = parent.next;
                }
                nextNode = grandParent;
            }
        } else { // 非叶子节点
            if(pNode.right != null ) { // 该节点右子节点不为空
                // 1-右子节点为叶子节点
                if(pNode.right.left == null && pNode.right.right == null) {
                    nextNode = pNode.right; 
                } else { // 2-右子节点不为叶子节点
                    // 该节点右子树的最左边的节点
                    TreeLinkNode p = pNode.right;
                    while(p.left != null) {
                        p = p.left;
                    }
                    nextNode = p;
                }
            } else if(pNode.right == null) { // 右子节点为空
                TreeLinkNode parent = pNode.next; // 该节点的父节点
                if(parent == null) return null;  // 只有一个根节点和左子节点的树
                if(parent.left == pNode) nextNode = parent; // 该节点是其父节点的左子节点，下一节点就是其父节点
                else if(parent.right == pNode) { // 该节点是其父节点的右子节点，下一节点需要一直向上找，直到找到一个parent是grandParent的左节点的parent节点
                    TreeLinkNode grandParent = parent.next; //该节点的父节点的父节点->爷爷结
                    while(grandParent != null && grandParent.left != parent) {
                        grandParent = grandParent.next;
                        parent = parent.next;
                    }
                    nextNode = grandParent;   
                }
            }
        }
        
        return nextNode;
    }
}
//-------------------------方法2-------------------------------
/*
1.有右子树，下一结点是右子树中的最左结点
2.无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点
3.无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，
直到找到某个结点是其父结点的左子树，如果存在这样的结点，那么这个结点的父结点就是我们要找的下一结点。
*/
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		 // 1.
		 if (pNode.right != null) {
			 TreeLinkNode pRight = pNode.right;
			 while (pRight.left != null) {
				 pRight = pRight.left;
			 }
			 return pRight;
		 }
		 // 2.
		 if (pNode.next != null && pNode.next.left == pNode) {
			 return pNode.next;
		 }
		 // 3.
		 if (pNode.next != null) {
			 TreeLinkNode pNext = pNode.next;
			 while (pNext.next != null && pNext.next.right == pNext) {
				 pNext = pNext.next;
			 }
			 return pNext.next;
		 }
		 return null;
	}
}
//------------方法3：这是最简单的形式，把方法2中的情况2、3进行合并---------------
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode == null) return null;
		 // 1.有右子树。找最左边的节点。
		 if (pNode.right != null) {
			 TreeLinkNode pRight = pNode.right;
			 while (pRight.left != null) {
				 pRight = pRight.left;
			 }
			 return pRight;
		 } else { // 2、3合并.无右子树
			 TreeLinkNode cur = pNode;
			 TreeLinkNode parent = pNode.next;
			 while(parent != null && parent.left != cur) {
				 cur = parent;
				 parent = parent.next;
			 }
			 return parent;
		 }
	}
}
//-------------方法4：从给出的节点找到根节点，开始中序遍历，将结果存在一个数组中，然后根据当前节点，取下一个结点-------------
import java.util.*;
public class Solution {
	// 中序遍历
	private void inOrder(TreeLinkNode root, List<TreeLinkNode> res) {
        if(root == null) return;
        inOrder(root.left, res);
        res.add(root);
        inOrder(root.right, res);
    }
	
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode == null) return null;
		
		List<TreeLinkNode> res = new ArrayList<>();
		TreeLinkNode p = pNode;
		//1.从给出的节点出发，找到根节点
		while(p.next != null) {
			p = p.next;
		}
		//2.中序遍历
		inOrder(p, res);
		//3.找下一个节点
		for(int i = 0; i < res.size(); i++) {
			if(res.get(i) == pNode && i + 1 < res.size()) { // i + 1 < res.size()的判断是为了防止中序遍历最后一个节点越界
				return res.get(i+1);
			} 
		}
		return null; // 中序遍历最后一个节点返回空
	}
}