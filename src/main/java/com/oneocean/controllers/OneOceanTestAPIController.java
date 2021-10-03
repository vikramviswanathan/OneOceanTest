/**
 * 
 */
package com.oneocean.controllers;

import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneocean.to.JSONResponse;

/**
 * @author Vikram Viswanathan
 * @date October 01, 2021
 *
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/oneoceantest/api")
public class OneOceanTestAPIController {
	private static final Logger logger = LogManager.getLogger(OneOceanTestAPIController.class);
	
	@Autowired
	private IReportController reportController;

	/**
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */	
	@GetMapping(value = "/testAPI", produces = "application/json")
	public JSONResponse testAPI() throws IllegalAccessException, InvocationTargetException {
		logger.info("Hit received by controller for testAPI");
		return reportController.testAPI();
	}
	
	/**
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@GetMapping(value = "/generateReport", produces = "application/json")
	public JSONResponse generateReport() throws IllegalAccessException, InvocationTargetException {
		logger.info("Hit received by controller for generateReport");
		return reportController.generateReport();
	}
}