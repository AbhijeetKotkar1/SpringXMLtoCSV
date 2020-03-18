package com.restrequest.restrequest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParserSAX {

	public void generateCSV() throws IOException {

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		FileWriter file = new FileWriter("output.csv");

		try {

			SAXParser saxParser = saxParserFactory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(new File("D:\\Java Projects\\restrequest\\src\\main\\resources\\static\\simple.xml"),
					handler);

			List<Food> foodList = handler.getFoodList();

			for (Food food : foodList) {
				file.write(food.toString());
			    file.write(System.getProperty( "line.separator" ));
			}

			file.close();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
