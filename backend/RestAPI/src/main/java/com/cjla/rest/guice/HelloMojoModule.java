package com.cjla.rest.guice;

import com.cjla.rest.dao.MongoConfigImpl;
import com.cjla.rest.databse.mongodb.MongoConfig;
import com.google.inject.AbstractModule;




public class HelloMojoModule extends AbstractModule {



	@Override
	protected void configure() {
//		bind(TypesafeConfigQualifier.class).to(AppTypeSafeConfigQualifier.class);
		bind(MongoConfig.class).to(MongoConfigImpl.class);
		
	}

}
