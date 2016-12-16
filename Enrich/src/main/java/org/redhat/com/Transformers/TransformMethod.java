package org.redhat.com.Transformers;

public class TransformMethod {

	public static String append(String custom) {
		System.out.println("Called TransformMethod to enrich message");
		return "enriched message attached";
	}
}
