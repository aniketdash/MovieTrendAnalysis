package com.movie.trend.analysis.Controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.movie.trend.analysis.Model.CountryBudget;
import com.movie.trend.analysis.Service.CountryBudgetService;
@Controller
public class CountryBudgetController {
	@Autowired
	CountryBudgetService cbs;
	@RequestMapping("/countryprintbardrilldownchart")
	@ResponseBody

	public String productionBudgetCount(){
		List<CountryBudget> CountryBudgetList = cbs.getCountryBudgetCount();
		System.out.println("HHHA");
		JsonArray Countries = new JsonArray();
		JsonArray totalProfitArr = new JsonArray();
		JsonArray profitYearCountryArr = new JsonArray();
		JsonArray yearPercetageArr = new JsonArray();
		JsonObject retObj = new JsonObject();
		List<String> productionCompanyList = new ArrayList<String>();
		for(CountryBudget p: CountryBudgetList){
			String country = p.getCountry();
			BigDecimal totalProfit = p.getTotalProfit();
			BigDecimal year = p.getYear();
			BigDecimal percentage = p.getPercentage();
			JsonArray profitYearArr = new JsonArray();
			if(!productionCompanyList.contains(country)){
				if(profitYearCountryArr.size() > 0){
					yearPercetageArr.add(profitYearCountryArr);	
				}
				profitYearCountryArr = new JsonArray();
				productionCompanyList.add(country);
				Countries.add(country);
				totalProfitArr.add(totalProfit);
			}
			profitYearArr.add(year);
			profitYearArr.add(percentage);
			profitYearCountryArr.add(profitYearArr);
		}
		yearPercetageArr.add(profitYearCountryArr);
		retObj.add("productionCompaniesArr", Countries);
		retObj.add("totalProfitArr", totalProfitArr);
		retObj.add("profitGenreArr", yearPercetageArr);
		return retObj.toString();
	}
}
