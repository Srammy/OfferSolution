/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        boolean hasCycle = false; // 是否有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                hasCycle = true;
                break; //    如果执行break，说明找到了环，但这是fast指向的不一定是环的起点
            }
        }
        if (hasCycle == false) return null; // 没有环，直接返回null
        // 有换，继续向下执行
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}