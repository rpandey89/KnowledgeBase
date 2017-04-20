package com.LinkedList;

import com.LinkedList.utils.Node;
import com.LinkedList.utils.LinkList;

/**
 * Created by rahul.pandey on 4/19/17.
 */
public class RemoveDuplicateNodes {

    private static Node removeDuplicates(Node head) {
        if (head != null) {


        }
        return head;
    }

    public static void main(String[] args) {
        Node head = removeDuplicates(LinkList.createLinkListFromArray(new int[]{1, 2, 3, 4, 4, 5, 5, 5, 5, 6, 8}));
        LinkList.displayLL(head);
    }
}
