package com.morxz.eco_trace.utils;

import java.util.HashMap;
import java.util.Map;

public class EmissionFactors {
    private static final Map<String, Double> emissionFactors = new HashMap<>();

    static {
        // Mapping of vehicle types and sizes to fuel types with emission factors

        // Voiture
        emissionFactors.put("VOITURE-ESSENCE-MOYEN", 2.50);
        emissionFactors.put("VOITURE-ESSENCE-GRAND", 2.70);
        emissionFactors.put("VOITURE-DIESEL-MOYEN", 2.90);
        emissionFactors.put("VOITURE-DIESEL-GRAND", 3.10);
        emissionFactors.put("VOITURE-GPL-MOYEN", 2.10);
        emissionFactors.put("VOITURE-GPL-GRAND", 2.30);
        emissionFactors.put("VOITURE-BIOCARBURANT-MOYEN", 2.00);
        emissionFactors.put("VOITURE-BIOCARBURANT-GRAND", 2.20);
        emissionFactors.put("VOITURE-ELECTRIQUE-MOYEN", 0.0);
        emissionFactors.put("VOITURE-ELECTRIQUE-GRAND", 0.0);
        emissionFactors.put("VOITURE-HYBRIDE-MOYEN", 1.70);
        emissionFactors.put("VOITURE-HYBRIDE-GRAND", 1.90);

        // Voiture with unknown fuel type
        double voitureAvgEmissionFactorMoyen = (2.50 + 2.90 + 2.10 + 2.00 + 1.70) / 5;
        double voitureAvgEmissionFactorGrand = (2.70 + 3.10 + 2.30 + 2.20 + 1.90) / 5;
        emissionFactors.put("VOITURE-INCONNU-MOYEN", voitureAvgEmissionFactorMoyen);
        emissionFactors.put("VOITURE-INCONNU-GRAND", voitureAvgEmissionFactorGrand);

        // Moto
        emissionFactors.put("MOTO-ESSENCE-MOYEN", 2.00);
        emissionFactors.put("MOTO-ESSENCE-GRAND", 2.20);
        emissionFactors.put("MOTO-DIESEL-MOYEN", 2.30);
        emissionFactors.put("MOTO-DIESEL-GRAND", 2.50);
        emissionFactors.put("MOTO-GPL-MOYEN", 1.85);
        emissionFactors.put("MOTO-GPL-GRAND", 2.00);
        emissionFactors.put("MOTO-BIOCARBURANT-MOYEN", 1.65);
        emissionFactors.put("MOTO-BIOCARBURANT-GRAND", 1.80);
        emissionFactors.put("MOTO-ELECTRIQUE-MOYEN", 0.0);
        emissionFactors.put("MOTO-ELECTRIQUE-GRAND", 0.0);
        emissionFactors.put("MOTO-HYBRIDE-MOYEN", 1.50);
        emissionFactors.put("MOTO-HYBRIDE-GRAND", 1.70);

        // Moto with unknown fuel type
        double motoAvgEmissionFactorMoyen = (2.00 + 2.30 + 1.85 + 1.65 + 1.50) / 5;
        double motoAvgEmissionFactorGrand = (2.20 + 2.50 + 2.00 + 1.80 + 1.70) / 5;
        emissionFactors.put("MOTO-INCONNU-MOYEN", motoAvgEmissionFactorMoyen);
        emissionFactors.put("MOTO-INCONNU-GRAND", motoAvgEmissionFactorGrand);

        // Piétons (course)
        emissionFactors.put("MARCHE_COURSE-SANS_CARBURANT-RIEN", 0.0);

        // Vélo
        emissionFactors.put("VELO-SANS_CARBURANT-RIEN", 0.0);

        // Bus
        emissionFactors.put("BUS-ESSENCE-MOYEN", 3.20);
        emissionFactors.put("BUS-ESSENCE-GRAND", 3.50);
        emissionFactors.put("BUS-DIESEL-MOYEN", 3.70);
        emissionFactors.put("BUS-DIESEL-GRAND", 4.00);
        emissionFactors.put("BUS-ELECTRIQUE-MOYEN", 0.0);
        emissionFactors.put("BUS-ELECTRIQUE-GRAND", 0.0);
        emissionFactors.put("BUS-HYBRIDE-MOYEN", 2.40);
        emissionFactors.put("BUS-HYBRIDE-GRAND", 2.70);

        // Bus with unknown fuel type
        double busAvgEmissionFactorMoyen = (3.20 + 3.70 + 2.40) / 3;
        double busAvgEmissionFactorGrand = (3.50 + 4.00 + 2.70) / 3;
        emissionFactors.put("BUS-INCONNU-MOYEN", busAvgEmissionFactorMoyen);
        emissionFactors.put("BUS-INCONNU-GRAND", busAvgEmissionFactorGrand);

        // Train
        emissionFactors.put("TRAIN-ELECTRIQUE-RIEN", 0.0); // Assuming electric trains
        emissionFactors.put("TRAIN-DIESEL-RIEN", 2.00); // Diesel trains

        // Train with unknown fuel type
        emissionFactors.put("TRAIN-INCONNU-RIEN", 1.00); // Assuming average emission factor

        // Animal
        emissionFactors.put("ANIMAL-SANS_CARBURANT-RIEN", 0.0);

        // Bateau
        emissionFactors.put("BATEAU-ESSENCE-MOYEN", 3.00);
        emissionFactors.put("BATEAU-ESSENCE-GRAND", 3.30);
        emissionFactors.put("BATEAU-DIESEL-MOYEN", 3.40);
        emissionFactors.put("BATEAU-DIESEL-GRAND", 3.60);
        emissionFactors.put("BATEAU-BIOCARBURANT-MOYEN", 2.70);
        emissionFactors.put("BATEAU-BIOCARBURANT-GRAND", 3.00);

        // Bateau with unknown fuel type
        double bateauAvgEmissionFactorMoyen = (3.00 + 3.40 + 2.70) / 3;
        double bateauAvgEmissionFactorGrand = (3.30 + 3.60 + 3.00) / 3;
        emissionFactors.put("BATEAU-INCONNU-MOYEN", bateauAvgEmissionFactorMoyen);
        emissionFactors.put("BATEAU-INCONNU-GRAND", bateauAvgEmissionFactorGrand);

        // Avion
        emissionFactors.put("AVION-JET_FUEL-RIEN", 3.15); // Assuming jet fuel for airplanes

        // Avion with unknown fuel type
        emissionFactors.put("AVION-INCONNU-RIEN", 3.15); // Assuming average emission factor
    }


    public static double getEmissionFactor(String key) {
        return emissionFactors.getOrDefault(key, 0.0);
    }
}
