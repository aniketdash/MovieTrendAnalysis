package com.movie.trend.analysis.Service;

import java.util.List;

import com.movie.trend.analysis.Model.Movie;

public interface MovieGenreService {
	public List<Movie> getMovieCountWithGenre();
	public List<Movie> getCountOfPreferredWriterGenre();
	public List<Movie> getCountOfPreferredActorGenre();
	public List<Movie> getCountOfPreferredDirectorGenre();
}
