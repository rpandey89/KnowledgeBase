package com.knowledgebase.LambdaFileRead;

import com.knowledgebase.LambdaFileRead.behavior.BufferedReaderProccessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rahul.pandey on 4/18/17.
 */
public class Main {

    private static String processFileOld() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/rahul.pandey/projects/playgroundprojects/KnowledgeBase/JAVA8/Intro.md"))) {
            return br.readLine();
        }
    }

    private static String processFile(BufferedReaderProccessor bp) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/rahul.pandey/projects/playgroundprojects/KnowledgeBase/JAVA8/Intro.md"))) {
            return bp.process(br);
        }
    }


    public static void main(String[] args) {
        try {
            System.out.println(processFileOld());
            System.out.println(processFile((BufferedReader br) ->  br.readLine() + br.readLine() + br.readLine()));
        } catch(IOException ex) {
            ex.printStackTrace();
        }


    }

}
