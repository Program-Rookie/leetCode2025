package com.atvris.hot100;

/**
 * @author zjh
 * @date 2025/12/19 15:29
 */
public class Trie_208 {

    // 重点
    // 1.认清楚怎么有一个自循环结构
    // 2.每层最多的数量是固定的（26个英文字符）
    // 3.自循环结构怎么知道是终点（因为数量是固定的，实际填充数据为不为空不太清楚）
    // 4.如何遍历字符串，遍历过程中怎么设定值和结尾
    Trie_208[] children;
    boolean isEnd;

    public Trie_208() {
        children = new Trie_208[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie_208 node = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie_208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie_208 node = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            } else {
                node = node.children[index];
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie_208 node = this;
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            } else {
                node = node.children[index];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie_208 trie_208 = new Trie_208();
        trie_208.insert("apple");
        System.out.println(trie_208.search("apple"));
        System.out.println(trie_208.search("app"));
        System.out.println(trie_208.startsWith("app"));
        trie_208.insert("app");
        System.out.println(trie_208.search("app"));
    }
}
