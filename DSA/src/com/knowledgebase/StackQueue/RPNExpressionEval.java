package com.knowledgebase.StackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rahul.pandey on 4/20/17.
 */
public class RPNExpressionEval {

    private static double eval(String exp) {
        if (exp == null || exp.trim().length() == 0) return 0;
        String[] expressionList = exp.split(",");
        Deque<Double> stack = new LinkedList<>();
        String ops = "+*/-";
        for (String token : expressionList) {
            if (token.length() == 1 && ops.contains(token)) {
                Double y = stack.pop();
                Double x = stack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(x + y);
                        break;
                    case '-':
                        stack.push(x - y);
                        break;
                    case '*':
                        stack.push(x * y);
                        break;
                    case '/':
                        stack.push(x == 0 || y == 0 ? 0 : x / y);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return !stack.isEmpty() ? stack.pop() : 0;
    }

    public static void main(String[] args) {
        System.out.println(eval("2,7,+,8,/"));
    }
}
