public package Connection;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class connector {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		try {
//			Connect to mongo server
	      MongoClient mongoClient = new MongoClient("localhost",27017);
//	      	set database
	      MongoDatabase db= mongoClient.getDatabase("mycollections");
//	      	use Collection
	      MongoCollection<Document> coll =db.getCollection("Student");
	      
	      System.out.println("Connection Established");
	      
//	      READ	      
//	      Document query = new Document("rollNo",101);
//	      MongoCursor<Document> cursor = coll.find(query).iterator();
//	      
//	      while(cursor.hasNext()) {
//	    	  Document doc = cursor.next();
//	    	  System.out.println(doc.toJson());
//	      }
	      
//	      INSERT
//	      Integer[] marks= {99,92,93,94,92};
//	      query = new Document("_id",11)
//	    		  .append("rollNo", 111)
//	    		  .append("regNo", 100011)
//	    		  .append("name", "Ankit")
//	    		  .append("dept", "ENTC")
//	    		  .append("marks", Arrays.asList(marks));
//	      coll.insertOne(query);
	      
//	      Update
//	      Document query = new Document("name","Ankit");
//	      Document setdoc= new Document("$set",new Document("rollNo",112));
//	      
//	      coll.updateOne(query, setdoc);
	      
//	      Delete
//	      Document query = new Document("name","Ankit");  
//	      coll.deleteOne(query);
	      
	      mongoClient.close();
	    }
	    catch(Exception e) {
	      System.out.println(e);
	    }	
		}

}
 {
    
}
