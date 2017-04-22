package com.knowledgebase.behaviorParamOld.predicate;
import com.knowledgebase.behaviorParamOld.bean.Apple;

/**
 * Created by rahul.pandey on 4/17/17.
 */
public class AppleColorPredicate implements ApplePredicate{

    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
