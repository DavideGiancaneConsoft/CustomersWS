package com.consoft.soapws.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.consoft.soapws.api.CitiesByRegionRequest;
import com.consoft.soapws.api.CitiesByRegionResponse;
import com.consoft.soapws.api.City;
import com.consoft.soapws.api.Region;
import com.consoft.soapws.api.RegionsRequest;
import com.consoft.soapws.api.RegionsResponse;
import com.consoft.soapws.service.ResidencyServices;

@Endpoint
public class ResidencyEndpoint extends AbstractEndpoint {
	
	@Autowired
	private ResidencyServices residencyServices;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "RegionsRequest")
	@ResponsePayload
	public RegionsResponse getRegions(@RequestPayload RegionsRequest request) {
		//Creo la risposta (vuota)
		RegionsResponse response = objectFactory.createRegionsResponse();
		
		//USo il service per prelevare le regioni
		List<Region> regions = residencyServices.getAllRegions();
		
		//Inserisco le regioni nella risposta e la ritorno
		response.getRegions().addAll(regions);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CitiesByRegionRequest")
	@ResponsePayload
	public CitiesByRegionResponse getCitiesByRegion(@RequestPayload CitiesByRegionRequest request) {
		CitiesByRegionResponse response = objectFactory.createCitiesByRegionResponse();
		List<City> cities = residencyServices.getCitiesByRegionId(request.getRegionIdentifier());
		response.getCities().addAll(cities);
		return response;
	}
}
