package com.findbusroute.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findbusroute.model.Routes;
import com.findbusroute.repository.RoutesRepository;

@Service
public class RoutesService {
	
	@Autowired
	private RoutesRepository routesRepository;

	public void saveRoutesData() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/routes.txt"));
			
			String lineText = null;
			
			while((lineText=reader.readLine())!=null) {
				
				List<String> listLines = new ArrayList<>();
				List<String> list2 = new ArrayList<>();
								
				for (String value : lineText.split(" ")) { 
                  if(!value.equals(""))                                  
                  	listLines.add(value); 
				}
			   
			    Routes routes = new Routes();
				
			    routes.setRouteId(Integer.parseInt(listLines.get(0)));
			   				
				for (int i=1; i<listLines.size(); i++ ) {
					list2.add(listLines.get(i));
				}
				
				String[] strings  = new String[list2.size()];
				
				list2.toArray(strings);
				
				int[] values = Arrays.stream(strings)
                        .mapToInt(Integer::parseInt)
                        .toArray();
				if (routesRepository.findByRouteId(Integer.parseInt(listLines.get(0)))==null) {
					for(int i=0; i<values.length; i++) {
				         for (int j=i+1; j<values.length; j++) {
				            if(values[i] != values[j]) {
								routes.setBusStop(values);
								routesRepository.save(routes);
				           } 
				        }
				    }
				}
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkRoutes(int a, int b) {
		
		boolean finalResult = false;
		
		List<Boolean> listOfTrueBoolean=new ArrayList<>();
		
		List<Routes> listOfRoutes = routesRepository.getAll();
		
		for (int i=1; i<listOfRoutes.size()+1; i++) {
			Routes route2 = routesRepository.findById(i).get();
			int[] busStop = route2.getBusStop();
			boolean result = contains(busStop, a, b);
			
			if(result==true) listOfTrueBoolean.add(result);
		}
		
		for (int i=0; i<listOfTrueBoolean.size(); i++) {
			if (listOfTrueBoolean.get(i)==true) {
				finalResult = listOfTrueBoolean.get(i);
			}
		}
				
		return finalResult;
	}

	public static boolean contains(int[] array, int x, int y) {

    boolean result = false;

	    for(int i : array){
	        if(i == x){
	        	for(int j : array){
		        	if(j == y){
		                result = true;
		                break;
		            } 
	        	}
	        } 
    	} 
    	return result;
	}
	
}
