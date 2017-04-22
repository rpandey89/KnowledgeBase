package com.knowledgebase.StackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rahul.pandey on 4/21/17.
 */

class PostingNode {
    int order;
    int data;
    PostingNode next;
    PostingNode jump;

    PostingNode(int data) {
        this.data = data;
        this.order = -1;
        this.next = null;
        this.jump = null;
    }
}

public class PostingList {

    private static void setJumpOrderHelperRecur(PostingNode L, int order) {
        if (L != null && L.order == -1) {
            L.order = order++;
            setJumpOrderHelperRecur(L.jump, order);
            setJumpOrderHelperRecur(L.next, order);
        }
    }

    private static void setJumpOrderHelperNonRecur(PostingNode L) {
        Deque<PostingNode> stack = new LinkedList<>();
        stack.push(L);
        int order = 0;
        while (!stack.isEmpty()) {
            PostingNode node = stack.pop();
            if (node != null && node.order == -1) {
                node.order = order++;
                stack.push(node.next);
                stack.push(node.jump);
            }
        }
    }


    public static void main(String[] args) {

        PostingNode node = new PostingNode(1);
        PostingNode node1 = new PostingNode(2);
        PostingNode node3 = new PostingNode(3);
        PostingNode node4 = new PostingNode(4);
        node.next = node1;
        node1.jump = node4;
        node1.next = node3;
        node1.jump = node;
        node3.next = node4;
        node1.jump = node1;


    }
}
