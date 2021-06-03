package com.explore.featuredemo;

import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class FeaturedemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FeaturedemoApplication.class, args);



//		Mockito.when(f1.methNew(anyString()))
//				.thenReturn(CompletableFuture.completedFuture(Arrays.asList("A", "B", "C")));
//

		final Future<Boolean> mockedFuture = Mockito.mock(Future.class);
		Mockito.when(mockedFuture.isCancelled()).thenReturn(Boolean.TRUE);
		try {
			Mockito.when(mockedFuture.get()).thenReturn(Boolean.FALSE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("Chandranshu Awasthi");
		//when(obj.methNew(anyString()).thenReturn(mockedFuture);



	}






}
