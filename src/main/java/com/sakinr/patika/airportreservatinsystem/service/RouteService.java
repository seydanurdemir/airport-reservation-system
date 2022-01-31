package com.sakinr.patika.airportreservatinsystem.service;


import com.sakinr.patika.airportreservatinsystem.model.Route;

import java.util.List;

public interface RouteService {

    List<Route> getAllRoutes();

    Route getRoute(Integer id);

    void addRoute(Route route);

    Route updateRoute(Route route);

    boolean deleteRoute(Integer id);

    Route getFirstRouteByDepartureAirportByDefault(Integer departure_airport_id);

}