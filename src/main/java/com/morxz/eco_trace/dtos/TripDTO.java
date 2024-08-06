package com.morxz.eco_trace.dtos;

import com.morxz.eco_trace.models.enums.FuelType;
import com.morxz.eco_trace.models.enums.VehiculeSize;
import com.morxz.eco_trace.models.enums.VehiculeType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class TripDTO {
    // Getters et Setters
    private Long id;
    private VehiculeSize vehicleSize;
    private VehiculeType vehiculeType;
    private FuelType fuelType;
    private double duration;
    private LocalDate date;
    private double carbonEmission;
    private String userId; // ID de l'utilisateur associé

    // Constructeur par défaut
    public TripDTO() {
    }

    // Constructeur avec tous les champs
    public TripDTO(Long id, VehiculeSize vehicleSize, VehiculeType vehiculeType, FuelType fuelType,
                   double duration, LocalDate date, double carbonEmission, String userId) {
        this.id = id;
        this.vehicleSize = vehicleSize;
        this.vehiculeType = vehiculeType;
        this.fuelType = fuelType;
        this.duration = duration;
        this.date = date;
        this.carbonEmission = carbonEmission;
        this.userId = userId;
    }

}
