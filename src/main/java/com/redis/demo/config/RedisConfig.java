package com.redis.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private String port;
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration configuration= new RedisStandaloneConfiguration();
		configuration.setHostName("127.0.0.1");
		configuration.setPort(6379);
		
		JedisConnectionFactory connectionFactory= new JedisConnectionFactory(configuration);
		return connectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> redisTemplate= new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
		
	}
}
