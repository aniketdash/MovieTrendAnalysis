package com.movie.trend.analysis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.trend.analysis.Model.ProductionBudget;
import com.movie.trend.analysis.Dao.ProductionBudgetDao;;

@Service
public class ProductionBudgetServiceImpl implements ProductionBudgetService{
	@Autowired

	ProductionBudgetDao pdbDao;
	public List<ProductionBudget> getProductionBudgetCount(){
		List<ProductionBudget> pdbudgetList = pdbDao.getProductionBudgetCnt();
		return pdbudgetList;
	}
}
