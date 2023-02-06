package com.findbusroute.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.findbusroute.model.Routes;

@Repository
public interface RoutesRepository extends CrudRepository<Routes, Integer>{
	
	@Query("SELECT r FROM Routes r")
	public List<Routes> getAll();
	
	public Routes findByRouteId(int id);
	
	@Query("SELECT r FROM Routes r WHERE r.routeId LIKE %?1%")
	public Routes findRouteByRouteId(int routeId);

}
