package com.knowledgebase.spring.tutorial.beans;

import java.util.List;

/**
 * Created by rahul.pandey on 4/27/17.
 */
public class Jungle {

    private Animal largest;
    private List<Animal> animals;

    public void setLargest(Animal largest) {
        this.largest = largest;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Animal animal : animals) {
            builder.append(animal.toString()).append(", ");
        }
        return "{ Jungle ==> "+ builder.substring(0,builder.length()-1) +"}";
    }
}
