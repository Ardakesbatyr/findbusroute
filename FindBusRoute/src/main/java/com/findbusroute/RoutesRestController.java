package com.findbusroute;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.findbusroute.model.Routes;
import com.findbusroute.model.RoutesDTO;
import com.findbusroute.repository.RoutesRepository;
import com.findbusroute.service.RoutesService;


@RestController
public class RoutesRestController {
	
	@Autowired
	RoutesService routesService;
	
	@GetMapping("/api/direct")
	public ResponseEntity<RoutesDTO> checkDirectByBusStopes(@RequestParam int from, @RequestParam int to) {
		
		routesService.saveRoutesData();
		
		RoutesDTO routesDTO = new RoutesDTO(); 
		
		routesDTO.setFrom(from);
		routesDTO.setTo(to);
		
		boolean checkRoutes = routesService.checkRoutes(from, to);
		
		routesDTO.setDirect(checkRoutes);
		
		return new ResponseEntity<>(routesDTO, HttpStatus.OK);

	}
		
}
