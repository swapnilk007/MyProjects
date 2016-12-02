package org.redhat.BlueprintServiceClient;

import org.redhat.blueprint.service.HelloWorldService;

public class HelloWorldClient {
	private HelloWorldService helloWorldService;

	public HelloWorldService getHelloWorldService() {
		return helloWorldService;
	}

	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	public void startUp(){
		System.out.println("HelloWorldClient is about to invoke service");
		helloWorldService.hello();
		System.out.println("HelloWorldClient has invoked service");
	}

}
