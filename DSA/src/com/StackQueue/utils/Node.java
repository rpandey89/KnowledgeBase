package com.StackQueue.utils;

/**
 * Created by rahul.pandey on 4/8/17.
 */
public class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
