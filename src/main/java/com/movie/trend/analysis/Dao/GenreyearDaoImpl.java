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

import com.movie.trend.analysis.Model.Genreyear;

@Repository
public class GenreyearDaoImpl extends JdbcDaoSupport implements GenreyearDao {

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public List<Genreyear> getGenreyearCnt(){
		List<Genreyear> result = new ArrayList<Genreyear>();
		String sql = "Select A.genre as genre_1,S.genre as genre_2,R.genre as genre_3,D.genre as genre_4,A.year,"+
				" round(((A.a_count/B.main_count)*100),2) as percentage_1,"+
				" round(((S.a_count/B.main_count)*100),2) as percentage_2,"+
				" round(((R.a_count/B.main_count)*100),2) as percentage_3,"+
				" round(((D.a_count/B.main_count)*100),2) as percentage_4 from "+
				" (select count(m2.imdb_id) as a_count , g2.genre, m2.year "+
				" from mhrk.movies m2, mhrk.genres g2"+
				" where m2.imdb_id = g2.imdb_id and g2.genre = 'Action'"+
				" AND m2.year between 1990 and 2017"+
				" group by g2.genre, m2.year order by m2.year asc) A"+
				" join"+
				" (select count(m2.imdb_id) as main_count, m2.year"+
				" from mhrk.movies m2, mhrk.genres g2"+
				" where m2.imdb_id = g2.imdb_id and"+
				" m2.year between 1990 and 2017 "+
				" group  by m2.year order by m2.year asc) B"+ 
				" on A.year = B.year join (select count(m2.imdb_id) as a_count , g2.genre, m2.year"+
				" from mhrk.movies m2, mhrk.genres g2"+
				" where m2.imdb_id = g2.imdb_id and g2.genre = 'Short'"+
				" AND m2.year between 1990 and 2017"+
				" group by g2.genre, m2.year order by m2.year asc) S"+ 
				" on B.year=S.year join"+ 
				" (select count(m2.imdb_id) as a_count , g2.genre, m2.year"+
				" from mhrk.movies m2, mhrk.genres g2"+
				" where m2.imdb_id = g2.imdb_id and g2.genre = 'Romance'"+
				" AND m2.year between 1990 and 2017"+
				" group by g2.genre, m2.year order by m2.year asc) R"
				+" on B.year=R.year join"+ "(select count(m2.imdb_id) as a_count , g2.genre, m2.year"+
				" from mhrk.movies m2, mhrk.genres g2"+
				" where m2.imdb_id = g2.imdb_id and g2.genre = 'Drama'"+
				" AND m2.year between 1990 and 2017"+
				" group by g2.genre, m2.year order by m2.year asc) D"+
				" on D.year=B.year";

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		for(Map<String,Object> row:rows) {
			Genreyear genreYear=new Genreyear();
			genreYear.setGenre1(row.get("genre_1").toString());
			genreYear.setGenre2(row.get("genre_2").toString());
			genreYear.setGenre3(row.get("genre_3").toString());
			genreYear.setGenre1(row.get("genre_4").toString());
			genreYear.setYear((BigDecimal)row.get("year"));
			genreYear.setPercentage1((BigDecimal)row.get("percentage_1"));
			genreYear.setPercentage2((BigDecimal)row.get("percentage_2"));
			genreYear.setPercentage3((BigDecimal)row.get("percentage_3"));
			genreYear.setPercentage4((BigDecimal)row.get("percentage_4"));
			result.add(genreYear);
		}
		return result;
	}
}
