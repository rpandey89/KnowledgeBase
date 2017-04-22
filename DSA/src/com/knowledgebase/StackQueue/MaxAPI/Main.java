package com.knowledgebase.StackQueue.MaxAPI;

/**
 * Created by rahul.pandey on 4/20/17.
 */
public class Main {

    public static void main(String[] args) {
        StackWithMaxElement stackWithMaxElement = new StackWithMaxElement();
        stackWithMaxElement.push(new Integer(3));
        stackWithMaxElement.push(new Integer(-1));
        System.out.println(stackWithMaxElement.max());
        stackWithMaxElement.push(new Integer(10));
        System.out.println(stackWithMaxElement.max());
        stackWithMaxElement.pop();
        System.out.println(stackWithMaxElement.max());
    }
}
