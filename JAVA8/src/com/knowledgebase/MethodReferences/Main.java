package com.knowledgebase.MethodReferences;

import com.knowledgebase.behaviorParamJava8.bean.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Created by rahul.pandey on 5/1/17.
 */
public class Main {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1, "blue", 250));
        apples.add(new Apple(2, "green", 15));
        apples.add(new Apple(3, "yellow", 250));
        apples.add(new Apple(4, "orange", 100));
        apples.add(new Apple(5, "green", 250));
        Collections.sort(apples, (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
    }
}
