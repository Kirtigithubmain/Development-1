package org.b3ds.feish.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private final Logger logger = LogManager.getLogger(Controller.class);
		

	@RequestMapping(value="/doc",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllPatients()
	{
		Map<String, String> response = new HashMap<>();
		response.put("/add/newpatient", "Add new patient (Post)");
		response.put("/add/familyhistory", "family history (Post)");
		response.put("/add/labresult", "Add labresult (Post)");
		response.put("/add/treatment", "Add treatment (Post)");
		response.put("/add/medicalhistory", "add medical(Post)");
		response.put("/add/vitalsign", "Add vital (Post)");
		response.put("/update/newpatient", "update patient (Post)");
		response.put("/get/reports", "get specific patient's report (post). Consumes {user_id:value}");
		ResponseEntity res = new ResponseEntity<>(response, HttpStatus.OK);
		return res;
	}
		
}
