package com.example.vishnu.springredisdemo.repository;

import java.util.Map;

import com.example.vishnu.springredisdemo.domain.Movie;

public interface MovieRepo {
	
	public void save(Movie movie);
	
	public void update(Movie movie);
	
	public Map<String, Movie> findAll();
	
	public void delete(String id);
	
	public Movie getById(String id);
	
}