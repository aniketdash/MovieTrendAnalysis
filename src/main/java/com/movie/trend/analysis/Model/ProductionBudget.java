package com.movie.trend.analysis.Model;

import java.math.BigDecimal;
public class ProductionBudget {
String productionCompany,genre;
BigDecimal totalProfit;
BigDecimal profitGenre;

public String getProductionCompany() {
	return productionCompany;
}
public void setProductionCompany(String productionCompany) {
	this.productionCompany = productionCompany;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public BigDecimal getTotalProfit() {
	return totalProfit;
}
public void setTotalProfit(BigDecimal totalProfit) {
	this.totalProfit = totalProfit;
}
public BigDecimal getProfitGenre() {
	return profitGenre;
}
public void setProfitGenre(BigDecimal profitGenre) {
	this.profitGenre = profitGenre;
}

@Override
public String toString() {
	return "ProductionBudget [productionCompany=" + productionCompany + ", genre=" + genre + ", totalProfit="
			+ totalProfit + ", profitGenre=" + profitGenre  + "]";
}

}
