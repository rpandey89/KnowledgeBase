package com.LinkedList;

import com.LinkedList.utils.Node;
import com.LinkedList.utils.LinkList;

/**
 * Created by rahul.pandey on 4/8/17.
 */
public class Partition {

    private static Node createPartition(Node node, int pivotValue) {
        if (node == null) return null;
        else {
            Node head = node, tail = node;
            while (node != null) {
                Node next = node.next;
                if (node.data <= pivotValue) {
                    node.next = head;
                    head = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
                node = next;
            }
            tail.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 5, 10, 2, 1};
        Node node = LinkList.createLinkListFromArray(arr);
        LinkList.displayLL(node);
        Node head = createPartition(node, 5);
        LinkList.displayLL(head);
    }
}
