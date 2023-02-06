package com.findbusroute.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "routes")
public class Routes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "route_id", nullable = false, unique = true)
	private int routeId;
	
	@Column(name = "bus_stop", nullable = false)
	private int busStop[];

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int[] getBusStop() {
		return busStop;
	}

	public void setBusStop(int[] busStop) {
		this.busStop = busStop;
	}

	public Routes(Integer id, int routeId, int[] busStop) {
		Id = id;
		this.routeId = routeId;
		this.busStop = busStop;
	}

	public Routes() {

	}

	@Override
	public String toString() {
		return "Routes [Id=" + Id + ", routeId=" + routeId + ", busStop=" + Arrays.toString(busStop) + "]";
	}

	
	
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(
//			name = "routes_busstop",
//			joinColumns = @JoinColumn(name = "route_id"),
//			inverseJoinColumns = @JoinColumn(name = "busstop_id")
//			)
//	private Set<BusStop> busStopes = new HashSet<>();
//
//	public Routes(Integer id, int routeId, Set<BusStop> busStopes) {
//		super();
//		Id = id;
//		this.routeId = routeId;
//		this.busStopes = busStopes;
//	}
//
//	public Routes() {
//	
//	}
//
//	public Integer getId() {
//		return Id;
//	}
//
//	public void setId(Integer id) {
//		Id = id;
//	}
//	
//	public int getRouteId() {
//		return routeId;
//	}
//
//	public void setRouteId(int routeId) {
//		this.routeId = routeId;
//	}
//
//	public Set<BusStop> getBusStopes() {
//		return busStopes;
//	}
//
//	public void setBusStopes(Set<BusStop> busStopes) {
//		this.busStopes = busStopes;
//	}
//
//	public void addBusStop(BusStop busStope) {
//		this.busStopes.add(busStope);
//	}

//	public boolean hasBusStop(int busStop) {
//		Iterator<BusStop> iterator = busStopes.iterator();
//		
//		while (iterator.hasNext()) {
//			BusStop busStop2 = iterator.next();
//			if (busStop2.getBusStop().equals(busStop)) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
//	@Override
//	public String toString() {
//		return "Routes [Id=" + Id + ", busStopes=" + busStopes + "]";
//	}

}
