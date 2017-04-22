package com.knowledgebase.StackQueue.utils;

/**
 * Created by rahul.pandey on 4/8/17.
 */
public class StackQueueTest {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Current Element " + stack.peek());
        stack.pop();
        stack.pop();
        System.out.println("Current Element " + stack.peek());
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(8);
        queue.add(10);
        System.out.println("Current Element in Queue " + queue.peek());
        queue.delete();
        queue.delete();
        System.out.println("Current Element in Queue " + queue.peek());
    }
}
