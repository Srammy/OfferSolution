/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
//-------------------------------方法1:每次将链表节点的值插入到ArrayList的头部--------------------
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode p = listNode;
        while (p != null) {
            res.add(0, p.val);
            p = p.next;
        }
        return res;
    }
}
//------------------------------方法2：递归。链表也可以看成一颗树，树中每一个节点只有左子树（或只有右子树）。---------------------------
// 逆序输出链表的值，类似树的后序遍历(或者是中序遍历)。
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        postOrder(listNode, res);
        return res;
    }
    
    // 仿照树的后序遍历(或者是中序遍历)
    private void postOrder(ListNode listNode, ArrayList<Integer> res) {
        if (listNode == null) return;
        postOrder(listNode.next, res); // 链表只有左子树（或者只有右子树），
        res.add(listNode.val);
    }
}
//-------------------------------方法3：翻转链表----------------------------------------
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode pre = null; // 当前正在反转的节点的前一个节点
        ListNode cur = listNode;  // 当前正在反转的节点
        ListNode temp = null; // 还未反转部分的头结点
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        
        // 反转结束后，pre指向的是反转后链表的头结点
        while (pre != null) {
            res.add(pre.val);
            pre = pre.next;
        }
        return res;
    }
    
    
}