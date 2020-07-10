package com.consoft.soapws.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.consoft.soapws.api.City;
import com.consoft.soapws.api.GetCitiesByRegionRequest;
import com.consoft.soapws.api.GetCitiesByRegionResponse;
import com.consoft.soapws.api.GetRegionsRequest;
import com.consoft.soapws.api.GetRegionsResponse;
import com.consoft.soapws.api.Region;
import com.consoft.soapws.service.ResidencyServices;

@Endpoint
public class ResidencyEndpoint extends AbstractEndpoint {
	
	@Autowired
	private ResidencyServices residencyServices;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRegionsRequest")
	@ResponsePayload
	public GetRegionsResponse getRegions(@RequestPayload GetRegionsRequest request) {
		//Creo la risposta (vuota)
		GetRegionsResponse response = objectFactory.createGetRegionsResponse();
		
		//USo il service per prelevare le regioni
		List<Region> regions = residencyServices.getAllRegions();
		
		//Inserisco le regioni nella risposta e la ritorno
		response.getRegions().addAll(regions);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCitiesByRegionRequest")
	@ResponsePayload
	public GetCitiesByRegionResponse getCitiesByRegion(@RequestPayload GetCitiesByRegionRequest request) {
		GetCitiesByRegionResponse response = objectFactory.createGetCitiesByRegionResponse();
		List<City> cities = residencyServices.getCitiesByRegionId(request.getRegionIdentifier());
		response.getCities().addAll(cities);
		return response;
	}
}
