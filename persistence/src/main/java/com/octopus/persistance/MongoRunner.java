package com.octopus.persistance;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoRunner {

    public static void main(String[] args) throws Exception {
        // TODO: move the client url to properties file, username and password to configuration file on AWS as well
        MongoClientURI uri = new MongoClientURI("mongodb+srv://<USERNAME>:<PASSWORD>@octopus-jbfhe.mongodb.net/test?retryWrites=true/");
        MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase database = mongoClient.getDatabase("octopus");

        MongoCollection<Document> movies_initial = database.getCollection("collection-name");

    }
}
