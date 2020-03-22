package com.movie.trend.analysis.Dao;

import java.util.List;

import com.movie.trend.analysis.Model.Rating;

public interface GenreRatingDao {
	List<Rating> getAverageMovieRatingAccordingToGenre();
}
