package com.movie.trend.analysis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.movie.trend.analysis.Model.Genreyear;
import com.movie.trend.analysis.Service.GenreYearService;

@Controller
public class GenreYearController {
	@Autowired
	GenreYearService genreYearService;
	@RequestMapping("/printGenreYearChart")
	@ResponseBody
	public String movieGenreCount(){
		List<Genreyear> genreYearObj=genreYearService.getGenrewithyearCount();
		JsonArray jsonGenre = new JsonArray();
		JsonArray jsonPercentage1 = new JsonArray();
		JsonArray jsonPercentage2 = new JsonArray();
		JsonArray jsonPercentage3 = new JsonArray();
		JsonArray jsonPercentage4 = new JsonArray();
		JsonObject retObj = new JsonObject();

		Genreyear c = genreYearObj.get(0);
		jsonGenre.add(c.getGenre1());
		jsonGenre.add(c.getGenre2());
		jsonGenre.add(c.getGenre3());
		jsonGenre.add(c.getGenre4());

		for(Genreyear g1:genreYearObj){
			jsonPercentage1.add(g1.getPercentage1());
			jsonPercentage2.add(g1.getPercentage2());
			jsonPercentage3.add(g1.getPercentage3());
			jsonPercentage4.add(g1.getPercentage4());
		}
		retObj.add("genres", jsonGenre);
		retObj.add("percentage1", jsonPercentage1);
		retObj.add("percentage2", jsonPercentage2);
		retObj.add("percentage3", jsonPercentage3);
		retObj.add("percentage4", jsonPercentage4);
		return retObj.toString();
	}

}
