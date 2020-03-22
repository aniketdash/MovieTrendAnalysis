package com.movie.trend.analysis.Model;

import java.math.BigDecimal;


public class Movie {
	BigDecimal count;
	String genre;
	String awards;
	String poster;
	String title;
	int year;
	String imdb_id;
	String imdb_rating;
	String imdb_votes;
	String roles;
	
	
	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public BigDecimal getCount() {
		return count;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getImdb_rating() {
		return imdb_rating;
	}
	public void setImdb_rating(String imdb_rating) {
		this.imdb_rating = imdb_rating;
	}
	public String getImdb_votes() {
		return imdb_votes;
	}
	public void setImdb_votes(String imdb_votes) {
		this.imdb_votes = imdb_votes;
	}
	@Override
	public String toString() {
		return "Movie [count=" + count + ", genre=" + genre + ", awards="
				+ awards + ", poster=" + poster + ", title=" + title
				+ ", year=" + year + ", imdb_id=" + imdb_id + ", imdb_rating="
				+ imdb_rating + ", imdb_votes=" + imdb_votes + "]";
	}
	
	
}
