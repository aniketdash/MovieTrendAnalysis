package com.movie.trend.analysis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.trend.analysis.Dao.CountryBudgetDao;
import com.movie.trend.analysis.Model.CountryBudget;

@Service
public class CountryBudgetServiceImpl implements CountryBudgetService {
	@Autowired
	
	CountryBudgetDao CbDao;
	public List<CountryBudget> getCountryBudgetCount(){
		List<CountryBudget> ctBudgetLst = CbDao.getCountryBudgetCnt();
		for (CountryBudget m : ctBudgetLst) {
		System.out.println(m.toString());
	}
		return ctBudgetLst;
	}
}
