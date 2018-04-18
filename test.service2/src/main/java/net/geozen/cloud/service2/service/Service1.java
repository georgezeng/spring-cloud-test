package net.geozen.cloud.service2.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("${services.service1Id}")
public interface Service1 {
	@RequestMapping(value="/test/message")
	String getTestMessage();
}
