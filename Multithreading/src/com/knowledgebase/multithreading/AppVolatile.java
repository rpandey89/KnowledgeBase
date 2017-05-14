package com.knowledgebase.multithreading;

/**
 * Created by rahul.pandey on 5/6/17.
 */

/*class Worker implements Runnable {

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }

    private boolean isTerminated = false;

    @Override
    public void run() {
        while(!isTerminated) {
            System.out.println("Hello from worker class...");
            try{
                Thread.sleep(100);
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }

        }
    }
}*/

public class AppVolatile {

    private volatile boolean sharedVariable = false;
    private boolean sharedVariable2 = false;


    private static class Worker1 extends Thread {
        @Override
        public void run() {

        }
    }

    private static class Worker2 extends Thread {
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {

    }
}
