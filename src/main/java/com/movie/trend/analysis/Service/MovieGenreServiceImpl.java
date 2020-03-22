package com.movie.trend.analysis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.trend.analysis.Dao.MovieGenreDao;
import com.movie.trend.analysis.Model.Movie;

@Service
public class MovieGenreServiceImpl implements MovieGenreService {
	@Autowired
	MovieGenreDao movieGenreDao;
	public List<Movie> getMovieCountWithGenre() {
		
			List<Movie> movieCount = movieGenreDao.getCountOfMoviesWithSpecificGenre();
			for (Movie m : movieCount) {
				System.out.println(m.toString());
			}
			
		return movieCount;
		
	}
	public List<Movie> getCountOfPreferredWriterGenre() {
		
		List<Movie> writerCount = movieGenreDao.getCountOfPreferredWriterGenre();
		for (Movie m : writerCount) {
			System.out.println(m.toString());
		}
		
	return writerCount;
	}
	public List<Movie> getCountOfPreferredActorGenre() {
		List<Movie> writerCount = movieGenreDao.getCountOfPreferredActorGenre();
		for (Movie m : writerCount) {
			System.out.println(m.toString());
		}
		
	return writerCount;
	}
	public List<Movie> getCountOfPreferredDirectorGenre() {
		List<Movie> writerCount = movieGenreDao.getCountOfPreferredDirectorGenre();
		for (Movie m : writerCount) {
			System.out.println(m.toString());
		}
		
	return writerCount;
	}

}
