package com.movie.trend.analysis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.movie.trend.analysis.Model.Country;
import com.movie.trend.analysis.Service.CountryLanguageService;

@Controller
public class CountryLanguageController {
	@Autowired
	CountryLanguageService countryLanguageService;
	@RequestMapping("/printLineChartforCountryLanguage")
	@ResponseBody
	public String movieGenreCount(){
		List<Country> countryLang=countryLanguageService.getCountrieswithLanguageCount();
		
		JsonArray jsonCountry = new JsonArray();
		JsonArray jsonNoofLang80s = new JsonArray();
		JsonArray jsonNoofLang90s = new JsonArray();
		JsonArray jsonNoofLang2000s = new JsonArray();
		JsonObject retObj = new JsonObject();
		
		
		for(Country c: countryLang){
			jsonCountry.add(c.getCountryName());
			jsonNoofLang80s.add(c.getNoofLang80());
			jsonNoofLang90s.add(c.getNoofLang90());
			jsonNoofLang2000s.add(c.getNoofLan2000());
		}
		retObj.add("country", jsonCountry);
		retObj.add("nooflang80s", jsonNoofLang80s);
		retObj.add("nooflang90s", jsonNoofLang90s);
		retObj.add("nooflang2000s", jsonNoofLang2000s);
		return retObj.toString();
	}
	
}
