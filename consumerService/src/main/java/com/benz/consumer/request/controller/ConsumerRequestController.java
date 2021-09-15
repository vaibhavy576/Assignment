package com.benz.consumer.request.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.benz.consumer.request.service.ConsumerRequestService;

@Component
@RestController
@RequestMapping("/api")
public class ConsumerRequestController {

	@Autowired
	ConsumerRequestService consumerRequestService;
	
	  @RequestMapping(value = "/file/{fileType}", method = RequestMethod.POST)
	    public ResponseEntity<String> volumeDispenseCardrunner
	    (@RequestBody String inputJson,@PathVariable(value = "fileType", required = true) final String fileType) throws JSONException {
		  try {
			  consumerRequestService.saveData(inputJson,fileType);
		        return new ResponseEntity<String>("Data Saved Successfully",HttpStatus.OK);
		  }
		 catch(Exception e) {
			 return new ResponseEntity<String>("Unale to Save data", HttpStatus.FORBIDDEN);
		 }
	    }

	
}
