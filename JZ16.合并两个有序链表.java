//====================剑指offer========================
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }

        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }

        return newHead.next;
    }
}
//===================LeetCode      剑指 Offer 25. 合并两个排序的链表 ================================
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }

        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }

        return newHead.next;
    }
}