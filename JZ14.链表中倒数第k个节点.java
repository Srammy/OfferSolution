/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// 快慢指针
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0) return null;
        ListNode fast = head;
        ListNode slow = head;
        int count;
        for (count = 1; count <= k; count++) {
            if (fast != null) {
                fast = fast.next; 
            } else {
                break;
            }
                
        }
        
        if (count < k + 1) return null;  // 处理k大于链表长度的情况
        
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
