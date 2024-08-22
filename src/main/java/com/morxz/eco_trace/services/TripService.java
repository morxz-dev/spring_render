package com.morxz.eco_trace.services;

import com.morxz.eco_trace.dtos.TripDTO;
import com.morxz.eco_trace.models.Trip;
import com.morxz.eco_trace.models.User;
import com.morxz.eco_trace.models.enums.FuelType;
import com.morxz.eco_trace.models.enums.VehiculeSize;
import com.morxz.eco_trace.models.enums.VehiculeType;
import com.morxz.eco_trace.repo.TripRepository;
import com.morxz.eco_trace.repo.UserRepository;
import com.morxz.eco_trace.utils.EmissionFactors;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    @Autowired
    public TripService(TripRepository tripRepository, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    public TripDTO createTrip(TripDTO tripDTO) {
        User user = userRepository.findById(tripDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Trip trip = mapToEntity(tripDTO);
        trip.setUser(user); // Associer l'utilisateur au voyage
        trip.setCarbonEmission(calculateCarbonEmission(trip)); // Calculer et définir l'émission
        Trip savedTrip = tripRepository.save(trip);
        return mapToDTO(savedTrip);
    }

    public TripDTO getTripById(Long id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activité correspondante non trouvée " + id));
        return mapToDTO(trip);
    }

    public TripDTO getTripOfUser(String userId, Long tripId) {
        Trip trip = tripRepository.findByIdAndUserId(tripId, userId)
                .orElse(null);
        return mapToDTO(trip);
    }

    public List<TripDTO> getAllTrips() {
        return tripRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<TripDTO> getTripsByUserId(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return tripRepository.findByUser(user).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TripDTO updateTrip(Long id, TripDTO tripDTO) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activité correspondante non trouvée " + id));

        trip.setVehicleSize(tripDTO.getVehicleSize());
        trip.setVehiculeType(tripDTO.getVehiculeType());
        trip.setFuelType(tripDTO.getFuelType());
        trip.setDistance(tripDTO.getDistance());
        trip.setDuration(tripDTO.getDuration());
        trip.setDate(tripDTO.getDate());

        // Recalculer l'émission
        trip.setCarbonEmission(calculateCarbonEmission(trip));

        Trip updatedTrip = tripRepository.save(trip);
        return mapToDTO(updatedTrip);
    }

    public void deleteTrip(Long id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activité correspondante non trouvée " + id));
        tripRepository.delete(trip);
    }

    @Transactional
    public void deleteAllTripsByUserId(String userId) {
        tripRepository.deleteByUserId(userId);
    }

    private double calculateCarbonEmission(Trip trip) {
        // Obtenir le facteur d'émission de base
        double emissionFactor = getEmissionFactor(trip.getFuelType(), trip.getVehiculeType(), trip.getVehicleSize());

        // Ajuster le facteur d'émission en fonction de la durée
        double adjustedEmissionFactor = adjustEmissionFactorByDuration(emissionFactor, trip.getDuration());

        // Calculer les émissions basées uniquement sur la distance et le facteur d'émission ajusté
        double emission = trip.getDistance() * adjustedEmissionFactor;

        // Arrondir l'émission calculée avant de la renvoyer
        return round(emission);
    }

    private double adjustEmissionFactorByDuration(double emissionFactor, double duration) {
        double adjustmentFactor = 1 + (duration / 60) * 0.05; // 5% d'augmentation par heure
        return emissionFactor * adjustmentFactor;
    }

    private double getEmissionFactor(FuelType fuelType, VehiculeType vehiculeType, VehiculeSize vehiculeSize) {
        String key = vehiculeType.name() + "-" + fuelType.name() + "-" + vehiculeSize.name();
        return EmissionFactors.getEmissionFactor(key);
    }

    private double round(Double value) {
        return new BigDecimal(value).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private Trip mapToEntity(TripDTO tripDTO) {
        if (tripDTO == null) {
            return null;
        }

        Trip trip = new Trip();
        trip.setId(tripDTO.getId());
        trip.setVehicleSize(tripDTO.getVehicleSize());
        trip.setVehiculeType(tripDTO.getVehiculeType());
        trip.setFuelType(tripDTO.getFuelType());
        trip.setDuration(tripDTO.getDuration());
        trip.setDistance(tripDTO.getDistance());
        trip.setDate(tripDTO.getDate());
        return trip;
    }

    private TripDTO mapToDTO(Trip trip) {
        if (trip == null) {
            return null;
        }

        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(trip.getId());
        tripDTO.setVehicleSize(trip.getVehicleSize());
        tripDTO.setVehiculeType(trip.getVehiculeType());
        tripDTO.setFuelType(trip.getFuelType());
        tripDTO.setDuration(trip.getDuration());
        tripDTO.setDistance(trip.getDistance());
        tripDTO.setDate(trip.getDate());
        tripDTO.setCarbonEmission(trip.getCarbonEmission());
        tripDTO.setUserId(trip.getUser() != null ? trip.getUser().getId() : null);
        return tripDTO;
    }
}
