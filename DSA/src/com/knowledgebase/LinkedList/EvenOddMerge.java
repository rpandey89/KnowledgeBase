package com.knowledgebase.LinkedList;

import com.knowledgebase.LinkedList.utils.Node;
import com.knowledgebase.LinkedList.utils.LinkList;

/**
 * Created by rahul.pandey on 4/20/17.
 */
public class EvenOddMerge {

    private static Node evenOddMerge(Node head) {
        if (head != null && head.next != null) {
            Node evenTail = head, oddTail = head.next, oddHead = oddTail, currNode = head.next.next;
            int turn = 0;
            while (currNode != null) {
                if (turn == 0) {
                    evenTail.next = currNode;
                    evenTail = evenTail.next;
                } else {
                    oddTail.next = currNode;
                    oddTail = oddTail.next;
                }
                Node temp = currNode;
                currNode = currNode.next;
                temp.next = null;
                turn ^= 1;
            }
            evenTail.next = oddHead;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = evenOddMerge(LinkList.createLinkListFromArray(new int[]{1, 2, 3, 4, 5, 6, 8}));
        LinkList.displayLL(head);
    }

}
