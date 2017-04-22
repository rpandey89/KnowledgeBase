package com.knowledgebase.StackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rahul.pandey on 4/21/17.
 */
public class WellFormedParans {

    private static boolean checkWellFormed(String paranString) {
        if (paranString == null || paranString.length() == 1 &&
                (paranString.charAt(0) == ')' || paranString.charAt(0) == '}' || paranString.charAt(0) == ']'))
            return false;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < paranString.length(); i++) {
            if (paranString.charAt(i) == '(' || paranString.charAt(i) == '{' || paranString.charAt(i) == '[') {
                stack.push(paranString.charAt(i));
            } else{
                if(stack.isEmpty()) {
                    return false;
                } else if((paranString.charAt(i) == '}' && stack.peek() != '{') ||
                        (paranString.charAt(i) == ')' && stack.peek() != '(') ||
                        (paranString.charAt(i) == ']' && stack.peek() != '[')) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(checkWellFormed("[()[]{()()}]"));
    }
}
