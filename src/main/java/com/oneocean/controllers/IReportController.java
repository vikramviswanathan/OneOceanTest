/**
 * 
 */
package com.oneocean.controllers;

import java.lang.reflect.InvocationTargetException;

import com.oneocean.to.JSONResponse;

/**
 * @author Vikram Viswanathan
 * @date October 01, 2021
 *
 */
public interface IReportController {
	public JSONResponse testAPI() throws IllegalAccessException, InvocationTargetException;
	public JSONResponse generateReport() throws IllegalAccessException, InvocationTargetException;
}