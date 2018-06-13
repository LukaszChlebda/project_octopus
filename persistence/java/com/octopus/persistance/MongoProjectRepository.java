package com.octopus.persistance;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoProjectRepository {

    // TODO: move the names to properties file
    private static final String DATABASE_NAME = "octopus";
    private static final String COLLECTION_NAME = "collection-name";

    private final MongoHandler mongoHandler;

    public MongoProjectRepository(MongoHandler mongoHandler) {
        this.mongoHandler = mongoHandler;
    }

    public void write() {
        MongoCollection<Document> collection = mongoHandler.getCollection(COLLECTION_NAME);
        collection.insertOne(new Document());
    }

    public FindIterable<Document> read(String id) {
        MongoCollection<Document> collection = mongoHandler.getCollection(COLLECTION_NAME);
        return collection.find();
    }

}
