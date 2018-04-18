package net.geozen.cloud.service1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class Service1Config {
	@Value("${service1.message}")
	private String service1Msg;

	@Value("${common.name}")
	private String commonName;

	public String getService1Msg() {
		return service1Msg;
	}

	public void setService1Msg(String service1Msg) {
		this.service1Msg = service1Msg;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

}
