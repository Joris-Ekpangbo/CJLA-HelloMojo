package com.cjla.rest.di;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.cjla.rest.dao.MongoConfigImpl;
import com.cjla.rest.databse.mongodb.MongoConfig;


public class BackendBinder extends AbstractBinder {

		@Override
		protected void configure() {
			bind(MongoConfigImpl.class).to(MongoConfig.class);
			
		}

}
