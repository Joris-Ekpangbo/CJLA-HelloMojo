package com.cjla.rest.databse.mongodb;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface MongoConfig {

	
	String getHost();
	int getPort();
	String getDbName();
	String getDbUser();
	String getPassword();
	
}
