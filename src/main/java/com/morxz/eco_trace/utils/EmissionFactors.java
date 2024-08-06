package com.morxz.eco_trace.utils;

import java.util.HashMap;
import java.util.Map;

public class EmissionFactors {
    private static final Map<String, Double> emissionFactors = new HashMap<>();

    static {
        // Initialize emission factors
        // Format: "FUELTYPE-VEHICULETYPE-VEHICULESIZE"

        // Essence
        emissionFactors.put("ESSENCE-VOITURE-PETIT", 2.31);
        emissionFactors.put("ESSENCE-VOITURE-MOYEN", 2.50);
        emissionFactors.put("ESSENCE-VOITURE-GRAND", 2.70);
        emissionFactors.put("ESSENCE-MOTO-PETIT", 1.85);
        emissionFactors.put("ESSENCE-MOTO-MOYEN", 2.00);
        emissionFactors.put("ESSENCE-MOTO-GRAND", 2.20);
        emissionFactors.put("ESSENCE-BATEAU-PETIT", 2.80);
        emissionFactors.put("ESSENCE-BATEAU-MOYEN", 3.00);
        emissionFactors.put("ESSENCE-BATEAU-GRAND", 3.30);
        emissionFactors.put("ESSENCE-TRAIN-TRES_GRAND", 1.90); // Approximation pour un train

        // Diesel
        emissionFactors.put("DIESEL-VOITURE-PETIT", 2.68);
        emissionFactors.put("DIESEL-VOITURE-MOYEN", 2.90);
        emissionFactors.put("DIESEL-VOITURE-GRAND", 3.10);
        emissionFactors.put("DIESEL-MOTO-PETIT", 2.10);
        emissionFactors.put("DIESEL-MOTO-MOYEN", 2.30);
        emissionFactors.put("DIESEL-MOTO-GRAND", 2.50);
        emissionFactors.put("DIESEL-BATEAU-PETIT", 3.15);
        emissionFactors.put("DIESEL-BATEAU-MOYEN", 3.40);
        emissionFactors.put("DIESEL-BATEAU-GRAND", 3.60);
        emissionFactors.put("DIESEL-TRAIN-TRES_GRAND", 2.00); // Approximation pour un train

        // Gaz de Pétrole Liquéfié (GPL)
        emissionFactors.put("GPL-VOITURE-PETIT", 1.90);
        emissionFactors.put("GPL-VOITURE-MOYEN", 2.10);
        emissionFactors.put("GPL-VOITURE-GRAND", 2.30);
        emissionFactors.put("GPL-MOTO-PETIT", 1.70);
        emissionFactors.put("GPL-MOTO-MOYEN", 1.85);
        emissionFactors.put("GPL-MOTO-GRAND", 2.00);
        emissionFactors.put("GPL-BATEAU-PETIT", 2.70);
        emissionFactors.put("GPL-BATEAU-MOYEN", 2.90);
        emissionFactors.put("GPL-BATEAU-GRAND", 3.20);
        emissionFactors.put("GPL-TRAIN-TRES_GRAND", 1.80); // Approximation pour un train

        // Biocarburants
        emissionFactors.put("BIOCARBURANT-VOITURE-PETIT", 1.80);
        emissionFactors.put("BIOCARBURANT-VOITURE-MOYEN", 2.00);
        emissionFactors.put("BIOCARBURANT-VOITURE-GRAND", 2.20);
        emissionFactors.put("BIOCARBURANT-MOTO-PETIT", 1.50);
        emissionFactors.put("BIOCARBURANT-MOTO-MOYEN", 1.65);
        emissionFactors.put("BIOCARBURANT-MOTO-GRAND", 1.80);
        emissionFactors.put("BIOCARBURANT-BATEAU-PETIT", 2.50);
        emissionFactors.put("BIOCARBURANT-BATEAU-MOYEN", 2.70);
        emissionFactors.put("BIOCARBURANT-BATEAU-GRAND", 3.00);
        emissionFactors.put("BIOCARBURANT-TRAIN-TRES_GRAND", 1.70); // Approximation pour un train

        // Électricité
        emissionFactors.put("ELECTRIQUE-VOITURE-PETIT", 0.0);
        emissionFactors.put("ELECTRIQUE-VOITURE-MOYEN", 0.0);
        emissionFactors.put("ELECTRIQUE-VOITURE-GRAND", 0.0);
        emissionFactors.put("ELECTRIQUE-MOTO-PETIT", 0.0);
        emissionFactors.put("ELECTRIQUE-MOTO-MOYEN", 0.0);
        emissionFactors.put("ELECTRIQUE-MOTO-GRAND", 0.0);
        emissionFactors.put("ELECTRIQUE-BATEAU-PETIT", 0.0);
        emissionFactors.put("ELECTRIQUE-BATEAU-MOYEN", 0.0);
        emissionFactors.put("ELECTRIQUE-BATEAU-GRAND", 0.0);
        emissionFactors.put("ELECTRIQUE-TRAIN-TRES_GRAND", 0.0); // Approximation pour un train

        // Hybride
        emissionFactors.put("HYBRIDE-VOITURE-PETIT", 1.50);
        emissionFactors.put("HYBRIDE-VOITURE-MOYEN", 1.70);
        emissionFactors.put("HYBRIDE-VOITURE-GRAND", 1.90);
        emissionFactors.put("HYBRIDE-MOTO-PETIT", 1.30);
        emissionFactors.put("HYBRIDE-MOTO-MOYEN", 1.50);
        emissionFactors.put("HYBRIDE-MOTO-GRAND", 1.70);
        emissionFactors.put("HYBRIDE-BATEAU-PETIT", 2.00);
        emissionFactors.put("HYBRIDE-BATEAU-MOYEN", 2.20);
        emissionFactors.put("HYBRIDE-BATEAU-GRAND", 2.40);
        emissionFactors.put("HYBRIDE-TRAIN-TRES_GRAND", 1.60); // Approximation pour un train

        // Sans carburant
        emissionFactors.put("SANS_CARBURANT-PIEDS_COURSE-PETIT", 0.0);
        emissionFactors.put("SANS_CARBURANT-PIEDS_COURSE-MOYEN", 0.0);
        emissionFactors.put("SANS_CARBURANT-PIEDS_COURSE-GRAND", 0.0);
        emissionFactors.put("SANS_CARBURANT-VELO-PETIT", 0.0);
        emissionFactors.put("SANS_CARBURANT-VELO-MOYEN", 0.0);
        emissionFactors.put("SANS_CARBURANT-VELO-GRAND", 0.0);
    }

    public static double getEmissionFactor(String key) {
        // Get the emission factor from the map, default to 0.0 if not found
        return emissionFactors.getOrDefault(key, 0.0);
    }
}
