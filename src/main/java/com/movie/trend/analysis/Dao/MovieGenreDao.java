package com.movie.trend.analysis.Dao;

import java.util.List;

import com.movie.trend.analysis.Model.Movie;

public interface MovieGenreDao {
	List<Movie> getCountOfMoviesWithSpecificGenre();
	List<Movie> getCountOfPreferredWriterGenre();
	
	List<Movie> getCountOfPreferredActorGenre();
	List<Movie> getCountOfPreferredDirectorGenre();
	
}
