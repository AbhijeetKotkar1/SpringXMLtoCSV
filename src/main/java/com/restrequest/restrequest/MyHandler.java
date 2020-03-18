package com.restrequest.restrequest;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

	private List<Food> foodList = null;
	private Food food;
	private StringBuilder data = null;

	public List<Food> getFoodList() {
		return foodList;
	}

	boolean bName;
	boolean bPrice;
	boolean bDescription;
	boolean bCalories;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("Food")) {
			food = new Food();
			if (foodList == null)
				foodList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("name")) {
			bName = true;
		} else if (qName.equalsIgnoreCase("price")) {
			bPrice = true;
		} else if (qName.equalsIgnoreCase("description")) {
			bDescription = true;
		} else if (qName.equalsIgnoreCase("calories")) {
			bCalories = true;
		}

		data = new StringBuilder();

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (bName) {
			food.setName(data.toString());
			bName = false;
		} else if (bPrice) {
			food.setPrice(data.toString());
			bPrice = false;
		} else if (bDescription) {
			food.setDescription(data.toString());
			bDescription = false;
		} else if (bCalories) {
			food.setCalories(Integer.parseInt(data.toString()));
			bCalories = false;
		}

		if (qName.equalsIgnoreCase("food")) {
			foodList.add(food);
		}

	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}

}
