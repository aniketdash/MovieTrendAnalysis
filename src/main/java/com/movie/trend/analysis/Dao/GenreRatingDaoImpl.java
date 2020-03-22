package com.movie.trend.analysis.Dao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.movie.trend.analysis.Model.Movie;
import com.movie.trend.analysis.Model.Rating;

@Repository
public class GenreRatingDaoImpl extends JdbcDaoSupport implements GenreRatingDao {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public List<Rating> getAverageMovieRatingAccordingToGenre(){
		String sql= "select G.genre as genre, round(avg(R.avg_rating),5)as avg_genre_rating from  (select avg(cast(m_rating as decimal(10,2))) as avg_rating , imdb_id from(select imdb_id , substr(rating,0,3) as m_rating from rating where rating_source='Internet Movie Database')group by imdb_id) R join genres G on G.imdb_id=R.imdb_id group by G.genre";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Rating> result = new ArrayList<Rating>();
		
		for(Map<String,Object> row:rows) {
			Rating rating=new Rating();
			rating.setAvg_genre_rating((BigDecimal)row.get("setAvg_genre_rating"));
			rating.setGenre((String)row.get("genre"));
			result.add(rating);
		}
		return result;
	}
	
}
