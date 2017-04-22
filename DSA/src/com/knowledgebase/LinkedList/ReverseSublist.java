package com.knowledgebase.LinkedList;

import com.knowledgebase.LinkedList.utils.LinkList;
import com.knowledgebase.LinkedList.utils.Node;

/**
 * Created by rahul.pandey on 4/18/17.
 */
public class ReverseSublist {

    private static Node reverseSublist(Node head, int start, int end) {
        Node dummy = new Node(0);
        dummy.next = head;
        if (head != null || start < end) {
            Node previous = dummy;
            int k = 1;
            while (k++ < start) {
                previous = previous.next;
            }

            Node sublistEnd = previous.next;
            //at each iteration the previous sub list head keeps on moving towards end and the node at the end
            //is added at the front
            while (start++ < end) {
                Node temp = sublistEnd.next;
                sublistEnd.next = temp.next;
                temp.next = previous.next;
                previous.next = temp;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = LinkList.createLinkListFromArray(new int[]{11, 3, 5, 7, 2});
        head = reverseSublist(head, 2, 5);
        LinkList.displayLL(head);
    }
}
