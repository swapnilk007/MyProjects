package com.shapecalculator.impl;

import com.shapecalculator.ShapeCalculator;

public class TriangleCalculator extends ShapeCalculator {

	public String calculateShape(Integer height, String label, Integer labelRow) throws Exception {
		System.out.println("Entering calculateShape method");
		try{
			int labelLength = label.length();
			int lableRowFinal = labelRow != null ? labelRow : (height / 2);
			int diff = lableRowFinal - labelLength;
			String triangle = "";
			for (int i = 1; i <= height; i++) {
				// space printing logic
				int j = 0, k = 0;
				while (j < (height - i)) {
					triangle += "&nbsp;";
					j++;
				}
				// ascii character printing logic
				if (i == lableRowFinal) {
					if (diff > 0) {
						// label & ascii character printing
						int firstHalf = diff / 2;
						int secondHalf = diff - firstHalf;
						int l = 0, m = 0;
						while (l < firstHalf) {
							triangle += "X&nbsp;";
							l++;
						}
						while (k < labelLength) {
							triangle += label.charAt(k) + " ";
							k++;
						}
						while (m < secondHalf) {
							triangle += "X&nbsp;";
							m++;
						}
					} else {
						// only label will be printed on line
						while (k < labelLength) {
							triangle += label.charAt(k) + " ";
							k++;
						}
					}
				} else {
					// ascii character printing
					while (k < i) {
						triangle += "X ";
						k++;
					}
				}

				triangle += "<br />";
			}
			System.out.println("Exiting calculateShape method");
			return triangle;
		}catch(Exception e){
			System.out.println("Exception occurred : " + e.getMessage());
			throw e;
		}
	}
}
