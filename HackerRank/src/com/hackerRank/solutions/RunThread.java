package com.hackerRank.solutions;

public class RunThread implements Runnable{


    @Override
    public void run() {
        System.out.println("running");
    }


    public static void main(String[] args) {
        Thread t=new Thread(new RunThread());
        t.run();
        t.run();
        t.start();

    }
}
