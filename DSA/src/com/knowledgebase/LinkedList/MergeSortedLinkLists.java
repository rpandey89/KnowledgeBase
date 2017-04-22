package com.knowledgebase.LinkedList;

import com.knowledgebase.LinkedList.utils.LinkList;
import com.knowledgebase.LinkedList.utils.Node;

/**
 * Created by rahul.pandey on 4/18/17.
 */
public class MergeSortedLinkLists {


    private static Node getMergeLL(Node head1, Node head2) {
        Node head = null, currentNode = head;
        while (head1 != null && head2 != null) {
            if (head == null) {
                if (head1.data < head2.data) {
                    head = head1;
                    head1 = head1.next;
                } else {
                    head = head2;
                    head2 = head2.next;
                }
                currentNode = head;
            } else {
                if (head1.data < head2.data) {
                    currentNode.next = head1;
                    head1 = head1.next;
                } else {
                    currentNode.next = head2;
                    head2 = head2.next;
                }
                currentNode = currentNode.next;
            }
        }

        currentNode.next = head1 != null ? head1 : head2;
        return head;

    }

    public static void main(String[] args) {

        int[] a = {2, 5, 7};
        int[] b = {3, 11};
        Node list1 = LinkList.createLinkListFromArray(a);
        Node list2 = LinkList.createLinkListFromArray(b);
        Node finalHead = getMergeLL(list1, list2);
        LinkList.displayLL(finalHead);
    }
}
