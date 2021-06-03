package tuts.common;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class CountDownTask implements Callable<String> {

	private CountDownLatch countDownLatch;

	public CountDownTask(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" : " + i);
		}
		//Thread.sleep(2000);
		countDownLatch.countDown();
		countDownLatch.countDown();
		// TODO Auto-generated method stub
		return Thread.currentThread().getName();
	}

}
