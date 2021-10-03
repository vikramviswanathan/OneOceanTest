/**
 * 
 */
package com.oneocean.to;

/**
 * @author Vikram Viswanathan
 * @date October 03, 2021
 *
 */
public class Report {
	private String name;
	private double averageSpeed;
	private double totalDistance;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the averageSpeed
	 */
	public double getAverageSpeed() {
		return averageSpeed;
	}
	
	/**
	 * @param averageSpeed the averageSpeed to set
	 */
	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	
	/**
	 * @return the totalDistance
	 */
	public double getTotalDistance() {
		return totalDistance;
	}
	
	/**
	 * @param totalDistance the totalDistance to set
	 */
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}
}