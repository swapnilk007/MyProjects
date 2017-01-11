package org.redhat.support.service;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.redhat.support.entity.Billing;

public class DataProvider implements Processor{

	public void process(Exchange ex) throws Exception {
		// TODO Auto-generated method stub
		Billing billing = new Billing();
		billing.setBillingEventId(1L);
		ex.getOut().setBody(billing);
	}

}
