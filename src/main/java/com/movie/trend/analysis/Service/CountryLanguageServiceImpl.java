package com.movie.trend.analysis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.trend.analysis.Model.Country;
import com.movie.trend.analysis.Dao.CountryLanguageDao;


@Service
public class CountryLanguageServiceImpl implements CountryLanguageService{
	@Autowired
	
	CountryLanguageDao cldao;
	public List<Country> getCountrieswithLanguageCount(){
		
		List<Country> countryLangCnt = cldao.getCountryLanguageCnt();
		return countryLangCnt;

	}
}
