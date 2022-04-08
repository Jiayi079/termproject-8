import static spark.Spark.*;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class SparkDemo {

  public static void main(String[] args) {
        // open connection
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    // get ref to database
    MongoDatabase db = mongoClient.getDatabase("MyDatabase");
    // get ref to collection
    MongoCollection<Document> collection = db.getCollection("Classwork8");

    // Start server
    port(1234);

    get("/hello", (req, res) -> "asd");
  }
}
