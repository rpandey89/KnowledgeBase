package com.behaviorParamOld.predicate;
import com.behaviorParamOld.bean.Apple;

/**
 * Created by rahul.pandey on 4/17/17.
 */
public class AppleColorPredicate implements ApplePredicate{

    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
