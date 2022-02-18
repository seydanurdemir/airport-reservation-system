package com.sakinr.patika.airportreservatinsystem.controller;


import com.sakinr.patika.airportreservatinsystem.model.AirportDTO;
import com.sakinr.patika.airportreservatinsystem.model.entity.Airport;
import com.sakinr.patika.airportreservatinsystem.model.mapper.AirportMapper;
import com.sakinr.patika.airportreservatinsystem.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airport")
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public String welcome() {
        return "Welcome to Airport Service!";
    }

    @GetMapping(value = "/all")
    public List<AirportDTO> getAllAirports() {
        List<Airport> allAirports = airportService.getAllAirports();
        return allAirports.stream().map(AirportMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAirport(@PathVariable String id) {
        ResponseEntity<?> response = null;
        Airport airport = airportService.getAirport(id);
        AirportDTO airportDTO = AirportMapper.toDto(airport);
        response = new ResponseEntity<>(airportDTO, HttpStatus.OK);
        return response;
    }

    @PostMapping(value = "/create")
    public void saveAirport(@Valid @RequestBody AirportDTO airport) {
        airportService.addAirport(AirportMapper.toEntity(airport));
    }

    @PutMapping(value = "/update/{id}")
    public AirportDTO updateAirport(@PathVariable String id, @Valid @RequestBody AirportDTO airport) {
        return AirportMapper.toDto(airportService.updateAirport(id, AirportMapper.toEntity(airport)));
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteAirport(@RequestParam String id) {
        return airportService.deleteAirport(id);
    }

}
