package com.poc.springandreact.models;

/**
 * @author Vishal Sharma
 *
 */
public class Price {

	private String Currency;
	
	private String Date;
	
	private int Time;
	
	private double Price;
	
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return Currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		Currency = currency;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		Date = date;
	}
	/**
	 * @return the time
	 */
	public int getTime() {
		return Time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		Time = time;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return Price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		Price = price;
	}	
}
