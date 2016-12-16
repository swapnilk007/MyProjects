package org.redhat.com.Transformers;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class DataTransformer implements Processor{

	public void process(Exchange exchange) throws Exception {
		String custom = exchange.getIn()
				.getBody(String.class);
		
		System.out.println("In DataTransformer>>>>>>>>>>");
		String id = custom.substring(0, 2);
		String name = custom.substring(2,custom.length());
		System.out.println("id>>>>>>>>> " + id);
		System.out.println("name>>>>>>> " + name);
		
		
		StringBuilder csv = new StringBuilder();
		csv.append(id.trim());
		csv.append(",").append(name.trim());
		exchange.getIn().setBody(csv.toString());
	}
}
