package com.example.client;

import org.oorsprong.webservices.countryinfoservice.ListOfContinentsByName;
import org.oorsprong.webservices.countryinfoservice.ListOfContinentsByNameResponse;
import org.oorsprong.webservices.countryinfoservice.ListOfCountryNamesByName;
import org.oorsprong.webservices.countryinfoservice.ListOfCountryNamesByNameResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryInfoServiceClient extends WebServiceGatewaySupport {

	public ListOfContinentsByNameResponse getListOfContinentsByName() {
		ListOfContinentsByName req = new ListOfContinentsByName();
		return (ListOfContinentsByNameResponse) getWebServiceTemplate().marshalSendAndReceive(req);
	}

	public ListOfCountryNamesByNameResponse getListOfCountryNamesByName() {
		ListOfCountryNamesByName req = new ListOfCountryNamesByName();
		return (ListOfCountryNamesByNameResponse) getWebServiceTemplate().marshalSendAndReceive(req);
	}
}
