package com.knowledgebase.LinkedList;

import com.knowledgebase.LinkedList.utils.LinkList;
import com.knowledgebase.LinkedList.utils.Node;

/**
 * Created by rahul.pandey on 4/19/17.
 */
public class IntersectionInCyclicLists {

    private static int getDistance(Node start, Node end) {
        int k = 0;
        while (start != end) {
            start = start.next;
            k++;
        }
        return k;
    }

    private static Node getOverlappingNodeInCyclicLists(Node head1, Node head2) {
        Node root1 = LoopDetection.getLoopStartNode(head1);
        Node root2 = LoopDetection.getLoopStartNode(head2);
        if (root1 == null && root2 == null) {
            //if both are cycle free then get using normal method
            return Intersection.getIntersection(head1, LinkList.getTailNode(head1), head2, LinkList.getTailNode(head2), LinkList.getLLLength(head1), LinkList.getLLLength(head2));
        } else if (root1 != null && root2 == null || root2 != null && root1 == null) {
            //if only one has cycle then they can't overlap
            return null;
        }

        //now check whether both have same cycle
        Node temp = root2;
        do {
            temp = temp.next;
        } while (temp != root2 && temp != root2);
        //disjoint cycles
        if (temp != root1) return null;
        int dist1 = getDistance(head1, root1);
        int dist2 = getDistance(head2, root2);
        Node first = dist1 > dist2 ? head1 : head2;
        Node second = dist1 < dist2 ? head1 : head2;
        int k = 0;
        while (k < Math.abs(dist1 - dist2)) {
            first = first.next;
        }
        //if the lists overlap before cycle then return the intersection here else return any node on the cycle
        return first == second ? first : root1;
    }


}
