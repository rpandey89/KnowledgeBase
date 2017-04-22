package com.knowledgebase.StackQueue.utils;

import java.util.NoSuchElementException;

/**
 * Created by rahul.pandey on 4/8/17.
 */
public class MyQueue<T> {
    Node<T> first;
    Node<T> last;

    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (last == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public T delete() {
        if (first == null) throw new NoSuchElementException();
        T item = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return item;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
