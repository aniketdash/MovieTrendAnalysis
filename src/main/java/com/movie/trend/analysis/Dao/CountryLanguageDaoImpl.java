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

import com.movie.trend.analysis.Model.Country;

@Repository
public class CountryLanguageDaoImpl extends JdbcDaoSupport implements CountryLanguageDao {

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public List<Country> getCountryLanguageCnt(){
		List<Country> result = new ArrayList<Country>();
		String sql = "SELECT T1.COUNTRY AS Countries, NOLANG80S, NOLANG90S, NOLANG2000S FROM "+ 
				"(SELECT COUNTRY, COUNT(LANGUAGE) AS NOLANG80S FROM "+
				"(SELECT DISTINCT COUNTRY, LANGUAGE FROM mhrk.COUNTRY_MOVIE C INNER JOIN mhrk.LANGUAGE_MOVIE L ON C.IMDB_ID = L.IMDB_ID INNER JOIN mhrk.MOVIES M ON C.IMDB_ID"+
				"= M.IMDB_ID where M.YEAR >= 1980 and M.year <= 1990) "+
				"GROUP BY COUNTRY ORDER BY NOLANG80S DESC) T1 inner join "+ 
				"(SELECT COUNTRY, COUNT(LANGUAGE) AS NOLANG90S FROM "+ 
				"(SELECT DISTINCT COUNTRY, LANGUAGE FROM mhrk.COUNTRY_MOVIE C INNER JOIN mhrk.LANGUAGE_MOVIE L ON C.IMDB_ID = L.IMDB_ID INNER JOIN mhrk.MOVIES M ON C.IMDB_ID"+
				"= M.IMDB_ID where M.YEAR >= 1990 and M.year <= 2000) "+
				"GROUP BY COUNTRY ORDER BY NOLANG90S DESC) T2 on T1.COUNTRY = T2.COUNTRY INNER JOIN"+
				"(SELECT COUNTRY, COUNT(LANGUAGE) AS NOLANG2000S FROM "+ 
				"(SELECT DISTINCT COUNTRY, LANGUAGE FROM mhrk.COUNTRY_MOVIE C INNER JOIN mhrk.LANGUAGE_MOVIE L ON C.IMDB_ID = L.IMDB_ID INNER JOIN mhrk.MOVIES M ON C.IMDB_ID"+
				"= M.IMDB_ID where M.YEAR >= 2000 and M.year <= 2017) "+
				"GROUP BY COUNTRY ORDER BY NOLANG2000S DESC) T3 ON T2.COUNTRY = T3.COUNTRY order by NOLANG80S+NOLANG90S+NOLANG2000S desc FETCH FIRST 5 ROWS ONLY";

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		for(Map<String,Object> row:rows) {
			Country country=new Country();
			country.setCountry(row.get("Countries").toString());
			country.setNoofLang80((BigDecimal)row.get("NOLANG80S"));
			country.setNoofLang90((BigDecimal)row.get("NOLANG90S"));
			country.setNoofLan2000((BigDecimal)row.get("NOLANG2000S"));
			result.add(country);
		}
		return result;
	}
}
