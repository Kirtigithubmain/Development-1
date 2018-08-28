package org.b3ds.feish.controller;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3ds.feish.mongo.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	private final static Logger logger = LogManager.getLogger(PostController.class);
	
	private Patient patient = null;
	
	@RequestMapping(value="/add/newpatient",method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> addNewPatient(@RequestBody(required=true) Map<String, String> json)
	{
		logger.debug("add new patient invoked");
		ResponseEntity res = null;
		logger.debug(json);
		try {
			patient = new Patient("Patient");
			patient.addNewPatient(json);
			res = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (UnknownHostException e) {
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}		
		return res;
	}
	
	@RequestMapping(value="/update/newpatient",method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> updatePatient(@RequestBody(required=true) Map<String, String> json)
	{
		logger.debug("add new patient invoked");
		ResponseEntity res = null;
		logger.debug(json);
		try {
			patient = new Patient("Patient");
			String user_id = json.get("user_id");
			json.remove("user_id");			
			patient.updatePatient(json, user_id);
			res = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (UnknownHostException e) {
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}		
		return res;
	}

	@RequestMapping(value="/add/familyhistory",method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> addPatientFamilyHistory(@RequestBody(required=true) Map<String, String> json)
	{
		logger.debug("add family history invoked");
		ResponseEntity res = null;
		logger.debug(json);
		try {
			String user_id = json.get("user_id");
			json.remove("user_id");
			logger.debug(json);
			patient = new Patient("Patient");
			patient.addFamilyHistory(json, user_id);
			res = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (UnknownHostException e) {
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}		
		return res;
	}

	@RequestMapping(value="/add/labresult",method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> addLabResult(@RequestBody(required=true) Map<String, String> json)
	{
		logger.debug("add labresult invoked");
		ResponseEntity res = null;
		logger.debug(json);
		try {
			String user_id = json.get("user_id");
			json.remove("user_id");
			logger.debug(json);
			patient = new Patient("LabResult");
			patient.addLabReport(json);
			res = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (UnknownHostException e) {
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}		
		return res;
	}
	
	@RequestMapping(value="/add/treatment",method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> addTreatment(@RequestBody(required=true) Map<String, String> json)
	{
		logger.debug("add treatment invoked");
		ResponseEntity res = null;
		logger.debug(json);
		try {
			String user_id = json.get("user_id");
			json.remove("user_id");
			logger.debug(json);
			patient = new Patient("Patient");
			patient.addTreatment(json, user_id);
			res = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (UnknownHostException e) {
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}		
		return res;
	}

	@RequestMapping(value="/add/medicalhistory",method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> addMedicalHistory(@RequestBody(required=true) Map<String, String> json)
	{
		logger.debug("add medical history invoked");
		ResponseEntity res = null;
		logger.debug(json);
		try {
			String user_id = json.get("user_id");
			json.remove("user_id");
			logger.debug(json);
			patient = new Patient("Patient");
			patient.addMedicalHistory(json, user_id);
			res = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (UnknownHostException e) {
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}		
		return res;
	}
	
	@RequestMapping(value="/add/vitalsign",method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> addVitalSign(@RequestBody(required=true) Map<String, String> json)
	{
		logger.debug("add vital sign invoked");
		ResponseEntity res = null;
		logger.debug(json);
		try {
			String user_id = json.get("user_id");
			json.remove("user_id");
			logger.debug(json);
			patient = new Patient("Patient");
			patient.addVitalSign(json, user_id);
			res = new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (UnknownHostException e) {
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}		
		return res;
	}
		
}
