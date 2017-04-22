package com.knowledgebase.StackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Created by rahul.pandey on 4/21/17.
 */
class Building {
    int id;
    int height;

    Building(int id, int height) {
        this.id = id;
        this.height = height;
    }
}

public class BuildingsWithView {


    private static Deque<Building> getBuildingsWithView(Integer[] arr) {
        Deque<Building> buildings = new LinkedList<>();
        if (arr != null) {
            int id = 0;
            for (Integer el : arr) {
                while (!buildings.isEmpty() && Integer.compare(el, buildings.peek().height) >= 0) {
                    buildings.removeLast();
                }
                buildings.push(new Building(id++, el));
            }
        }
        return buildings;
    }

    public static void main(String[] args) {
        Deque<Building> buildings = getBuildingsWithView(new Integer[]{3, 5, 2, 6, 1});
        Iterator<Building> it = buildings.iterator();
        while(it.hasNext()) {
            System.out.print(it.next().height + " ");
        }
    }

}
