package com.consoft.soapws.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.consoft.soapws.api.City;
import com.consoft.soapws.api.Region;

@Service
public class ResidencyServices {
	
	private static final List<Region> regions = new LinkedList<>();
	private static final List<City> cities = new LinkedList<>();
	
	@PostConstruct
	public void initialize() {
		initializeRegions();
		initializeCities();
	}
	
	public List<Region> getAllRegions(){
		return regions;
	}
	
	public List<City> getCitiesByRegionId(int regionId){
		return cities
			.stream()
			.filter(city -> city.getRegion() == regionId)
			.collect(Collectors.toList());
	}
	
	private void initializeRegions() {
		regions.clear();
		Region r1 = new Region();
		r1.setRegionID(1);
		r1.setRegionName("Lombardia");
		
		Region r2 = new Region();
		r2.setRegionID(2);
		r2.setRegionName("Piemonte");
		
		Region r3 = new Region();
		r3.setRegionID(3);
		r3.setRegionName("Puglia");
		
		regions.addAll(Arrays.asList(new Region[] {r1,r2,r3}));
	}
	
	private void initializeCities() {
		cities.clear();
		City c1 = new City();
		c1.setInitials("MI");
		c1.setName("Milano");
		c1.setRegion(1);
		
		City c3 = new City();
		c3.setInitials("BG");
		c3.setName("Bergamo");
		c3.setRegion(1);
		
		City c2 = new City();
		c2.setInitials("TA");
		c2.setName("Taranto");
		c2.setRegion(3);
		
		City c6 = new City();
		c6.setInitials("BA");
		c6.setName("Bari");
		c6.setRegion(3);
		
		City c4 = new City();
		c4.setInitials("AL");
		c4.setName("Alessandria");
		c4.setRegion(2);
		
		City c5 = new City();
		c5.setInitials("TO");
		c5.setName("Torino");
		c5.setRegion(2);
		
		cities.addAll(Arrays.asList(new City[] {c1,c2,c3,c4,c5,c6}));
	}
}
