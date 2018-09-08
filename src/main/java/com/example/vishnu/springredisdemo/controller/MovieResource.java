package com.example.vishnu.springredisdemo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vishnu.springredisdemo.domain.Movie;
import com.example.vishnu.springredisdemo.repository.MovieRepo;

@RestController
@RequestMapping("/redis/movie")
public class MovieResource {
	private MovieRepo movieRepo;

	public MovieResource(MovieRepo movieRepo) {
//		super();
		this.movieRepo = movieRepo;
	}
	
	@GetMapping("/add/{id}/{name}")
	public Movie add(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		movieRepo.save(new Movie(id, name, 20000L));
		return movieRepo.getById(id);
	}
	
	@GetMapping("/update/{id}/{name}")
	public Movie update(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		movieRepo.update(new Movie(id, name, 10000L));
		return movieRepo.getById(id);
	}
	@GetMapping("/delete/{id}")
	public Map<String, Movie> delete(@PathVariable("id") final String id) {
		movieRepo.delete(id);
		return getAll();
	}
	@GetMapping("/")
	public Map<String, Movie> getAll() {
		return movieRepo.findAll();
	}
	
}
