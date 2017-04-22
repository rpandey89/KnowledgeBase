package com.knowledgebase.LinkedList.utils;

/**
 * Created by rahul.pandey on 4/8/17.
 */
public class LinkList {

    public static Node createLinkListFromArray(int[] array) {
        Node head = new Node(array[0]);
        Node currNode = head;
        for (int i = 1; i < array.length; i++) {
            Node node = new Node(array[i]);
            currNode.next = node;
            currNode = currNode.next;
        }
        return head;
    }

    public static void displayLL(Node head) {
        Node currNode = head;
        System.out.println("\nLinked List is - ");
        while (currNode != null) {
            System.out.print(currNode.data);
            if (currNode.next != null) System.out.print(" -> ");
            currNode = currNode.next;
        }
    }

    public static int getLLLength(Node node) {
        int length = 0;
        if (node == null) return 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static Node getTailNode(Node node) {
        if (node == null || node.next == null) return node;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

}
