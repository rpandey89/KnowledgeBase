package com.TreeGraph.utils;

/**
 * Created by rahul.pandey on 4/9/17.
 */
public class Node<T> {
    public T item;
    public boolean visited;
    public Node[] children;

    public Node(T item) {
        this.item = item;
        this.visited = false;
    }
}
