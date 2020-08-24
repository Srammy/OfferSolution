/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//----------------------方法1：--------------------------------------------
// 时间复杂度O(n+m),空间复杂度O(1)
// 设l1的不同部分为长度n,l2长度为m,俩链表相同部分为t;
// 则l1=n+t,l2=m+t;
// 可知l1+m=l2+n;
// 总结：两指针遍历俩个链表，至少第二次会进行匹配。若长度相同，则第一次进行匹配。
// 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/java-shuang-zhi-zhen-liang-chong-xie-fa-shuang-bai/
。
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        
        while (cur1 != cur2) { //用的是 != ，公共节点指得是在堆中的同一块内存地址
            if (cur1 != null) cur1 = cur1.next;
            else cur1 = pHead2;
            
            if (cur2 != null) cur2 = cur2.next;
            else cur2 = pHead1;
        } 
        return cur1;    
    }
}
//----------------------方法2：让长链表的指针先走几步----------------------
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int length1 = 0; // 链表1的长度
        int length2 = 0; // 链表2的长度
        int lengthDif = 0;
        // 链表1的长度
        while (cur1 != null) {
            length1++;
            cur1 = cur1.next;
        }
        
        // 链表2的长度
        while (cur2 != null) {
            length2++;
            cur2 = cur2.next;
        }
        
        
        cur1 = pHead1;
        cur2 = pHead2;
        
        // 两个链表长度之差，并让长的链表先走lengthDif步
        if (length1 >= length2) {
            lengthDif = length1 - length2;
            for (int i = 0; i < lengthDif; i++) {
                cur1 = cur1.next;
            }
        } else {
            lengthDif = length2 - length1;
            for (int i = 0; i < lengthDif; i++) {
                cur2 = cur2.next;
            }
        }
        
        // 经过上面的处理，cur1和cur2所指链表的长度相同
        while (cur1 != null && cur2 != null &&  cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        return cur1;
    }
}