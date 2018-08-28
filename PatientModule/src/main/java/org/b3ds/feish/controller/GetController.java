package org.b3ds.feish.controller;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3ds.feish.mongo.Patient;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
	private final static Logger logger = LogManager.getLogger(GetController.class);

	@RequestMapping(value="/get/reports",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseEntity<?> addPatientFamilyHistory(@RequestBody(required=true) Map<String, String> json)
	{
		logger.debug("add family history invoked");
		ResponseEntity res = null;
		logger.debug(json);
		try {
			Patient pt = new Patient("Diagnostic", "reports");
			List<Document> list = pt.getReports(json);
			res = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (UnknownHostException e) {
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}		
		return res;
	}

}
