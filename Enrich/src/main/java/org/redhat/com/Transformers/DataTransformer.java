package org.redhat.com.Transformers;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class DataTransformer implements Processor{

	public void process(Exchange exchange) throws Exception {
		System.out.println("Enriching message>>>>");
		exchange.getIn().setBody("enriched message attached");
	}
}
