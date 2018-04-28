package net.geozen.cloud.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class RefreshedConfig {
	@Value("${spring.redis.host}")
	private String redisHost;

	public String getRedisHost() {
		return redisHost;
	}

	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

}
