package com.behaviorParamOld.predicate;

import com.behaviorParamOld.bean.Apple;

/**
 * Created by rahul.pandey on 4/17/17.
 */
public class AppleWeightPredicate implements ApplePredicate{

    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
