package com.knowledgebase.StackQueue.MaxAPI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rahul.pandey on 4/20/17.
 */

class StackElement<T> {
    T data;
    T maxElement;

    public StackElement(T data, T maxElement) {
        this.data = data;
        this.maxElement = maxElement;
    }
}

public class StackWithMaxElement {
    Deque<StackElement> stack = new LinkedList<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Object max() {
        if(isEmpty()) throw new IllegalStateException();
        return stack.peek().maxElement;
    }

    public Object pop() {
        if(isEmpty()) throw new IllegalStateException();
        return stack.pop().data;
    }

    public Object peek() {
        if(isEmpty()) throw new IllegalStateException();
        return stack.peek().data;
    }

    public void push(Object data) {
        if(data instanceof Integer) {
            stack.push(new StackElement(data, isEmpty() ? data : Math.max((Integer)data, (Integer)max())));
        } else if(data instanceof Double) {
            stack.push(new StackElement(data, isEmpty() ? data : Math.max((Double)data, (Double)max())));
        }
    }

}
