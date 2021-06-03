package tut8.api.executors.joining;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tuts.common.CountDownTask;

public class JoiningExecutorCountdown {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(2);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.submit(new CountDownTask(countDownLatch));
			countDownLatch.await();
			System.out.println("countDownLatch.getCount() :"+countDownLatch.getCount());
		}

	}

}
