package com.atvris.hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU
 * https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 15:30
 */
public class LRU_146 {
    
    class LRU {
        
        int capacity;
        int size;
        Map<Integer, Node> valMap;
        Node head;
        Node tail;
        
        class Node {
            Node left;
            Node right;
            int val;
            int key;
            public Node() {
                
            }
            
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
        
        public LRU (int capacity) {
            this.capacity = capacity;
            
            valMap = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.right = tail;
            tail.left = head;
        }
        public int get(int key) {
            Node node = valMap.get(key);
            if (node != null) {
                moveToHead(node);
                return node.val;
            }
            return -1;
        }
        
        private void moveToHead(Node node) {
            // removeNode
            removeNode(node);
            // addHead
            node.right = head.right;
            node.left = head;
            head.right.left = node;
            head.right = node;
        }
        
        private void removeNode(Node node) {
            Node left = node.left;
            Node right = node.right;
            if (left != null) {
                left.right = right;
            }
            if (right != null) {
                right.left = left;
            }
        }
        
        public void put(int key, int value) {
            if(valMap.containsKey(key)) {
                Node node = valMap.get(key);
                moveToHead(node);
            } else {
                Node node = new Node(key, value);
                valMap.put(key, node);
                // moveToHead
                moveToHead(node);
                size++;
                if (size > capacity) {
                    // removeNode
                    Node left = tail.left;
                    removeNode(left);
                    valMap.remove(left.key);
                    size--;
                }
            }
        }
    }
}
