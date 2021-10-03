/**
 * 
 */
package com.oneocean.controllers.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneocean.controllers.IReportController;
import com.oneocean.model.Data;
import com.oneocean.model.Position;
import com.oneocean.model.Vessel;
import com.oneocean.to.JSONResponse;
import com.oneocean.to.Report;
import com.oneocean.utilities.CommonUtilities;

/**
 * @author Vikram Viswanathan
 * @date October 02, 2021
 *
 */
@Component
public class ReportControllerImpl implements IReportController {
	private static final Logger logger = LogManager.getLogger(ReportControllerImpl.class);
	
	/* (non-Javadoc)
	 * @see com.oneocean.controllers.IReportController#testAPI()
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
	
	/* (non-Javadoc)
	 * @see com.oneocean.controllers.IReportController#generateReport()
	 */
	@Override
	public JSONResponse generateReport() throws InvocationTargetException {
		// TODO Auto-generated method stub
		JSONResponse jsonResponse = new JSONResponse();
		
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<Data> typeReference = new TypeReference<Data>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/testdata.json");
		
		try {
			Data vessels = mapper.readValue(inputStream, typeReference);
			logger.debug("Vessels: " + vessels);
			
			HashMap<String, Object> reportMap = new HashMap<String, Object>();
			List<Report> listObject = new ArrayList<Report>();
			
			for(Vessel vessel : vessels.getVessels()) {
				logger.debug("Vessel: " + vessel);
				vessel.getPositions().sort(Comparator.comparing((Position p) -> p.getTimestamp()));
				
				double distance = CommonUtilities.calculateDistance(
						vessel.getPositions().get(0).getX(), 
						vessel.getPositions().get(0).getY(), 
						vessel.getPositions().get(vessel.getPositions().size() - 1).getX(),
						vessel.getPositions().get(vessel.getPositions().size() - 1).getY());
				
				double difference = CommonUtilities.caculateTravelTime(
						vessel.getPositions().get(0).getTimestamp(),
						vessel.getPositions().get(vessel.getPositions().size() - 1).getTimestamp()) / 3600;
						
				double speed = CommonUtilities.calculateSpeed(distance, difference);
				
				Report reportObject = new Report();
				reportObject.setName(vessel.getName());
				reportObject.setAverageSpeed(speed);
				reportObject.setTotalDistance(distance);
				
				listObject.add(reportObject);
				logger.debug("Vessel Name: " + vessel.getName() + " Distance: " + distance + 
						" Total Time: " + difference + " Speed: " + speed);
			}
			
			reportMap.put("report", listObject);
			
			jsonResponse.setStatusCode(HttpStatus.OK.value());
			jsonResponse.setStatusMessage(HttpStatus.OK.toString());
			jsonResponse.setData(reportMap);
		} catch(IOException e) {
			logger.error("Unable to read json file -> " + e.getMessage());
		}
		return jsonResponse;
	}
}