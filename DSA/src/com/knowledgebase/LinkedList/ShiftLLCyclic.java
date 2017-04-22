package com.knowledgebase.LinkedList;

import com.knowledgebase.LinkedList.utils.Node;
import com.knowledgebase.LinkedList.utils.LinkList;

/**
 * Created by rahul.pandey on 4/19/17.
 */
public class ShiftLLCyclic {

    private static Node shiftCyclic(Node head, int k) {
        if (head != null && k > 0) {
            Node tail = head;
            int length = 1;
            while (tail.next != null) {
                tail = tail.next;
                length++;
            }
            k = length - (k % length);
            if (k > 0) {
                Node newTail = head;
                while (k-- > 1) {
                    newTail = newTail.next;
                }
                tail.next = head;
                head = newTail.next;
                newTail.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = shiftCyclic(LinkList.createLinkListFromArray(new int[]{1, 2, 3, 4, 5, 6, 8}), 3);
        LinkList.displayLL(head);
    }
}
