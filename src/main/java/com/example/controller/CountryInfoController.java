package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oorsprong.webservices.countryinfoservice.ListOfContinentsByNameResponse;
import org.oorsprong.webservices.countryinfoservice.ListOfCountryNamesByNameResponse;
import org.oorsprong.webservices.countryinfoservice.ListOfCurrenciesByCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.CountryInfoServiceClient;

@RestController
@RequestMapping(path = "/info")
public class CountryInfoController {
	
	@Autowired
	private CountryInfoServiceClient countryInfoServiceClient;
	
	@GetMapping(path = "/continent")
	public Map<String, String> getContinentsName(){
		ListOfContinentsByNameResponse listOfContinents = countryInfoServiceClient.getListOfContinentsByName();
		Map<String, String> response = new HashMap<>();
 		listOfContinents.getListOfContinentsByNameResult().getTContinent().forEach(continent -> {
 			response.put(continent.getSCode(), continent.getSName());
 		});
 		
 		return response;
	}
	
	
	@GetMapping(path = "/country")
	public Map<String, String> getCountryName(){
		ListOfCountryNamesByNameResponse listOfCountry = countryInfoServiceClient.getListOfCountryNamesByName();
		Map<String, String> response = new HashMap<>();
		listOfCountry.getListOfCountryNamesByNameResult().getTCountryCodeAndName().forEach(country -> {
 			response.put(country.getSISOCode(), country.getSName());
 		});
 		
 		return response;
	}
	
	@GetMapping(path = "/currency")
	public Map<String, String> getCurrency(){
		ListOfCurrenciesByCodeResponse listOfCurrencies = countryInfoServiceClient.getListOfCurrenciesByCode();
		Map<String, String> response = new HashMap<>();
		listOfCurrencies.getListOfCurrenciesByCodeResult().getTCurrency().forEach(currency -> {
			response.put(currency.getSISOCode(),currency.getSName());
		});
		return response;
	}

}
