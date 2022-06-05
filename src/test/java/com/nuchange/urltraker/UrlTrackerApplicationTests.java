package com.nuchange.urltraker;

import com.nuchange.urltraker.model.UrlCountlModel;
import com.nuchange.urltraker.service.UrlService;
import com.nuchange.urltraker.service.impl.UrlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@SpringBootTest
class UrlTrackerApplicationTests {

	protected UrlService service;

	@BeforeEach
	public void setUp(){
		service = new UrlServiceImpl();
	}

	@Test
	@DisplayName("Test storeurl API")
	public void storeUrlTest(){
		ResponseEntity response = service.saveUrl("google.com");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	@DisplayName("Test get API")
	public void get(){
		String response = service.getUrl("google.com");
		assertEquals("google", response);
	}

	@Test
	@DisplayName("Test count with zero API")
	public void countWithZero(){
		int response = service.getCount("google.com");
		assertEquals(0,response);
	}

	@Test
	@DisplayName("Test list API")
	public void list(){
		service.saveUrl("google.com");
		service.getUrl("google.com");
		List<UrlCountlModel> response = service.getAllUrls();
		assertEquals(1,response.size());
	}

	@Test
	@DisplayName("Test count API")
	public void count(){
		service.saveUrl("google.com");
		service.getUrl("google.com");
		int response = service.getCount("google.com");
		assertEquals(4,response);
	}

}
