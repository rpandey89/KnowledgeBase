package com.knowledgebase.behaviorParamJava8.bean;

import java.util.Comparator;

/**
 * Created by rahul.pandey on 4/17/17.
 */
public class Apple implements Comparable<Apple> {

    private int id;
    private String color;
    private int weight;

    public Apple(int id, String color, int weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Apple a) {
        if (this.getWeight() > a.getWeight()) {
            return 1;
        } else if (this.getWeight() == a.getWeight()) {
            return 0;
        }
        return -1;
    }
}
