package com.jack.baseDemo;

/**
 * Created by jack on 2017/7/5.
 */
public class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    private RunnableDemo(String name){
        threadName = name;
        System.out.println("construct creating " + threadName);
    }
    public void run() {
        System.out.println("Running " + threadName);

        for (int i = 0; i < 4; i++) {
            System.out.println("Thread: " + threadName + "-----" + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " is interrupted");
            }
        }
        System.out.println("Thread " + threadName + "exiting");
    }

    private void start(){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("R1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("R2");
        R2.start();
    }
}
