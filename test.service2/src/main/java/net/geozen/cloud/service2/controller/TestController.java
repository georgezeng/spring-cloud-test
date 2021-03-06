package net.geozen.cloud.service2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.cloud.service2.service.TestService;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private TestService service;

	@RequestMapping(value = "/message")
	public String getMessage() {
		return service.getService1Msg();
	}
}
