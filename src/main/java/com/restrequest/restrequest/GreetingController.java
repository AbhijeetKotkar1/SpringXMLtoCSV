package com.restrequest.restrequest;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/food")
	public void getFood() throws IOException {

		XMLParserSAX getCSV = new XMLParserSAX();
		getCSV.generateCSV();

	}
}
