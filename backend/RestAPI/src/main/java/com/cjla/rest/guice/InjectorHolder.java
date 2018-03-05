package com.cjla.rest.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorHolder {
	private static Injector injector=null;
	private static Injector testInjector=null;
	
	private InjectorHolder(){}

	public static Injector getInjector() {
		if(injector==null){
			injector = Guice.createInjector(new HelloMojoModule());
		}
		return injector;
	}



}
