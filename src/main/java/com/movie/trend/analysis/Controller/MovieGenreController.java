package com.movie.trend.analysis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.movie.trend.analysis.Model.Movie;
import com.movie.trend.analysis.Service.MovieGenreService;

@Controller
public class MovieGenreController {
	@Autowired
	MovieGenreService movieGenreService;
	
	@GetMapping("/movie")
	public String movieGenreCount(Model model){
		model.addAttribute("movie",new Movie());
		return "Opening_page";
	}
	@RequestMapping("/printLineChart")
	@ResponseBody
	public String movieGenreCount1(){
		List<Movie> movieGenre=movieGenreService.getCountOfPreferredWriterGenre();
		
		JsonArray jsonCount = new JsonArray();
		JsonArray jsonGenre = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		
		
		for(Movie m: movieGenre){
			jsonGenre.add(m.getGenre());
			jsonCount.add(m.getCount());
		};
		jsonObject.add("genre", jsonGenre);
		jsonObject.add("movieCount", jsonCount);
		return jsonObject.toString();
	}
	
	
	@RequestMapping("/printLineChartForActor")
	@ResponseBody
	public String movieGenreCount2(){
		List<Movie> movieGenre=movieGenreService.getCountOfPreferredActorGenre();
		JsonArray jsonCount = new JsonArray();
		JsonArray jsonGenre = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		
		
		for(Movie m: movieGenre){
			jsonGenre.add(m.getGenre());
			jsonCount.add(m.getCount());
		};
		jsonObject.add("genre", jsonGenre);
		jsonObject.add("movieCount", jsonCount);
		return jsonObject.toString();
	}
	
	
	@RequestMapping("/printLineChartForDirector")
	@ResponseBody
	public String movieGenreCount3(){
		List<Movie> movieGenre=movieGenreService.getCountOfPreferredDirectorGenre();
		
		JsonArray jsonCount = new JsonArray();
		JsonArray jsonGenre = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		
		
		for(Movie m: movieGenre){
			jsonGenre.add(m.getGenre());
			jsonCount.add(m.getCount());
		};
		jsonObject.add("genre", jsonGenre);
		jsonObject.add("movieCount", jsonCount);
		return jsonObject.toString();
	}
		
		@PostMapping("/movie")
		public String movieGenreCount2(@ModelAttribute Movie movie){
			System.out.println("Hoeche");
			String getRole=movie.getRoles();
			if(getRole.equals("Writer"))
				return "indexWriter";
			if(getRole.equals("Actor")){
				System.out.println("Dhuk Giya");
				return "indexActor";
			}
			if(getRole.equals("Director"))
				return "indexDirector";
			return "index";
		}
		
		@RequestMapping("/profitableCompanies")
		public String getProfitableCompanies(Model model){
			return "index";
		}
		
		@RequestMapping("/diversity")
		public String getPreferences(Model model){
			return "diversity";
		}
		

		@RequestMapping("/marketShare")
		public String getMarketShare(Model model){
			return "country_page";
		}
		
		
		@RequestMapping("/home")
		public String getHomePage(Model model){
			return "Opening_page";
		}
		@RequestMapping("/preference")
		public String getPreferencePage(Model model){
			return "preferences";
		}
		
		@RequestMapping("/trends")
		public String getGenreYear(Model model){
			return "genreYear";
		}
		
		@PostMapping("/preference")
		public String postPreferencePage(@ModelAttribute Movie movie){
			System.out.println("Hoeche");
			String getRole=movie.getRoles();
			if(getRole.equals("Writer"))
				return "indexWriter";
			if(getRole.equals("Actor")){
				System.out.println("Dhuk Giya");
				return "indexActor";
			}
			if(getRole.equals("Director"))
				return "indexDirector";
			return "index";
		}
}
