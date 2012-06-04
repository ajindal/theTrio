package kidgames.handlers;

import java.net.UnknownHostException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class LevelHandler {
	
	public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws UnknownHostException
	{
		// Connect to MongoDB
		Mongo m;
		try {
			m = new Mongo();
		} catch (UnknownHostException e) {
			System.out.println("Unknown host. Can not connect to db");
			e.printStackTrace();
			throw e;
		} catch (MongoException e) {
			System.out.println("Error connecting to db");
			e.printStackTrace();
			throw e;
		}
		
		// See all the databases
		System.out.println("database: " + m.getDatabaseNames());
		
		// Connect to test database
		DB db = m.getDB("test");
		
		// Get all the collections in test and show them
		Set<String> colls = db.getCollectionNames();
		for (String s : colls) {
		    System.out.println("collection: " + s);
		}
		
		// Get test collection in test db
		DBCollection collection = db.getCollection("test");
		
		long totalDocuments = collection.count();
		System.out.println("totalDocuments: " + totalDocuments);	
		return getDocsJson(collection);
	}
	
	/*
	 * Print all docs in given collection
	 */
	@SuppressWarnings("unchecked")
	static JSONObject getDocsJson(DBCollection coll)
	{
        DBCursor cur = coll.find();
        JSONArray docArray  = new JSONArray();
        System.out.println("Docs in collection: " + coll.getName());
        while(cur.hasNext()) {
            System.out.println(cur.next());
            docArray.add(cur.next());
        }
        System.out.println("----End----");
        
        JSONObject allDocs = new JSONObject();
        allDocs.put("response", docArray);
        
        return allDocs;
	}
	
	public JSONObject doPut(HttpServletRequest request, HttpServletResponse response)
	{
		return new JSONObject();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		throw new Exception("Method not supported");
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		throw new Exception("Method not supported");
	}

}
