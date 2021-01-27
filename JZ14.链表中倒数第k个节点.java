/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

// 快慢指针
//------------------------方法1：复杂的控制------------------
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
//----------------------方法2：思路简单--------------------
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode slow = newHead;
        
        for(int i = 0 ; i < k + 1 ; i ++){
            if (fast == null) {   // 这个判断用来防止k大于链表长度
                return null;
            }
            fast = fast.next;
            
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
  
        
        return slow.next;
    }
}
