package org.b3ds.feish.mongo;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Patient {
	
	private final static Logger logger = LogManager.getLogger(Patient.class);
	private String collectionName;
	private String database;
	
	public Patient(String collectionName) throws UnknownHostException
	{
		this.collectionName = collectionName;
	}

	public Patient(String collectionName, String database) throws UnknownHostException
	{
		this.collectionName = collectionName;
		this.database = database;
	}
	
	private MongoCollection<Document> getCollection(String collection) throws UnknownHostException
	{
		MongoClient client = new MongoClient(new MongoClientURI("mongodb://192.168.1.16:27017"));
		MongoDatabase db = client.getDatabase("Feish");

		return db.getCollection(collection);
	}

	private MongoCollection<Document> getCollection(String collection, String database) throws UnknownHostException
	{
		MongoClient client = new MongoClient(new MongoClientURI("mongodb://192.168.1.16:27017"));
		MongoDatabase db = client.getDatabase(database);

		return db.getCollection(collection);
	}
	
	public void addNewPatient(Map<String, String> json) throws UnknownHostException
	{
		Document map = new Document();
		map.putAll(json);
		MongoCollection<Document> collection = getCollection(collectionName);
		System.out.println(map);
		collection.insertOne(map);
	}
	
	public void addFamilyHistory(Map<String, String> json, String user_id) throws UnknownHostException
	{
		
		Document doc = new Document();
		doc.append("user_id", user_id);

		MongoCollection<Document> collection = getCollection(collectionName);		
		FindIterable<Document> result = collection.find(doc);
		result.batchSize(1);
		Iterator<?> itr = result.iterator();

		while(itr.hasNext())
		{
			Document patient = (Document) itr.next();
			patient.put("familyHistory", json);
			collection.replaceOne(doc, patient);
		}
	}
	
	public void updatePatient(Map<String, String> json, String user_id) throws UnknownHostException
	{
		
		Document doc = new Document();
		doc.append("user_id", user_id);

		MongoCollection<Document> collection = getCollection(collectionName);		
		FindIterable<Document> result = collection.find(doc);
		result.batchSize(1);
		Iterator<?> itr = result.iterator();

		while(itr.hasNext())
		{
			Document patient = (Document) itr.next();
			patient.putAll(json);
			collection.replaceOne(doc, patient);
		}
	}

	public void addVitalSign(Map<String, String> json, String user_id) throws UnknownHostException
	{
/*		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, String>>(){}.getType();

		Map<String, String> map = gson.fromJson(json, type);*/
		
		Document doc = new Document();
		doc.append("user_id", user_id);

		MongoCollection<Document> collection = getCollection(collectionName);		
		FindIterable<Document> result = collection.find(doc);
		result.batchSize(1);
		Iterator<?> itr = result.iterator();
		while(itr.hasNext())
		{
			Document patient = (Document) itr.next();
			patient.put("vitalSign", json);
			collection.replaceOne(doc, patient);
		}
		
	}
	
	public void addLabReport(Map<String, String> json) throws UnknownHostException
	{
/*		Gson gson = new Gson();
		Type type = new TypeToken<Document>(){}.getType();*/
		Document map = new Document();
		map.putAll(json);
		
		MongoCollection<Document> collection = getCollection(collectionName);
		System.out.println(map);
		collection.insertOne(map);
	}
	
	public void addMedicalHistory(Map<String, String> json, String user_id) throws UnknownHostException
	{
/*		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, String>>(){}.getType();

		Map<String, String> map = gson.fromJson(json, type);*/
		
		Document doc = new Document();
		doc.append("user_id", user_id);

		MongoCollection<Document> collection = getCollection(collectionName);		
		FindIterable<Document> result = collection.find(doc);
		result.batchSize(1);
		Iterator<?> itr = result.iterator();
		while(itr.hasNext())
		{
			Document patient = (Document) itr.next();
			patient.put("MedicalHistory", json);
			collection.replaceOne(doc, patient);
		}
	}

	public void addTreatment(Map<String, String> json, String user_id) throws UnknownHostException
	{
/*		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, String>>(){}.getType();

		Map<String, String> map = gson.fromJson(json, type);*/
		
		Document doc = new Document();
		doc.append("user_id", user_id);

		MongoCollection<Document> collection = getCollection(collectionName);		
		FindIterable<Document> result = collection.find(doc);
		result.batchSize(1);
		Iterator<?> itr = result.iterator();
		while(itr.hasNext())
		{
			Document patient = (Document) itr.next();
			System.out.println(patient);
			patient.put("Treatment", json);
			collection.replaceOne(doc, patient);
		}
	}

	public List<Document> getReports(Map<String, String> param) throws UnknownHostException
	{
		Document doc = new Document();
		logger.debug(param);
		doc.append("id", param.get("user_id"));

		MongoCollection<Document> collection = getCollection(collectionName, database);		
		FindIterable<Document> result = collection.find(doc);
		Iterator<?> itr = result.iterator();
		ArrayList<Document> list = new ArrayList<>();
		while(itr.hasNext())
		{
			Document patient = (Document) itr.next();
			System.out.println(patient);
			Gson gso = new Gson();
//			System.out.println(StringEscapeUtils.UNESCAPE_HTML4.translate(gso.toJson(patient)));
			list.add(patient);
		}
		return list;
	}
}
