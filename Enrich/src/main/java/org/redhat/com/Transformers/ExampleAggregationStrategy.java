package org.redhat.com.Transformers;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class ExampleAggregationStrategy implements AggregationStrategy {

	public Exchange aggregate(Exchange original, Exchange resource) {
		System.out.println("Called ExampleAggregationStrategy class>>");
		String originalBody = original.getIn().getBody(String.class);
		String resourceResponse = resource.getIn().getBody(String.class);
		String mergeResult = originalBody + "-" + resourceResponse;
		System.out.println("originalBody >> " + originalBody);
		System.out.println("resourceResponse >> " + resourceResponse);
		if (original.getPattern().isOutCapable()) {
			original.getOut().setBody(mergeResult);
		} else {
			original.getIn().setBody(mergeResult);
		}
		return original;
	}
}
