package com.movie.trend.analysis.Model;

import java.math.BigDecimal;

public class Rating {
 int rating_id;
 String genre;
 String rating;
 String rating_source;
 String imdb_id;
 BigDecimal avg_rating;
 BigDecimal avg_genre_rating;
 public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
String m_rating;
public int getRating_id() {
	return rating_id;
}
public void setRating_id(int rating_id) {
	this.rating_id = rating_id;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public String getRating_source() {
	return rating_source;
}
public void setRating_source(String rating_source) {
	this.rating_source = rating_source;
}
public String getImdb_id() {
	return imdb_id;
}
public void setImdb_id(String imdb_id) {
	this.imdb_id = imdb_id;
}
public BigDecimal getAvg_rating() {
	return avg_rating;
}
public void setAvg_rating(BigDecimal avg_rating) {
	this.avg_rating = avg_rating;
}
public BigDecimal getAvg_genre_rating() {
	return avg_genre_rating;
}
public void setAvg_genre_rating(BigDecimal avg_genre_rating) {
	this.avg_genre_rating = avg_genre_rating;
}
public String getM_rating() {
	return m_rating;
}
public void setM_rating(String m_rating) {
	this.m_rating = m_rating;
}
@Override
public String toString() {
	return "Rating [rating_id=" + rating_id + ", rating=" + rating + ", rating_source=" + rating_source + ", imdb_id="
			+ imdb_id + ", avg_rating=" + avg_rating + ", avg_genre_rating=" + avg_genre_rating + ", m_rating="
			+ m_rating + "]";
}
}
