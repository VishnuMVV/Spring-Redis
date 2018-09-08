package com.example.vishnu.springredisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.vishnu.springredisdemo.domain.Movie;

@SpringBootApplication
public class SpringRedisDemoApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Movie> redisTemplate() {
		RedisTemplate<String, Movie> redisTemplate = new RedisTemplate<String, Movie>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRedisDemoApplication.class, args);
	}
}
