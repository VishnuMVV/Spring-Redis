package com.example.vishnu.springredisdemo.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.vishnu.springredisdemo.domain.Movie;

@Repository
public class MovieRepoImpl implements MovieRepo{

	private RedisTemplate<String, Movie> redisTemplate;
	
	private HashOperations hashOperations;
	
	public MovieRepoImpl(RedisTemplate<String, Movie> redisTemplate) {
//		super();
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public void save(Movie movie) {
		hashOperations.put("MOVIE", movie.getMovieId(), movie);
	}

	@Override
	public void update(Movie movie) {
		save(movie);
	}

	@Override
	public Map<String, Movie> findAll() {
		return hashOperations.entries("MOVIE");
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("MOVIE", id);
	}

	@Override
	public Movie getById(String id) {
		return (Movie) hashOperations.get("MOVIE",id);
	}

}
