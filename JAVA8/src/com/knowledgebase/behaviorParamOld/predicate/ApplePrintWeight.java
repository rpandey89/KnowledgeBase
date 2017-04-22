package com.knowledgebase.behaviorParamOld.predicate;
import com.knowledgebase.behaviorParamOld.bean.Apple;
/**
 * Created by rahul.pandey on 4/17/17.
 */
public class ApplePrintWeight implements ApplePrintPredicate {

    public String display(Apple a) {
       return a.getWeight() + " ";
    }
}
