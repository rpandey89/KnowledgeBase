package com.knowledgebase.multithreading;

/**
 * Created by rahul.pandey on 5/6/17.
 */
class Runner1ThreadedRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1: " + i);
        }
    }

}

class Runner2ThreadedRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner2: " + i);
        }
    }

}

public class AppThreadedRunnable {


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1ThreadedRunnable());
        Thread t2 = new Thread(new Runner2ThreadedRunnable());

        t1.start();
        t2.start();

    }
}