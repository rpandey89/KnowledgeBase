package com.behaviorParamOld.predicate;

import com.behaviorParamOld.bean.Apple;

/**
 * Created by rahul.pandey on 4/17/17.
 */
public class ApplePrintHeavyLigthApple implements ApplePrintPredicate {

    public String display(Apple a) {
        String isHeavy = a.getWeight() > 150 ? "heavy" : "light";
        return a.getId() + " " + a.getColor() + " " + isHeavy;
    }
}
