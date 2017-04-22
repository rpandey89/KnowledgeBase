package com.knowledgebase.Maths;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * Created by rahul.pandey on 2/3/17.
 */

public class Karatsuba {

    private static long karatSubaMult(long num1, long num2) {
        int length1 = new Long(num1).toString().length(), length2 = new Long(num2).toString().length();
        if (length1 == 1 || length2 == 1) {
            return num1 * num2;
        }
        int outputDigits = length1 < length2 ? length1 : length2;
        long partDigits = (long) Math.pow(10, outputDigits % 2 == 0 ? outputDigits / 2 : (outputDigits/2) + 1);
        long first = num1 / partDigits, second = (num1 % partDigits);
        long third = num2 / partDigits, fourth = (num2 % partDigits);
        long exponent1 = (long) Math.pow(10, outputDigits % 2 == 0  ? outputDigits : outputDigits + 1);
        long exponent2 = (long) Math.pow(10, outputDigits % 2 == 0 ? outputDigits / 2 : (outputDigits / 2) + 1);
        return exponent1 * karatSubaMult(first, third) + exponent2 * (karatSubaMult(first, fourth) + karatSubaMult(second, third)) + karatSubaMult(second, fourth);
    }

    public static void main(String[] args) {
        List<Long> numList = new ArrayList<Long>();
        System.out.println("Enter two whole numbers ");
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLong()) {
            numList.add(scan.nextLong());
        }
        Long[] numArray = numList.toArray(new Long[numList.size()]);

        //long num1 = 56789, num2 = 12349;
        long num1 = numArray[0], num2 = numArray[1];
        System.out.println("com.knowledgebase.Maths.Karatsuba multiplication result -->> " + karatSubaMult(num1, num2));
    }
}
