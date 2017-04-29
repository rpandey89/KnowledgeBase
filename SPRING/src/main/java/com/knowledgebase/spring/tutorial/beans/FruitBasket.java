package com.knowledgebase.spring.tutorial.beans;

import java.util.List;
/**
 * Created by rahul.pandey on 4/25/17.
 */
public class FruitBasket {
    private String name;
    private List<String> basket;

    public FruitBasket(String name, List<String> basket) {
        this.name = name;
        this.basket = basket;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(String el : basket) {
            builder.append(el +",");
        }
        return "FruitBasket{" +
                "name='" + name + '\'' +
                ", basket=" + builder.substring(0,builder.length()-1) +
                '}';
    }
}
