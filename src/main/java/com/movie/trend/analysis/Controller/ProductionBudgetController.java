package com.movie.trend.analysis.Controller;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.movie.trend.analysis.Model.ProductionBudget;
import com.movie.trend.analysis.Service.ProductionBudgetService;

@Controller
public class ProductionBudgetController {
	@Autowired
	ProductionBudgetService pdbs;
	@RequestMapping("/printbardrilldownchart")
	@ResponseBody

	public String productionBudgetCount(){
		List<ProductionBudget> productionBudgetList = pdbs.getProductionBudgetCount();
	
		JsonArray productionCompanies = new JsonArray();
		JsonArray totalProfitArr = new JsonArray();
		JsonArray profitGenrePCompanyArr = new JsonArray();
		JsonArray fullProfitGenreArr = new JsonArray();
		JsonObject retObj = new JsonObject();
		List<String> productionCompanyList = new ArrayList<String>();
		for(ProductionBudget p: productionBudgetList){
			String productionCompany = p.getProductionCompany();
			BigDecimal totalProfit = p.getTotalProfit();
			String genre = p.getGenre();
			BigDecimal profitGenre = p.getProfitGenre();
			JsonArray profitGenreArr = new JsonArray();
			if(!productionCompanyList.contains(productionCompany)){
				if(profitGenrePCompanyArr.size() > 0){
					fullProfitGenreArr.add(profitGenrePCompanyArr);	
				}
				profitGenrePCompanyArr = new JsonArray();
				productionCompanyList.add(productionCompany);
				productionCompanies.add(productionCompany);
				totalProfitArr.add(totalProfit);
			}
			profitGenreArr.add(genre);
			profitGenreArr.add(profitGenre);
			profitGenrePCompanyArr.add(profitGenreArr);
		}
		fullProfitGenreArr.add(profitGenrePCompanyArr);
		retObj.add("productionCompaniesArr", productionCompanies);
		retObj.add("totalProfitArr", totalProfitArr);
		retObj.add("profitGenreArr", fullProfitGenreArr);
		return retObj.toString();
	}
}
