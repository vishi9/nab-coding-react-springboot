/**
 * 
 */
package com.poc.springandreact.models;

/**
 * @author Vishal Sharma
 *
 */
public class CurrencyDiff {
	
	private String currency;
	private double profit;
	private int minIndex;
	private int minTs;
	private int maxIndex;
	private int maxTs;
	/**
	 * @return the minIndex
	 */
	public int getMinIndex() {
		return minIndex;
	}
	/**
	 * @param minIndex the minIndex to set
	 */
	public void setMinIndex(int minIndex) {
		this.minIndex = minIndex;
	}
	/**
	 * @return the maxIndex
	 */
	public int getMaxIndex() {
		return maxIndex;
	}
	/**
	 * @param maxIndex the maxIndex to set
	 */
	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}
	/**
	 * @return the profit
	 */
	public double getProfit() {
		return profit;
	}
	/**
	 * @param profit the profit to set
	 */
	public void setProfit(double profit) {
		this.profit = profit;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the minTs
	 */
	public int getMinTs() {
		return minTs;
	}
	/**
	 * @param minTs the minTs to set
	 */
	public void setMinTs(int minTs) {
		this.minTs = minTs;
	}
	/**
	 * @return the maxTs
	 */
	public int getMaxTs() {
		return maxTs;
	}
	/**
	 * @param maxTs the maxTs to set
	 */
	public void setMaxTs(int maxTs) {
		this.maxTs = maxTs;
	}

}
