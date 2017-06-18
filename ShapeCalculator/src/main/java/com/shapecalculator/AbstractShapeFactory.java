package com.shapecalculator;

import com.shapecalculator.impl.TriangleCalculator;

public class AbstractShapeFactory { 

	public static ShapeCalculator getShapeCalculator(String shapeName){
		if(shapeName.trim().equalsIgnoreCase("TRIANGLE")){
			return new TriangleCalculator();
		}else{
			return null;
		}
	}
}
