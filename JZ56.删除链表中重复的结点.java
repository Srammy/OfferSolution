/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.*;
//--------------------------------------方法1：使用map记录出现次数，从而知晓重复元素--------------------------------------
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) return null;
        Map<Integer, Integer> valAppearTimesMap = new HashMap<>(); // 用来记录链表中每个值的出现次数
		
        ListNode head = new ListNode(0); // 新建一个节点，用来指向原来的头结点（pHead），方便处理原链表刚开始就有重复节点的情况
        head.next = pHead;
        
        ListNode p = pHead; // 当前处理的节点
        ListNode pre = head;  // 当前处理节点的前一个节点
        
        int valAppearTimes = 0;
        
		// 填充valAppearTimesMap
        while(p != null) {
            if (!valAppearTimesMap.containsKey(p.val)) {
                valAppearTimesMap.put(p.val, 1);
            } else {
                valAppearTimes = valAppearTimesMap.get(p.val);
                valAppearTimes++;
                valAppearTimesMap.put(p.val, valAppearTimes);
            }
            p = p.next;
        }
        
        p = pHead;
        while (p != null) {
            if (valAppearTimesMap.get(p.val) == 1) {  // 当前节点出现次数为1，不是重复值，就继续向右走
                pre = p;
                p = p.next;
            } else {  // 当前节点的出现次数不为1，说明重复了
                valAppearTimes = valAppearTimesMap.get(p.val);
                for (int i = 0; i < valAppearTimes; i++) { // p指向开始不重复的点
                    p = p.next;
                }
				// 删除重复节点
                pre.next = p;
            }
        }
		
        return head.next;
    }
}
//-------------------------------------方法2：利用Set记录重复元素------------------------------------------------------
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) return null;
        Set<Integer> duplicateValSet = new HashSet<>(); 
        ListNode head = new ListNode(0);
        head.next = pHead;
        
        ListNode p = pHead.next;
        ListNode pre = pHead;
        
        // 向duplicateValSet中填充数据，记录重复值
        while(p != null) {
            if (p.val == pre.val) { // 前后值相等，说明是重复值
                duplicateValSet.add(p.val);
            }
            p = p.next;
            pre = pre.next;
        }
        
        // 处理重复值
        p = pHead;
        pre = head;
        while (p != null) {
            if (duplicateValSet.contains(p.val)) { // 当前值是重复值
                p = p.next;
                pre.next = p;
            } else { // 当前值不是重复值
                pre = p;
                p = p.next;
            }
        }
        return head.next;
    }
}
//--------------------------------方法3：一次循环直接定位重复值的起止位置-----------------------------------
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) return null;
        
        ListNode head = new ListNode(0);
        head.next = pHead;
        
        ListNode p = pHead;
        ListNode pre = head;
        
        while (p != null) {
            if (p.next != null && p.val == p.next.val) {
                p = p.next;
				// 找出所有的重复值
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
				// while结束后，p指向最后一个重复值
                p = p.next;
                pre.next = p;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return head.next;
    }
}