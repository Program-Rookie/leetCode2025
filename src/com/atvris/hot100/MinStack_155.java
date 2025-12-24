package com.atvris.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjh
 * @date 2025/12/23 21:12
 */
public class MinStack_155 {

    // 个人感觉用Deque有点赖了就用了ArrayList，这种效率不是很高，同时在pop的时候min的计算有点慢
    
    // 要考虑极致高效可以手写个链表,链表节点是一个对象，包括Integer val和Integer diff;
    // diff代表入栈时，与当前最小值的差值，方便出栈时恢复，如果差值为正数那就不用修改
    List<Integer> vals = new ArrayList<>();
    Integer min = Integer.MAX_VALUE;

    public MinStack_155() {

    }

    public void push(int val) {
        this.vals.add(val);
        this.min = Math.min(min, val);
    }

    public void pop() {
        this.vals.remove(this.vals.size() - 1);
        int minT = Integer.MAX_VALUE;
        for(int i = 0; i < this.vals.size();i++) {
            minT = Math.min(minT, this.vals.get(i));
        }
        this.min = minT;
    }

    public int top() {
        return this.vals.get(this.vals.size() - 1);
    }

    public int getMin() {
        return this.min;
    }
}
