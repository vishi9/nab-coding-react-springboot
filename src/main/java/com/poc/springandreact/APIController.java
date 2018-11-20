package com.poc.springandreact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.poc.springandreact.models.CurrencyDiff;
import com.poc.springandreact.models.Price;
import com.poc.springandreact.models.Pricing;

@RestController
public class APIController {
	
	private static final Logger LOGGER = LogManager.getLogger(APIController.class);
	
	@GetMapping("/api/getdata")
	public String readJSON() throws IOException, ParseException {

		String fileName = "json/price.json";
		try {
			ClassLoader classLoader = new APIController().getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			JsonReader reader = new JsonReader(new FileReader(file));
			Pricing pricing = new Gson().fromJson(reader, Pricing.class);
			// calling calculate profit
			List<CurrencyDiff> currencyDiffList = calculateProfit(createMap(pricing));
			String jsonInString = new Gson().toJson(currencyDiffList );
			return jsonInString;

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
		}
		return "Error";
	}

	private List<CurrencyDiff> calculateProfit(Map<String, Map<Integer, Double>> mapOfcurrencies) {
		Map<Integer, Double> mapOfRates;
		Iterator<String> mapIter = mapOfcurrencies.keySet().iterator();
		List<CurrencyDiff> list = new ArrayList<CurrencyDiff>();
		CurrencyDiff currencyDiff;
		while (mapIter.hasNext()) {
			String currency = mapIter.next();
			mapOfRates = mapOfcurrencies.get(currency);// TODO Remove one line
														// of code
			currencyDiff = findMaxProfit(mapOfRates, currency);
			list.add(currencyDiff);
		}
		return list;
	}

	private CurrencyDiff findMaxProfit(Map<Integer, Double> mapOfRates, String currency) {

		List<Integer> sortedKeys = new ArrayList<Integer>(mapOfRates.keySet());
		Collections.sort(sortedKeys);
		Iterator<Integer> iter = sortedKeys.iterator();
		int arr_size = sortedKeys.size();
		int[] arrKeys = new int[arr_size];
		double[] arrValues = new double[arr_size];
		int x = 0;
		while (iter.hasNext()) {
			int key = iter.next();
			arrKeys[x] = key;
			arrValues[x] = Double.valueOf(mapOfRates.get(key));
			x++;
		}

		double max_diff = arrValues[1] - arrValues[0];
		int i, j;
		Map<Double, CurrencyDiff> map = new TreeMap<Double, CurrencyDiff>();
		CurrencyDiff cDiff = null;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (arrValues[j] - arrValues[i] > max_diff) {
					max_diff = arrValues[j] - arrValues[i];
					DecimalFormat df = new DecimalFormat("#.##");      
					max_diff = Double.valueOf(df.format(max_diff));
					cDiff = new CurrencyDiff();
					cDiff.setMinIndex(i);
					cDiff.setMinTs(arrKeys[i]);
					cDiff.setMaxIndex(j);
					cDiff.setMaxTs(arrKeys[j]);
					cDiff.setProfit(max_diff);
					cDiff.setCurrency(currency);
					map.put(max_diff, cDiff);
				}
			}
		}
		return map.get(max_diff);
	}

	private Map<String, Map<Integer, Double>> createMap(Pricing pricing) {
		Map<String, Map<Integer, Double>> mapOfcurrencies = new TreeMap<String, Map<Integer, Double>>();

		// Calculate number of different currencies
		Set<String> keySet = new HashSet<String>();
		for (Price price : pricing.getPrice()) {
			keySet.add(price.getCurrency());
		}

		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String currency = iter.next();
			Map<Integer, Double> mapOfRates = new TreeMap<Integer, Double>();
			for (Price price : pricing.getPrice()) {
				if (currency.equalsIgnoreCase(price.getCurrency())) {
					mapOfRates.put(price.getTime(), price.getPrice());
				}
			}
			mapOfcurrencies.put(currency, mapOfRates);
		}
		return mapOfcurrencies;
	}
}
