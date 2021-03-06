package com.chan.newFeature;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierCompletionMethodExample {

    private int count;
    private int threadCount;
    //private int taskCount;
    private final AtomicInteger updateCount;
    
    CyclicBarrierCompletionMethodExample(int count, int threadCount) {
        updateCount = new AtomicInteger(0);
        this.count = count;
        this.threadCount = threadCount;
    }

    public int countTrips() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
            updateCount.incrementAndGet();
        });

        ExecutorService es = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            es.execute(() -> {
                try {
                   // taskCount++;
                   // System.out.println(Thread.currentThread().getName()+""+taskCount);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();
        return updateCount.get();
    }

    public static void main(String[] args) {
        CyclicBarrierCompletionMethodExample ex = new CyclicBarrierCompletionMethodExample(5, 20);
        System.out.println("Count : " + ex.countTrips());
    }
}
