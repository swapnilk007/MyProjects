package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shapecalculator.AbstractShapeFactory;
import com.shapecalculator.ShapeCalculator;

@Controller
public class ShapeController {
	
	@RequestMapping("/shapecalculator")
	public ModelAndView displayWelcomePage(){
		return new ModelAndView("welcome", "message", "Hello User..!!");
	}
	
	@RequestMapping("/displayShape")
	public ModelAndView displayShape(Integer height, String label, Integer labelRow,String shapeName) {
		System.out.println("Entering displayShape method");
		//As of now we are not accepting input from jsp so hardcoding here
		height = 9;
		label = "TEA";
		labelRow = 6;
		shapeName = "TRIANGLE";
		
		String calculatedShape = null;
		ShapeCalculator shapeCalculator = null;
		try{
			validateInput(height,label,labelRow);
			if(null != shapeName){
				//Abstract factory design pattern
				shapeCalculator = AbstractShapeFactory.getShapeCalculator(shapeName);
				
				if(null == labelRow){
					//Default value
					labelRow = 4;
				}
				if(null == label){
					//Default value
					label = "HI";
				}
				calculatedShape = shapeCalculator.calculateShape(height, label, labelRow);
			}
		}catch(Exception e){
			System.out.println("Exception occurred : " + e.getMessage());
			//Do error handling either on same page or divert it to some error.jsp
			return new ModelAndView("errorpage", "message", e.getMessage());
		}
		System.out.println("Exiting displayShape method");
		return new ModelAndView("displayshape", "message", calculatedShape);
	}
	
	private void validateInput(Integer height, String label, Integer labelRow) throws Exception{
		System.out.println("Entering validateInput method");
		//Add logic to validate inputs
		//throw new Exception("validation error message add here");
		System.out.println("Exiting validateInput method");
	}
}
