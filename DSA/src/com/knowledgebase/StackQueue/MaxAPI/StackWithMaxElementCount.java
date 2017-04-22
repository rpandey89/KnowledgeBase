package com.knowledgebase.StackQueue.MaxAPI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rahul.pandey on 4/20/17.
 */

class MaxElementWithCount {
    Integer max;
    Integer count;

    public MaxElementWithCount(Integer max, Integer count) {
        this.max = max;
        this.count = count;
    }
}

public class StackWithMaxElementCount {

    Deque<Integer> stack = new LinkedList<>();
    Deque<MaxElementWithCount> maxStack = new LinkedList<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Integer max() {
        if (isEmpty()) throw new IllegalStateException();
        return maxStack.peek().max;
    }

    public Integer pop() {
        if (isEmpty()) throw new IllegalStateException();
        if (maxStack.peek().max == peek()) {
            maxStack.peek().count += 1;
        }
        return stack.pop();
    }

    public Integer peek() {
        if (isEmpty()) throw new IllegalStateException();
        return stack.peek();
    }

    public void push(Integer data) {
        stack.push(data);
        if (!maxStack.isEmpty()) {
            if (Integer.compare(data, maxStack.peek().max) == 0) {
                maxStack.peek().count += 1;
            } else if (Integer.compare(data, maxStack.peek().max) > 0) {
                maxStack.push(new MaxElementWithCount(data, 1));
            }
        } else {
            maxStack.push(new MaxElementWithCount(data, 1));
        }
    }


}
