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

import com.movie.trend.analysis.Model.ProductionBudget;

@Repository
public class ProductionBudgetDaoImpl extends JdbcDaoSupport implements ProductionBudgetDao{

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public List<ProductionBudget> getProductionBudgetCnt(){
		List<ProductionBudget> result = new ArrayList<ProductionBudget>();
		String sql = "Select t1.production_company, t1.genre, total_profit, ROUND((profit_genre / total_profit)*100,2) as profitgenre_percentage "+
				"from "+
				"(select production_company,genre,sum(revenue - budget) as profit_genre from mhrk.budget b inner join mhrk.genres g on g.imdb_id = b.imdb_id "+
				"inner join mhrk.production_movies p on g.imdb_id = p.imdb_id group by production_company,genre order by profit_genre desc) T1"+
				" inner join "+
				"(select sum(profit) as total_profit,production_company from "+
				"(select b.imdb_id, b.budget, b.revenue, p.production_company, revenue-budget as profit "
				+ "from mhrk.budget b inner join mhrk.production_movies p on p.imdb_id = b.imdb_id)"+
				" group by production_company order by total_profit Desc fetch first 5 rows only) T2 "
				+ "on t1.production_company = t2.production_company order by total_profit desc, "+
				"profitgenre_percentage desc";

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		for(Map<String,Object> row:rows) {
			ProductionBudget production=new ProductionBudget();
            production.setProductionCompany((String)row.get("production_company"));
            production.setGenre((String)row.get("genre"));
            production.setTotalProfit((BigDecimal)row.get("total_profit"));
            production.setProfitGenre((BigDecimal)row.get("profitgenre_percentage"));
			result.add(production);
		}
		return result;
	}
}
