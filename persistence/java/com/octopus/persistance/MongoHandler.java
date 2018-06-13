package com.octopus.persistance;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoHandler {
    private MongoDatabase database;

    public void connect(String uri, String dbName) {
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        database = mongoClient.getDatabase(dbName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }
}
