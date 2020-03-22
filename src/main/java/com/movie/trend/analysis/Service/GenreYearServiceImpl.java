package com.movie.trend.analysis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.trend.analysis.Dao.GenreyearDao;
import com.movie.trend.analysis.Model.Genreyear;
@Service
public class GenreYearServiceImpl implements GenreYearService{
	@Autowired
	GenreyearDao gyDao;
	public List<Genreyear> getGenrewithyearCount(){
		List<Genreyear> genreYearCount  = gyDao.getGenreyearCnt();
		return genreYearCount;
	}
}
