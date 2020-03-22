package com.movie.trend.analysis.Model;
import java.math.BigDecimal;

public class Country {
	String countryName;
	BigDecimal noofLang80;
	BigDecimal noofLang90;
	BigDecimal noofLan2000;
	public String getCountryName() {
		return countryName;
	}
	public void setCountry(String country) {
		countryName = country;
	}
	public BigDecimal getNoofLang80() {
		return noofLang80;
	}
	public void setNoofLang80(BigDecimal noofLang80) {
		this.noofLang80 = noofLang80;
	}
	public BigDecimal getNoofLang90() {
		return noofLang90;
	}
	public void setNoofLang90(BigDecimal noofLang90) {
		this.noofLang90 = noofLang90;
	}
	public BigDecimal getNoofLan2000() {
		return noofLan2000;
	}
	public void setNoofLan2000(BigDecimal noofLan2000) {
		this.noofLan2000 = noofLan2000;
	}
	
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", noofLang80=" + noofLang80 + ", noofLang90="
				+ noofLang90 + ", noofLan2000=" + noofLan2000  + "]";
	}

}
