package com.knowledgebase.LinkedList;

import com.knowledgebase.LinkedList.utils.LinkList;
import com.knowledgebase.LinkedList.utils.Node;

/**
 * Created by rahul.pandey on 4/19/17.
 */
public class DeleteKthLastNode {

    private static Node deleteKthLastNode(Node head, int k) {
        if (head != null && k > 0) {
            Node first = head, second = head, previous = null;
            while (k > 0) {
                first = first.next;
                k--;
            }

            while (first != null) {
                first = first.next;
                previous = second;
                second = second.next;
            }
            previous.next = second.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = LinkList.createLinkListFromArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        head = deleteKthLastNode(head, 4);
        LinkList.displayLL(head);
    }
}
