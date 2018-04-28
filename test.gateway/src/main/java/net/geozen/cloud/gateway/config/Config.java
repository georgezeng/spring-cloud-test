package net.geozen.cloud.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class Config {
	@Autowired
	private RefreshedConfig config;

	@Bean
	public LettuceConnectionFactory connectionFactory() {
		LettuceConnectionFactory factory = new LettuceConnectionFactory();
		factory.setHostName(config.getRedisHost());
		return factory;
	}

	// @Bean
	// public HeaderHttpSessionStrategy sessionStrategy() {
	// return new HeaderHttpSessionStrategy();
	// }
}