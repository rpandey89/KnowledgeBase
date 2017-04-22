package com.knowledgebase.behaviorParamOld;

import com.knowledgebase.behaviorParamOld.bean.Apple;
import com.knowledgebase.behaviorParamOld.predicate.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by rahul.pandey on 4/17/17.
 */
public class Main {

    private static List<Apple> filterApples(List<Apple> apples, ApplePredicate p) {
        List<Apple> filteredList = new ArrayList<>();
        for (Apple a : apples) {
            if (p.test(a)) {
                filteredList.add(a);
            }
        }
        return filteredList;
    }

    private static void prettyPrint(List<Apple> apples, ApplePrintPredicate p) {
        for (Apple a : apples) {
            System.out.println(p.display(a));
        }
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1, "blue", 250));
        apples.add(new Apple(2, "green", 15));
        apples.add(new Apple(3, "yellow", 250));
        apples.add(new Apple(4, "orange", 100));
        apples.add(new Apple(5, "green", 250));

        ApplePredicate colorPredicate = new AppleColorPredicate();
        ApplePredicate weightPredicate = new AppleWeightPredicate();
        ApplePrintPredicate weightPrintPredicate = new ApplePrintWeight();
        ApplePrintPredicate heavyLightPredicate = new ApplePrintHeavyLigthApple();

        List<Apple> greenColoredApples = filterApples(apples, colorPredicate);
        List<Apple> heavyApples = filterApples(apples, weightPredicate);

        /*System.out.println("Green colored apples");
        for (Apple a : greenColoredApples) {
            System.out.print(a.getId() + " " + a.getColor() + " " + a.getWeight() + " ");
        }

        System.out.println("\n\nHeavy apples");
        for (Apple a : heavyApples) {
            System.out.print(a.getId() + " " + a.getColor() + " " + a.getWeight() + " ");
        }*/
        prettyPrint(apples, heavyLightPredicate);
    }
}
