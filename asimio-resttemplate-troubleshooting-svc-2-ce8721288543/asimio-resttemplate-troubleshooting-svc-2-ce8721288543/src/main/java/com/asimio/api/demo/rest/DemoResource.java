package com.asimio.api.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/delegate")
public class DemoResource {

	@Autowired
	private RestTemplate restTemplate=new RestTemplate();

	CyclicBarrier cyclicBarrier=new CyclicBarrier(5);


	AtomicInteger atomicInteger=new AtomicInteger(0);

	@RequestMapping(path = "/demo", method = RequestMethod.GET)
	public String getDemoDelegate(@RequestParam final String word) {
		try {
			System.out.println(cyclicBarrier.getParties());
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("http://localhost:7733/api/fetch/prioritisedTicket/admin : " + Thread.currentThread().getName());
		restTemplate.postForEntity("http://localhost:7733/api/fetch/prioritisedTicket/" + word, null, TicketsViewModel.class);
		cyclicBarrier.reset();
		//return "demo";

		/*List<Integer> integers = new CopyOnWriteArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		Iterator<Integer> itr = integers.iterator();
		while (itr.hasNext()) {
			Integer a = itr.next();
			integers.remove(a);
		}*/
		return  "demo";
	}



	public void checkForRetry() {
		try {
			restTemplate.getForEntity("http://localhost:8800/demo/chandranshu",String.class);
			System.out.println("finished with out exception");
		} catch (RestClientException e) {
			e.printStackTrace();
		}

	}

	public void checkPostRetry() {
		try {
			restTemplate.postForEntity("http://localhost:8800/demo/chandranshu",null,String.class);
			System.out.println("finished with out exception");
		} catch (RestClientException e) {
			e.printStackTrace();
		}

	}


//	public  <T, V> ResponseEntity<V> postObject(T object, final ParameterizedTypeReference<V> type, String url) {
//		try {
//		return	restTemplate.postForEntity("http://localhost:8086/api/agentWPMappings", null, TicketsViewModel.class);
//
//			//return restTemplate.exchange("http://localhost:7733/api/fetch/prioritisedTicket/chandra_009", HttpMethod.POST, new HttpEntity<T>(object), type);
//		} catch (RestClientException e) {
//			//log.error("Error while processing posting to url {} for with {} got exception {}", url, object, e);
//			return new ResponseEntity<V>(HttpStatus.BAD_GATEWAY);
//		}
//	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
