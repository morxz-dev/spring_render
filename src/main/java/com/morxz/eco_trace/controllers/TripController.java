package com.morxz.eco_trace.controllers;

import com.morxz.eco_trace.dtos.TripDTO;
import com.morxz.eco_trace.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    // create trip
    @PostMapping
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO tripDTO) {
        TripDTO createdTrip = tripService.createTrip(tripDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
    }

    // Get trips by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TripDTO>> getTripsByUserId(@PathVariable String userId) {
        List<TripDTO> trips = tripService.getTripsByUserId(userId);
        return ResponseEntity.ok(trips);
    }

    // Get a specific trip of a specific user
    @GetMapping("/user/{userId}/trip/{id}")
    public ResponseEntity<TripDTO> getTripOfUser(@PathVariable String userId, @PathVariable Long id) {
        TripDTO trip = tripService.getTripOfUser(userId, id);
        if (trip == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trip);
    }


    //select a trip
    @GetMapping("/{id}")
    public ResponseEntity<TripDTO> getTripById(@PathVariable Long id) {
        TripDTO trip = tripService.getTripById(id);
        return ResponseEntity.ok(trip);
    }


    //select all trips
    @GetMapping
    public ResponseEntity<List<TripDTO>> getAllTrips() {
        List<TripDTO> trips = tripService.getAllTrips();
        return ResponseEntity.ok(trips);
    }

    // update a trip
    @PutMapping("/{id}")
    public ResponseEntity<TripDTO> updateTrip(@PathVariable Long id, @RequestBody TripDTO tripDTO) {
        TripDTO updatedTrip = tripService.updateTrip(id, tripDTO);
        return ResponseEntity.ok(updatedTrip);
    }

    // delete a trip
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }

    // Delete all trips for a specific user
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteAllTripsByUserId(@PathVariable String userId) {
        tripService.deleteAllTripsByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}
