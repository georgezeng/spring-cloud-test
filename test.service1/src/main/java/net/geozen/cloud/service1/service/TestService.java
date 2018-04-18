package net.geozen.cloud.service1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import net.geozen.cloud.service1.config.Service1Config;

@Service
public class TestService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Service1Config config;

	private int count;

//	@HystrixCommand(fallbackMethod = "getCommonName")
	public String getMessage() {
		logger.debug("get message........");
		if (count > 2) {
			logger.info("encountered error.......");
			throw new RuntimeException("some error");
		}
		logger.info("counted.......");
		count++;
		return config.getService1Msg();
	}

	public String getCommonName() {
		return config.getCommonName();
	}
}
