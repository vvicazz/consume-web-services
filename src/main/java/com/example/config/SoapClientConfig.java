package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.client.CountryInfoServiceClient;

@Configuration
public class SoapClientConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("org.oorsprong.webservices.countryinfoservice");
		return marshaller;
	}

	@Bean
	public CountryInfoServiceClient countryInfoServiceClient(Jaxb2Marshaller marshaller) {
		CountryInfoServiceClient countryInfoServiceClient = new CountryInfoServiceClient();
		countryInfoServiceClient.setMarshaller(marshaller);
		countryInfoServiceClient.setUnmarshaller(marshaller);
		countryInfoServiceClient
				.setDefaultUri("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
		return countryInfoServiceClient;
	}

}
