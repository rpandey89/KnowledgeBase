package com.knowledgebase.TreeGraph;

import com.knowledgebase.TreeGraph.utils.Node;

/**
 * Created by rahul.pandey on 4/9/17.
 */
public class MinimalBST {

    private static Node<Integer> minimalBST(int[] arr, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            Node<Integer> node = new Node<>(arr[mid]);
            node.children = new Node[2];
            node.children[0] = minimalBST(arr, start, mid - 1);
            node.children[1] = minimalBST(arr, mid + 1, end);
            return node;
        }
        return null;
    }
}
