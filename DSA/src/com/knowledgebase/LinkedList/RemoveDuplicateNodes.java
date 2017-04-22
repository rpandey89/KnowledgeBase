package com.knowledgebase.LinkedList;

import com.knowledgebase.LinkedList.utils.Node;
import com.knowledgebase.LinkedList.utils.LinkList;

/**
 * Created by rahul.pandey on 4/19/17.
 */
public class RemoveDuplicateNodes {

    private static Node removeDuplicates(Node head) {
        if (head != null) {
            Node currNode = head;
            while (currNode != null && currNode.next != null) {
                Node subListNodes = currNode.next;
                while (subListNodes != null && subListNodes.data == currNode.data) {
                    subListNodes = subListNodes.next;
                }
                currNode.next = subListNodes;
                currNode = currNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = removeDuplicates(LinkList.createLinkListFromArray(new int[]{1, 2, 3, 4, 4, 5, 5, 5, 5, 6, 8}));
        LinkList.displayLL(head);
    }
}
