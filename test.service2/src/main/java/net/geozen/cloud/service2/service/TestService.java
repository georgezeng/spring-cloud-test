package net.geozen.cloud.service2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {
	@Autowired
	private Service1 service1;

	@HystrixCommand
	public String getService1Msg() {
		return service1.getTestMessage();
	}
}
