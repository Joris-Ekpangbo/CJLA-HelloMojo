package com.cjla.rest;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import com.cjla.rest.dao.MongoConfigImpl;
import com.cjla.rest.guice.InjectorHolder;
import com.cjla.rest.model.Post;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;

@Path("/")
public class WebService {

	private static final Logger LOG = Logger.getLogger(WebService.class.getName());
	private static MongoConfigImpl instance = null;

	public static MongoConfigImpl getInstance() {
		if (instance == null) {
			instance = InjectorHolder.getInjector().getInstance(MongoConfigImpl.class);
		}
		return instance;
	}

	// MongoConfigImpl dbSingleton = MongoConfigImpl.getInstance();
	// DB db = dbSingleton.getConnectiondb();
	// DBCollection dbCollection = db.getCollection("posts");

	// Block<Document> printBlock = new Block<Document>() {
	// @Override
	// public void apply(final Document document) {
	// System.out.println(document.toJson());
	// }
	// };

	@GET
	@Path("echo/{message}")
	@Produces("text/plain")
	public String showMsg(@PathParam("message") String message) {
		return message;
	}

	@GET
	@Path("allposts")
	@Produces(MediaType.APPLICATION_JSON)
	public Post getAllPosts() {

		// dbCollection.find().forEach((Consumer<? super DBObject>) printBlock);

		return null;
	}

	@GET
	@Path("posts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts() {
		DB db = MongoConfigImpl.getInstance().getConnectiondb();
		DBCollection dbCollection = db.getCollection("posts");

		List<Post> list = new ArrayList<Post>();
		DBCursor cursor = dbCollection.find();
		while (cursor.hasNext()) {
			DBObject o = cursor.next();
			Post post = new Post();
			// post.setId((String) o.get("_id"));
			post.setOwner((String) o.get("by"));
			post.setClassId((String) o.get("classId"));
			post.setContent((String) o.get("content"));
			// post.setLikes((int) o.get("likes"));

			list.add(post);
		}

		return list;
	}

	@GET
	@Path("posts/{owner}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getPostFromOwner(@Context Configuration context, @PathParam("owner") String owner) {
		DB db = MongoConfigImpl.getInstance().getConnectiondb();
		DBCollection dbCollection = db.getCollection("posts");
		DBCursor cursor = dbCollection.find(new BasicDBObject("by", owner));
		List list = new ArrayList();
		while (cursor.hasNext()) {
			DBObject o = cursor.next();
			Post post = new Post();
			// post.setId((String) o.get("_id"));
			post.setOwner((String) o.get("by"));
			post.setContent((String) o.get("content"));
			// post.setLikes((int) o.get("likes"));
			post.setClassId((String) o.get("classId"));
			list.add(post);
		}
		return list;
	}

	@GET
	@Path("classes")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchClasses(String uid) {
		LOG.info("Executing operation fetchUserById");
		// User u = getUserRepo().get(uid);
		return "";
	}

}
