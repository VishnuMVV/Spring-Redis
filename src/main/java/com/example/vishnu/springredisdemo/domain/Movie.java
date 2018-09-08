package com.example.vishnu.springredisdemo.domain;

import java.io.Serializable;

public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String movieId;
	private String movieName;
	private Long movieBudget;
	
	public Movie(String movieId, String movieName, Long movieBudget) {
//		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieBudget = movieBudget;
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Long getMovieBudget() {
		return movieBudget;
	}
	public void setMovieBudget(Long movieBudget) {
		this.movieBudget = movieBudget;
	}
	
}
