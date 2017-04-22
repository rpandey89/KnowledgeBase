package com.knowledgebase.LinkedList;

import com.knowledgebase.LinkedList.utils.Node;
import com.knowledgebase.LinkedList.utils.LinkList;

/**
 * Created by rahul.pandey on 4/8/17.
 */
class Result {
    Node node;
    boolean isPalindrome;

    public Result(Node node, boolean isPalindrome) {
        this.isPalindrome = isPalindrome;
        this.node = node;
    }
}

public class Palindrome {

    //there are other ways too reverse the linked list and compare with the original
    //put all the elements till the mid point on the stack and then compare one by one
    //this is a recursive way
    //another way is to  compare the first half and second half using runner approach, that will be simpler
    private static Result isPalindrome(Node node, int length) {
        if (node == null || length == 0) {
            return new Result(node, true);
        } else if (length == 1) {
            return new Result(node.next, true);
        }

        Result res = isPalindrome(node.next, length - 2);

        if (!res.isPalindrome || res.node == null) {
            return res;
        }

        res.isPalindrome = node.data == res.node.data;

        res.node = res.node.next;

        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 0, 1};
        Node node = LinkList.createLinkListFromArray(array);
        Result node1 = isPalindrome(node, LinkList.getLLLength(node));
        System.out.println("is palindrome ? " + node1.isPalindrome);
    }
}
