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
public class Vessel {
	private String name;
	private List<Position> positions;
	
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
	 * @return the positions
	 */
	public List<Position> getPositions() {
		return positions;
	}
	
	/**
	 * @param positions the positions to set
	 */
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(this);
	}
}