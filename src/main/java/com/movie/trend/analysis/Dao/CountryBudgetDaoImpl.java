package com.movie.trend.analysis.Dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.movie.trend.analysis.Model.CountryBudget;

@Repository
public class CountryBudgetDaoImpl extends JdbcDaoSupport implements CountryBudgetDao {

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public List<CountryBudget> getCountryBudgetCnt(){
		List<CountryBudget> result = new ArrayList<CountryBudget>();
		String sql = "select A.country as country ,A.profit_percentage as Market_Share,b.year as year,b.year_paercentage as Share_Percentage "+ 
				" from (select country ,  round((total_profit/profit)*100,2) as profit_percentage from "+
		                " (select country , sum(B.profit) as total_profit from mhrk.country_movie C join " +
						" (select b.imdb_id , (revenue-budget) as profit from mhrk.budget b join "+
		                " mhrk.movies m on m.imdb_id=b.imdb_id where  m.year between 1990 and 2017   order by 2 desc) B on c.imdb_id= b.imdb_id "+
						" group by country order by 2 desc fetch first 10 rows only) "+
		                " cross join "+
		               " (select sum((revenue-budget)) as profit from mhrk.budget b join "+
		                " mhrk.movies m on m.imdb_id=b.imdb_id where  m.year between 1990 and 2017)) A "+
						" join "+
						" (select CP.country,CP.year , round (((CP.year_profit)/TP.year_profit)*100,2) year_paercentage from "+ 
						" (select country,year , sum (movie_profit) as year_profit from "+
						" ( select C.country,M.imdb_id, M.year , B.profit as movie_profit from mhrk.movies M join "+
						" (select imdb_id , (revenue-budget) as profit from mhrk.budget) B on "+
						" m.imdb_id = b.imdb_id join mhrk.country_movie C on C.imdb_id=m.imdb_id "+ 
						 " where  m.year between 1990 and 2017 ) "+
						 " group by country,year order by year asc) CP "+
						 " join "+ 
						 " (select  year , sum (movie_profit) as year_profit from "+ 
						" ( select M.imdb_id, M.year , B.profit as movie_profit from mhrk.movies M join "+
						" (select imdb_id , (revenue-budget) as profit from mhrk.budget) B on "+ 
						" m.imdb_id = b.imdb_id join mhrk.country_movie C on C.imdb_id=m.imdb_id "+
						 " where  m.year between 1990 and 2017  ) "+ 
						 " group by year order by year asc) TP "+
						 " on CP.year=TP.year) B on A.country=B.country order by 2 desc,3 asc";

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		for(Map<String,Object> row:rows) {
			CountryBudget countryProduction=new CountryBudget();
			countryProduction.setCountry((String)row.get("country"));
			countryProduction.setTotalProfit((BigDecimal)row.get("Market_Share"));
			countryProduction.setYear((BigDecimal)row.get("year"));
			countryProduction.setPercentage((BigDecimal)row.get("Share_Percentage"));
			result.add(countryProduction);
		}
		return result;
	}
}
