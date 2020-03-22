package com.movie.trend.analysis.Model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CountryBudget {
String Country;
BigDecimal year;
BigDecimal totalProfit;
BigDecimal percentage;
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
public BigDecimal getYear() {
	return year;
}
public void setYear(BigDecimal year) {
	this.year = year;
}
public BigDecimal getTotalProfit() {
	return totalProfit;
}
public void setTotalProfit(BigDecimal totalProfit) {
	this.totalProfit = totalProfit;
}
public BigDecimal getPercentage() {
	return percentage;
}
public void setPercentage(BigDecimal percentage) {
	this.percentage = percentage;
}
@Override
public String toString() {
	return "CountryBudget [Country=" + Country + ", year=" + year + ", totalProfit=" + totalProfit + ", percentage="
			+ percentage + "]";
}

}
