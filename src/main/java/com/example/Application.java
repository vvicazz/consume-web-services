package com.example;

import org.oorsprong.webservices.countryinfoservice.ListOfContinentsByNameResponse;
import org.oorsprong.webservices.countryinfoservice.ListOfCountryNamesByNameResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.client.CountryInfoServiceClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		CountryInfoServiceClient countryClient = context.getBean(CountryInfoServiceClient.class);

		System.out.println("\n\nContinent Names");
		ListOfContinentsByNameResponse continents = countryClient.getListOfContinentsByName();
		continents.getListOfContinentsByNameResult().getTContinent()
				.forEach(con -> System.out.println(con.getSCode() + " : " + con.getSName()));

		System.out.println("\n\nCountry Names");
		ListOfCountryNamesByNameResponse countryNames = countryClient.getListOfCountryNamesByName();
		countryNames.getListOfCountryNamesByNameResult().getTCountryCodeAndName()
				.forEach(cc -> System.out.println(cc.getSISOCode() + " : " + cc.getSName()));
	}
}
