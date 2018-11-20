package com.poc.springandreact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.poc.springandreact.models.CryptoCurrency;
import com.poc.springandreact.models.Price;
import com.poc.springandreact.models.Pricing;

@RestController
public class JSONController {
	
	private static final Logger LOGGER = LogManager.getLogger(JSONController.class);
	
	@GetMapping("/api/getjson")
	public String readJSON() throws IOException, ParseException {

		String fileName = "json/price.json";
		try {
			ClassLoader classLoader = new JSONController().getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			JsonReader reader = new JsonReader(new FileReader(file));
			Pricing pricing = new Gson().fromJson(reader, Pricing.class);
			// calling calculate profit
			String jsonInString = new Gson().toJson(createList(pricing));
			return jsonInString;

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
		}
		return "Error";
	}

	private ArrayList<CryptoCurrency> createList(Pricing pricing) {

		ArrayList<CryptoCurrency> aList = new ArrayList<CryptoCurrency>();
		CryptoCurrency crypto = null;
		for (Price price : pricing.getPrice()) {
			crypto = new CryptoCurrency();
			crypto.setCurrency(price.getCurrency());
			crypto.setDate(price.getDate());
			crypto.setPrice(price.getPrice());
			crypto.setTime(price.getTime());
			aList.add(crypto);
		}
		return aList;
	}
}
