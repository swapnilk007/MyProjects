package org.redhat.com.Transformers;

public class TransformMethod {

	public static String toCSV(String custom) {
		System.out.println("In TransformMethod >>>>>>>>>>");
		String id = custom.substring(0, 2);
		String name = custom.substring(2, custom.length());
		System.out.println("id>>>>>>>>> " + id);
		System.out.println("name>>>>>>> " + name);

		StringBuilder csv = new StringBuilder();
		csv.append(id.trim());
		csv.append(",").append(name.trim());
		return csv.toString();
	}
}
