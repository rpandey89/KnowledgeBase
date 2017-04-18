package com.LinkedList;

import com.LinkedList.utils.LinkList;
import com.LinkedList.utils.Node;

/**
 * Created by rahul.pandey on 4/8/17.
 */
public class LoopDetection {

    private static Node getLoopStartNode(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        //find the first collision point
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        if(fast == null || fast.next == null) {
            return null;
        }

        //now reset the slow pointer to first
        //after that slow and fast will be equidistant to start of loop
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 1, 5, 9};
        int[] array2 = {4, 6};
        Node head1 = LinkList.createLinkListFromArray(array1);
        Node head2 = LinkList.createLinkListFromArray(array2);
        Node tail1 = LinkList.getTailNode(head1);
        Node tail2 = LinkList.getTailNode(head2);
        tail1.next = head2;
        tail2.next = tail1;
        Node node = getLoopStartNode(head1);

        System.out.println("\nCommon Node is " + (node != null ? node.data : "none"));
    }
}
