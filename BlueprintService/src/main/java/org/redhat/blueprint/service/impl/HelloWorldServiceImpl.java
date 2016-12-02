package org.redhat.blueprint.service.impl;

import org.redhat.blueprint.service.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService{

	public void hello() {
		System.out.println("Hi..This is HelloWorldServiceImpl");
		
	}

	public void startUp() {
		System.out.println("Started HelloWorldService");
		
	}
	

}
