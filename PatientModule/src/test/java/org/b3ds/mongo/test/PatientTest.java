package org.b3ds.mongo.test;
import java.lang.reflect.Type;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3ds.feish.mongo.Patient;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.Document;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;

public class PatientTest {
	private final static Logger logger = LogManager.getLogger(PatientTest.class);
	
	private final String FamilyHistory =  "{\"user_id\":798,\"member_name\":14,\"relationship_id\":15,\"age\":10,\"disease_id\":\"djcb\",\"current_status\":100,\"year\":1995,\"description\":\"ndkc\"}";
	private final String PatientProfile = "{\"user_id\":\"798\",\"weight\":\"63\",\"height\":\"635\",\"gender\":\"2\",\"marital_status\":\"2\",\"address\":\"Noida \",\"first_name\":\"Paient\",\"last_name\":\"Side\",\"email\":\"kirtisri4@gmail.com\",\"mobile\":\"9415236122\",\"occupation_id\":\"4\",\"ethnicity_id\":\"2\",\"blood_group\":\"7\",\"identity_type\":\"2\",\"identity_id\":\"9555656866\"}";
	private final String LabResult = "{\"user_id\":\"798\",\"test_id\":\"5\",\"test_date\":\"2018\\/08\\/31\",\"description\":\"knck\",\"observed_value\":\"10\",\"report\":\"url\"}";
	private final String Treatment = "{\"user_id\":798,\"end_date\":\"2018\\/08\\/31\",\"start_date\":\"2018\\/08\\/31\",\"name\":10,\"procedure_id\":10,\"is_cured\":100,\"is_running\":1995}";
	private final String MedicalHistory = "{\"user_id\":\"798\",\"conditions\":14,\"condition_type\":\"bdbf\",\"current_medication\":1,\"mh_date\":\"2018\\/08\\/31\",\"description\":\"ndkc\"}";
	private final String VitalSign = "{\"user_id\":798,\"vital_sign_list_id\":14,\"vital_unit_id\":15,\"max_observation\":1,\"min_observation\":200,\"observation\":100,\"remark\":\"ndkc\"}";

	@Test
	public void testInsertNewPatient() throws UnknownHostException
	{
		Patient patient = new Patient("Patient");
		
//		patient.addNewPatient(PatientProfile);
	}
	
//	@Test
	public void testInsertFamilyHistory() throws UnknownHostException
	{
		Patient patient = new Patient("Patient");
//		patient.addFamilyHistory(FamilyHistory, "798");
	}

//	@Test
	public void testInsertLabResult() throws UnknownHostException
	{
		Patient patient = new Patient("LabResult");
	//	patient.addLabReport(LabResult);
	}

//	@Test
	public void testTreatment() throws UnknownHostException
	{
		Patient patient = new Patient("Patient");
		//patient.addTreatment(Treatment, "798");
	}

//	@Test
	public void testVitalSign() throws UnknownHostException
	{
		Patient patient = new Patient("Patient");
	//	patient.addVitalSign(VitalSign, "798");
	}

//	@Test
	public void testMedicalHistory() throws UnknownHostException
	{
		Patient patient = new Patient("Patient");
//		patient.addMedicalHistory(MedicalHistory, "798");
	}
}
