package com.aaron.util.mongodb;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * MongoDB 操作collection
 * 
 * @author Aaron
 * @date 2020年4月6日
 * @version 1.0
 * @package_type com.sdy.im.TestMongoDB
 */
public class MongoDBOperation {
	static Block<Document> printBlock = new Block<Document>() {
		public void apply(final Document document) {
			System.out.println(document.toJson());
		}
	};

	@SuppressWarnings({ "resource", "rawtypes", "unused" })
	public static void main(String args[]) {

		try {
			// To connect to mongodb server
			// MongoClient mongoClient = new MongoClient("192.168.128.131", 27017);
			// 安全认证模式
			MongoClientURI uri = new MongoClientURI(
					"mongodb://testuser:1234@192.168.128.131:27017/test_db2?authSource=test_db2");
			MongoClient mongoClient = new MongoClient(uri);

			// getDataBase(mongoClient);
			// createCollection(mongoClient);
			// insertCollection(mongoClient);
			// updateCollection(mongoClient);
			deleteCollection(mongoClient);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * 要从集合中删除第一个文档，需要首先使用findOne()方法选择文档，然后使用com.mongodb.DBCollection类的remove()方法。//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/mongodb/mongodb_java.html
	 * 
	 * 
	 * @param mongoClient
	 */
	public static void deleteCollection(MongoClient mongoClient) {
		MongoDatabase database = mongoClient.getDatabase("test_db2");
		MongoCollection<Document> collection = database.getCollection("myTestCollection");
		collection.find().forEach(printBlock);
		// 删除文档
		collection.deleteOne(eq("_id", 1999));
		System.out.println("After Delete Document:");
		collection.find().forEach(printBlock);
	}

	/**
	 * 要从集合更新文档，使用com.mongodb.DBCollection类的update()和updateMany()方法
	 * 
	 * @param mongoClient
	 */
	public static void updateCollection(MongoClient mongoClient) {
		MongoDatabase database = mongoClient.getDatabase("test_db2");
		MongoCollection<Document> collection = database.getCollection("myTestCollection");
		collection.find().forEach(printBlock);
		collection.updateOne(eq("_id", 1999), new Document("$set", new Document("title", "更新了标题2")));
		collection.find().forEach(printBlock);
	}

	/**
	 * 将文档插入到MongoDB中，使用com.mongodb.DBCollection类的insertOne()方法。
	 * 
	 * @param mongoClient
	 */
	public static void insertCollection(MongoClient mongoClient) {
		MongoDatabase database = mongoClient.getDatabase("test_db2");

		MongoCollection<Document> collection = database.getCollection("myTestCollection");

		Document document1 = new Document("_id", 1999).append("title", "MongoDB Insert Demo")
				.append("description", "database").append("likes", 30).append("by", "yiibai point")
				.append("url", "http://www.yiibai.com/mongodb/");
		Document document2 = new Document("_id", 2000).append("title", "MongoDB insertMany Demo")
				.append("description", "database").append("likes", 30).append("by", "test_db2")
				.append("url", "http://www.baidu.com");

		// collection.insertOne(document1);

		List<Document> documents = new ArrayList<Document>();
		documents.add(document1);
		documents.add(document2);
		collection.insertMany(documents);

		collection.find().forEach(printBlock);

		System.out.println("Document inserted successfully");
	}

	/**
	 * 创建集合，可使用 com.mongodb.DB 类的 createCollection()方法。
	 * 
	 * @param mongoClient
	 */
	public static void createCollection(MongoClient mongoClient) {
		// Now connect to your databases
		MongoDatabase database = mongoClient.getDatabase("test_db2");

		// 先创建collection capped创建固定集合，后面不能对其删除或者修改，只能将改collection删除重建
		// database.createCollection("myTestCollection",new
		// CreateCollectionOptions().capped(true).sizeInBytes(0x100000));

		MongoCollection<Document> coll = database.getCollection("myTestCollection");

		System.out.println("Collection created successfully");

		System.out.println("当前数据库中的所有集合是：");

		for (String name : database.listCollectionNames()) {
			System.out.println(name);
		}
	}

	/**
	 * 连接数据库
	 * 
	 * @param mongoClient
	 */
	public static void getDataBase(MongoClient mongoClient) {
		MongoDatabase mgdb = mongoClient.getDatabase("test_db2");
		System.out.println("Connect to database successfully! MongoDatabase inof is : " + mgdb.getName());
	}
}
