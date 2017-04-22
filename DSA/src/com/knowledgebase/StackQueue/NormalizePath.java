package com.knowledgebase.StackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Created by rahul.pandey on 4/21/17.
 */
public class NormalizePath {

    private static String normalizePath(String path) {
        if (path == null || path.trim().length() == 1) return "";
        Deque<String> stack = new LinkedList<>();
        //add '/' to the stack as it is the root
        if (path.startsWith("/")) {
            stack.push("/");
        }
        String[] tokens = path.split("/");
        for (String token : tokens) {
            //there can be two cases if there are more than one .. then push it
            //if .. comes after / then path is invalid
            //else pop the latest element when .. is encountered
            if (token.equals("..")) {
                if (stack.isEmpty() || stack.peek().equals("..")) {
                    stack.push(token);
                } else {
                    if (stack.peek().equals("/")) {
                        throw new IllegalArgumentException("Not a valid path");
                    }
                    stack.pop();
                }
            } else if (!token.equals(".") || !token.isEmpty()) {
                //skip '.' and push the token if it is a word
                stack.push(token);
            }
        }

        StringBuilder builder = new StringBuilder();
        if(!stack.isEmpty()) {
            Iterator<String> itr = stack.descendingIterator();
            String prev = itr.next();
            while(itr.hasNext()) {
                //this check is for the first / that we pushed
                if(!prev.equals("/")) {
                    builder.append("/");
                }
                prev = itr.next();
                builder.append(prev);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(normalizePath("/usr/lib/../bin/gcc"));
    }
}
