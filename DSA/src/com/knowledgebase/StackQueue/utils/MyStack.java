package com.knowledgebase.StackQueue.utils;

import java.util.EmptyStackException;

/**
 * Created by rahul.pandey on 4/8/17.
 */
public class MyStack<T> {

    private Node<T> top;

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> node = new Node(item);
        node.next = top;
        top = node;
    }

    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
