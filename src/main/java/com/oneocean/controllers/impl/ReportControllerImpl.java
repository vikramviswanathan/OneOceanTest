/**
 * 
 */
package com.oneocean.controllers.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.oneocean.controllers.IReportController;
import com.oneocean.to.JSONResponse;

/**
 * @author Vikram Viswanathan
 * @date October 02, 2021
 *
 */
@Component
public class ReportControllerImpl implements IReportController {
	private static final Logger logger = LogManager.getLogger(ReportControllerImpl.class);
	
	/* (non-Javadoc)
	 * @see com.adviam.oneocean.controllers.IReportController#testAPI()
	 */	
	@Override
	public JSONResponse testAPI() throws InvocationTargetException {
		// TODO Auto-generated method stub
		JSONResponse jsonResponse = new JSONResponse();
		logger.debug("Returning from controller");
		
		jsonResponse.setStatusCode(HttpStatus.OK.value());
		jsonResponse.setStatusMessage(HttpStatus.OK.toString());
		return jsonResponse;
	}
}