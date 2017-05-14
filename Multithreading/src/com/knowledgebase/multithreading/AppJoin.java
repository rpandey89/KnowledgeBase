package com.knowledgebase.multithreading;

/**
 * Created by rahul.pandey on 5/6/17.
 */
public class AppJoin {

    public static void main(String[] args) {
        Runner1Threaded t1 = new Runner1Threaded();
        Runner2Threaded t2 = new Runner2Threaded();

        t1.start();
        t2.start();

        try{
            //Waits for this thread to die.
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Finished the tasks....");
    }
}
