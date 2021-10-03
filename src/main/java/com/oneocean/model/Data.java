/**
 * 
 */
package com.oneocean.model;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Vikram Viswanathan
 * @date October 03, 2021
 *
 */
public class Data {
	private List<Vessel> vessels;

	/**
	 * @return the vessels
	 */
	public List<Vessel> getVessels() {
		return vessels;
	}

	/**
	 * @param vessels the vessels to set
	 */
	public void setVessels(List<Vessel> vessels) {
		this.vessels = vessels;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(this);
	}
}
