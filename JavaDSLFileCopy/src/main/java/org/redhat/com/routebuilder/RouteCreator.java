package org.redhat.com.routebuilder;

import org.apache.camel.builder.RouteBuilder;

public class RouteCreator extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("file:///home/skumbhar/Fuse/test/javaDSL_input").log("Moving file ${headers.CamelFileName}")
				.to("file:///home/skumbhar/Fuse/test/javaDSL_output");
	}
}
