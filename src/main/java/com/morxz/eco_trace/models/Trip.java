package com.morxz.eco_trace.models;

import com.morxz.eco_trace.models.enums.FuelType;
import com.morxz.eco_trace.models.enums.VehiculeSize;
import com.morxz.eco_trace.models.enums.VehiculeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "trips")
@Data // Lombok pour générer les getters, setters, toString, etc.
@NoArgsConstructor // Constructeur par défaut
@AllArgsConstructor // Constructeur avec tous les champs
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID auto-généré pour chaque voyage

    @Enumerated(EnumType.STRING)
    private VehiculeSize vehicleSize; // Taille du véhicule

    @Enumerated(EnumType.STRING)
    private VehiculeType vehiculeType; // Type de véhicule

    @Enumerated(EnumType.STRING)
    private FuelType fuelType; // Type de carburant

    private double duration; // Durée du voyage en heures
    private double distance; // Distance en km

    private LocalDate date; // Date du voyage
    private double carbonEmission; // Émission de carbone pour ce voyage

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) // Lien vers l'utilisateur
    private User user; // L'utilisateur qui a effectué le voyage

    // Méthode pour calculer les émissions de carbone
    public void calculateCarbonEmission(double distance, double emissionFactor) {
        this.carbonEmission = distance * emissionFactor; // Calcul des émissions
    }

    public Long getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehiculeSize getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(VehiculeSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public VehiculeType getVehiculeType() {
        return vehiculeType;
    }

    public void setVehiculeType(VehiculeType vehiculeType) {
        this.vehiculeType = vehiculeType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(double carbonEmission) {
        this.carbonEmission = carbonEmission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
