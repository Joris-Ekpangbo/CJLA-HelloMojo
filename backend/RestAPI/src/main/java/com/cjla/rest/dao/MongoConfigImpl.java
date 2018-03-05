package com.cjla.rest.dao;

import java.net.UnknownHostException;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.cjla.rest.databse.mongodb.MongoConfig;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Singleton
public class MongoConfigImpl implements MongoConfig {

	private static MongoConfigImpl mDbSingleton;

	private static MongoClient mongoClient;

	private static DB db;

	private String dbHost;
	private int dbPort;
	private String dbName;
	private String dbUser;
	private String dbPassword;

	@Inject
	private MongoConfigImpl() {
		Config config = ConfigFactory.load("app");
		dbHost = config.getString("app.db.hostname");
		dbPort = config.getInt("app.db.port");
		dbName = config.getString("app.db.name");
		dbUser = config.getString("app.db.user");

		if (config.hasPath("app.db.password")) {
			dbPassword = config.getString("app.db.password");
			if ("".equals(dbPassword)) {
				dbPassword = null;
			}
		}

	}

	public static MongoConfigImpl getInstance() {
		if (mDbSingleton == null) {
			mDbSingleton = new MongoConfigImpl();
		}
		return mDbSingleton;
	}

	@SuppressWarnings("deprecation")
	public DB getConnectiondb() {
		if (mongoClient == null) {
			try {
				mongoClient = new MongoClient(dbHost, dbPort);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (db == null) {
			db = mongoClient.getDB(dbName);
		}
		// With Authentication
		 if (dbPassword != null) {
		 MongoCredential credential = MongoCredential.createScramSha1Credential(dbUser, dbName, dbPassword.toCharArray());
		 MongoClient mongoClient = new MongoClient(new ServerAddress(dbHost,
		 dbPort), Arrays.asList(credential));
		 }
		return db;
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDbName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDbUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
