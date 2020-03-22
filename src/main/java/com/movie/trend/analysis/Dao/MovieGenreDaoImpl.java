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

@Repository
public class MovieGenreDaoImpl extends JdbcDaoSupport implements MovieGenreDao {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public List<Movie> getCountOfMoviesWithSpecificGenre() {
		
		
			String sql = "select count(distinct e.imdb_id) movie_count,"
					+ "g.genre genre from mhrk.movies e,mhrk.genres g where "
					+ "e.imdb_id=g.imdb_id group by genre";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			
			List<Movie> result = new ArrayList<Movie>();
			
			for(Map<String, Object> row:rows){
				Movie movie= new Movie();
				movie.setCount((BigDecimal)row.get("movie_count"));
				movie.setGenre((String)row.get("genre"));
				result.add(movie);
			}
			
			
		return result;
		
	}

	public List<Movie> getCountOfPreferredWriterGenre() {
		String sql ="select genre ,count(id) count from  "
				+ "(select genre,g.imdb_id as id from MHRK.genres G join"
				+ "(select distinct imdb_id from mhrk.role where person in"
				+ "(select person from(select count(distinct imdb_id),person from "
				+ "(select * from mhrk.role where responsibility='screenplay')"
				+ "group by person order by 1 desc,2 asc)where ROWNUM<=10)) "
				+ "F on g.imdb_id=f.imdb_id) group by genre order by 2 desc";
		
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Movie> result = new ArrayList<Movie>();
		
		for(Map<String, Object> row:rows){
			Movie movie= new Movie();
			movie.setCount((BigDecimal)row.get("count"));
			movie.setGenre((String)row.get("genre"));
			result.add(movie);
		}
		
		
	return result;
	}

	public List<Movie> getCountOfPreferredActorGenre() {
		String sql ="select genre ,count(id) count "
				+ "from (select genre,g.imdb_id as id from MHRK.genres G "
				+ "join(select distinct imdb_id  from mhrk.actors where actors in  "
				+ "(select actors from(select count(distinct imdb_id) , actors "
				+ "from mhrk.actors group by actors order by 1 desc)where ROWNUM<=10)) "
				+ "F on g.imdb_id=f.imdb_id)group by genre order by 2 desc";
		
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Movie> result = new ArrayList<Movie>();
		
		for(Map<String, Object> row:rows){
			Movie movie= new Movie();
			movie.setCount((BigDecimal)row.get("count"));
			movie.setGenre((String)row.get("genre"));
			result.add(movie);
		}
		
		
	return result;
	}

	public List<Movie> getCountOfPreferredDirectorGenre() {
		String sql ="select genre , count(id) count from "
				+ "(select genre,g.imdb_id as id from MHRK.genres G "
				+ "join(select distinct imdb_id from mhrk.directors where director in "
				+ "(select director from(select count(distinct imdb_id) , director "
				+ "from mhrk.directors group by director order by 1 desc) where ROWNUM<=10)) "
				+ "F on g.imdb_id=f.imdb_id)group by genre order by 2 desc";
		
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Movie> result = new ArrayList<Movie>();
		
		for(Map<String, Object> row:rows){
			Movie movie= new Movie();
			movie.setCount((BigDecimal)row.get("count"));
			movie.setGenre((String)row.get("genre"));
			result.add(movie);
		}
		
		
	return result;
	}
	 
}
