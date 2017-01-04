package org.redhat.com.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessMessages implements Processor {

	public void process(Exchange arg0) throws Exception {
		System.out.println("Called processor>>>>>>>");
		throw new Exception("Breaking Flow>>>>>>>>>>");
	}
}
