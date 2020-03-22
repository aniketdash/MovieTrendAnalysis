package com.movie.trend.analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.movie.trend.analysis.Service.MovieGenreService;

@SpringBootApplication
public class SpringBootApp {
	@Autowired
	public MovieGenreService movieGenreService;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootApp.class, args);
		MovieGenreService movieGenreService = context.getBean(MovieGenreService.class);
		movieGenreService.getMovieCountWithGenre();
	}

}
