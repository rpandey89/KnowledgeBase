package com.knowledgebase.TreeGraph;

import com.knowledgebase.TreeGraph.utils.Node;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rahul.pandey on 4/9/17.
 */
public class GraphSearch {

    private static void bfs(Node<Integer> head) {
        if(head == null) return;
        Queue<Node<Integer>> queue = new PriorityQueue<>();
        System.out.println("Visited Node " + head.item);
        head.visited = true;
        queue.add(head);
        while(!queue.isEmpty()) {
            Node<Integer> node = queue.remove();
            for(Node n : node.children) {
                if(!n.visited) {
                    System.out.println("Visited Node " + n.item);
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
    }

    private static void dfs(Node<Integer> head) {
        if(head == null) return;
        System.out.println("Visited Node " + head.item);
        head.visited = true;
        for(Node n : head.children) {
            if(!n.visited) {
                dfs(n);
            }
        }
    }
}
