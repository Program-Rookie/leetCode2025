package com.atvris.hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjh
 * @date 2025/12/26 13:46
 */
public class CopyRandomList_138 {
    
    class Node {
        int val;
        Node next;
        Node random;
        public Node() {
            
        }
        
        public Node(int val) {
            this.val = val;
        }
        
    }

    Map<Node, Node> copyMap = new HashMap<>();

    /**
     * 有种半初始化的思想，反正是值引用（对象地址）后续修改也是有效的
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            copyMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            Node node = copyMap.get(cur);
            node.next = copyMap.get(cur.next);
            node.random = copyMap.get(cur.random);
            cur = cur.next;
        }
        return copyMap.get(head);
    }
    
    // 递归+哈希表解法
    public Node copyRandomListV2(Node head) {
        Node cur = head;
        while (cur != null) {
            if (!copyMap.containsKey(cur)) {
                Node newNode = new Node(cur.val);
                copyMap.put(cur, newNode);
                newNode.next = copyRandomListV2(cur.next);
                newNode.random = copyRandomListV2(cur.random);
            }
            cur = cur.next;
        }
        return copyMap.get(head);
    }
    
    // 技巧 A->A'->B->B'->C->C'
    public Node copyRandomListV3(Node head) {
        if (head == null) {
            return null;
        }
        // 遍历第一遍插入复制节点
        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        // 遍历第二遍拷贝random
        cur = head;
        while(cur != null) {
            Node newNode = cur.next;
            newNode.random = cur.random!=null ? cur.random.next : null;
            cur = cur.next.next;
        }
        // 遍历第三遍恢复已有节点
        Node newHead = head.next;
        Node node = head;
        while(node != null) {
            Node newNode = node.next;
            node.next = newNode.next;
            newNode.next = newNode.next != null ? newNode.next.next : null;
            node = node.next;
        }
        return newHead;
    }
}
