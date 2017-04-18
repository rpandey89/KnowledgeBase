package com.LinkedList;

import com.LinkedList.utils.Node;
import com.LinkedList.utils.LinkList;

/**
 * Created by rahul.pandey on 4/8/17.
 */
public class Intersection {

    private static Node getIntersection(Node head1, Node head2, Node tail1, Node tail2, int length1, int length2) {
        if (head1 == null || head2 == null) return null;
        //if tails not similar then diff lists
        if (tail1 != tail2) return null;
        Node longListNode = length1 > length2 ? head1 : head2;
        Node shortListNode = length1 <= length2 ? head1 : head2;
        int k = Math.abs(length1 - length2);
        int i = 0;
        while (i < k) {
            longListNode = longListNode.next;
            i++;
        }

        while (longListNode != shortListNode) {
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }

        return shortListNode;
    }

    public static void main(String[] args) {
        int[] commonEl = {7, 2, 1};
        int[] array1 = {3, 1, 5, 9};
        int[] array2 = {4, 6};
        Node commonPart = LinkList.createLinkListFromArray(commonEl);
        Node head1 = LinkList.createLinkListFromArray(array1);
        Node head2 = LinkList.createLinkListFromArray(array2);
        Node tail1 = LinkList.getTailNode(head1);
        Node tail2 = LinkList.getTailNode(head2);

        tail1.next = commonPart;
        tail1 = LinkList.getTailNode(head1);
        tail2.next = commonPart;
        tail2 = LinkList.getTailNode(head2);
        LinkList.displayLL(head1);
        LinkList.displayLL(head2);
        Node commonNode = getIntersection(head1, head2, tail1, tail2,
                LinkList.getLLLength(head1), LinkList.getLLLength(head2));

        System.out.println("\nCommon Node is " + (commonNode != null ? commonNode.data : "none"));


        int[] array3 = {3, 1, 5, 9};
        int[] array4 = {4, 6};
        Node head3 = LinkList.createLinkListFromArray(array3);
        Node head4 = LinkList.createLinkListFromArray(array4);
        Node tail3 = LinkList.getTailNode(head3);
        Node tail4 = LinkList.getTailNode(head4);
        LinkList.displayLL(head3);
        LinkList.displayLL(head4);
        Node commonNode1 = getIntersection(head3, head4, tail3, tail4,
                LinkList.getLLLength(head3), LinkList.getLLLength(head4));

        System.out.println("\nCommon Node is " + (commonNode1 != null ? commonNode1.data : "none"));


    }

}
