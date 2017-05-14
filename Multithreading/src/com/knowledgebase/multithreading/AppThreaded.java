package com.knowledgebase.multithreading;

/**
 * Created by rahul.pandey on 5/6/17.
 */

class Runner1Threaded extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner1: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

}

class Runner2Threaded extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner2: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

}

public class AppThreaded {

    public static void main(String[] args) {
        Runner1Threaded t1 = new Runner1Threaded();
        Runner2Threaded t2 = new Runner2Threaded();

        t1.start();
        t2.start();

    }
}
