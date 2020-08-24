
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//===============================================在leetcode上的实现====================================================
//--------------------------------------方法1--------------------------------------------------

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node p = head;
        List<Node> newNodeList = new ArrayList<>(); // 存储新创建的节点
        int randomNodeIndex = 0;
        int count = 0; // 记录当前节点的索引链表
        Map<Node, Integer> nodeIndexMap = new HashMap<>(); // 当前链表节点和该节点在链表中索引的对应关系 
        while (p != null) {
            Node newNode = new Node(p.val);  // 创建和当前旧节点相对应的新节点
            newNodeList.add(newNode); 
            nodeIndexMap.put(p, count);
            count++;
            p = p.next;
        }
        
		// 将新创建节点连接起来
        p = head;
        for (int i = 0; i < newNodeList.size(); i++) {
            if (i != (newNodeList.size()-1)) {
                newNodeList.get(i).next = newNodeList.get(i + 1); // 为next复制
                if (p.random != null) { // 为random复制
                    randomNodeIndex = nodeIndexMap.get(p.random);  // 获取索引
                    newNodeList.get(i).random = newNodeList.get(randomNodeIndex); 
                }
                p = p.next;
            }   
        }
        
		// 单独处理最后一个新创建节点
        // p = p.next;
        Node lastNewNode = newNodeList.get(newNodeList.size() - 1);
        if (p.random != null) {
            randomNodeIndex = nodeIndexMap.get(p.random);
            lastNewNode.random = newNodeList.get(randomNodeIndex);
        }
        
        return newNodeList.get(0);
    }
}
//----------------------------------------方法2-------------------------------------------
//链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/tong-guo-hashmaplai-shi-xian-by-try-62/
class Solution { //HashMap实现
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>(); //创建HashMap集合
        Node cur=head;
        //复制结点值
        while(cur!=null){
            //存储put:<key,value1>
            map.put(cur,new Node(cur.val)); //顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur=cur.next;
        }
        //复制结点指向
        cur = head;
        while(cur!=null){
            //得到get:<key>.value2,3
            map.get(cur).next = map.get(cur.next); //新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random); //新结点random指向同旧结点的random指向
            cur = cur.next;
        }

        //返回复制的链表
        return map.get(head);


    }
}

//链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/tong-guo-hashmaplai-shi-xian-by-try-62/

//=========================================剑指offer上的实现==========================
import java.util.*;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        RandomListNode p = pHead;
        List<RandomListNode> newNodeList = new ArrayList<>();
        int randomNodeIndex = 0;
        int count = 0;
        Map<RandomListNode, Integer> nodeIndexMap = new HashMap<>();
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            newNodeList.add(newNode);
            nodeIndexMap.put(p, count);
            count++;
            p = p.next;
        }
        
        p = pHead;
        for (int i = 0; i < newNodeList.size(); i++) {
            if (i != (newNodeList.size()-1)) {
                newNodeList.get(i).next = newNodeList.get(i + 1);
                if (p.random != null) {
                    randomNodeIndex = nodeIndexMap.get(p.random);
                    newNodeList.get(i).random = newNodeList.get(randomNodeIndex);
                }
                p = p.next;
            }   
        }
        
        //p = p.next;
        RandomListNode lastNewNode = newNodeList.get(newNodeList.size() - 1);
        if (p.random != null) {
            randomNodeIndex = nodeIndexMap.get(p.random);
            lastNewNode.random = newNodeList.get(randomNodeIndex);
        }
        
        return newNodeList.get(0);
    }
}
