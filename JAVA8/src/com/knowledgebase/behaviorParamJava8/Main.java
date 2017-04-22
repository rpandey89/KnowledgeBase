package com.knowledgebase.behaviorParamJava8;

import com.knowledgebase.behaviorParamJava8.bean.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by rahul.pandey on 4/17/17.
 */
public class Main {

    private static <T> List<T> filterApples(List<T> apples, Predicate<T> p) {
        List<T> filteredList = new ArrayList<>();
        for (T a : apples) {
            if (p.test(a)) {
                filteredList.add(a);
            }
        }
        return filteredList;
    }

    /*private static <T> void prettyPrint(List<T> apples, Predicate<T> p) {
        for (T a : apples) {
            System.out.println(p.display(a));
        }
    }*/


    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1, "blue", 250));
        apples.add(new Apple(2, "green", 15));
        apples.add(new Apple(3, "yellow", 250));
        apples.add(new Apple(4, "orange", 100));
        apples.add(new Apple(5, "green", 250));


        List<Apple> greenColoredApples = filterApples(apples, (Apple a) -> "green".equals(a.getColor()));
        List<Apple> heavyApples = filterApples(apples, (Apple a) -> a.getWeight() > 150);

        System.out.println("Green colored apples");
        for (Apple a : greenColoredApples) {
            System.out.print(a.getId() + " " + a.getColor() + " " + a.getWeight() + " ");
        }

        System.out.println("\n\nHeavy apples");
        for (Apple a : heavyApples) {
            System.out.print(a.getId() + " " + a.getColor() + " " + a.getWeight() + " ");
        }
        //prettyPrint(apples, (Apple a) -> (a.getId() + " " + a.getColor() + " " ));
    }
}
