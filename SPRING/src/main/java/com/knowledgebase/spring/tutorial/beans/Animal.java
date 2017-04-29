package com.knowledgebase.spring.tutorial.beans;

/**
 * Created by rahul.pandey on 4/27/17.
 */
public class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType() {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{ Animal => name - " + name + " type - " + type + " } ";
    }
}
