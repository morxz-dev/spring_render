package com.morxz.eco_trace.services;

import com.morxz.eco_trace.repo.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class UserStatsService {

    @Autowired
    private TripRepository tripRepository;

    public double getCurrentDayEmission(String userId) { // Changed Long to String
        LocalDate today = LocalDate.now();
        Double emission = tripRepository.findDailyEmissionForUser(userId, today); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    public double getPreviousDayEmission(String userId) { // Changed Long to String
        LocalDate yesterday = LocalDate.now().minusDays(1);
        Double emission = tripRepository.findDailyEmissionForUser(userId, yesterday); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    public double getCurrentWeekMaxEmission(String userId) { // Changed Long to String
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(java.time.DayOfWeek.MONDAY);
        Double emission = tripRepository.findMaxEmissionForUserBetweenDates(userId, startOfWeek, today); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    public double getCurrentWeekMinEmission(String userId) { // Changed Long to String
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(java.time.DayOfWeek.MONDAY);
        Double emission = tripRepository.findMinEmissionForUserBetweenDates(userId, startOfWeek, today); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    public double getCurrentWeekAverageEmission(String userId) { // Changed Long to String
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(java.time.DayOfWeek.MONDAY);
        Double emission = tripRepository.findAverageEmissionForUserBetweenDates(userId, startOfWeek, today); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    public double getTotalEmissionSinceCreation(String userId) { // Changed Long to String
        Double emission = tripRepository.findTotalEmissionForUser(userId); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    public double getAverageEmissionForAllUsers() {
        LocalDate startOfWeek = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        Double emission = tripRepository.findAverageEmissionForAllUsersBetweenDates(startOfWeek, endOfWeek);
        return emission != null ? round(emission) : 0.0;
    }

    // New methods
    public double getAverageEmissionSinceCreation(String userId) { // Changed Long to String
        Double emission = tripRepository.findAverageEmissionForUser(userId); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    public double getMaxEmissionSinceCreation(String userId) { // Changed Long to String
        Double emission = tripRepository.findMaxEmissionForUser(userId); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    public double getMinEmissionSinceCreation(String userId) { // Changed Long to String
        Double emission = tripRepository.findMinEmissionForUser(userId); // Ensure repo method accepts String
        return emission != null ? round(emission) : 0.0;
    }

    private double round(Double value) {
        return new BigDecimal(value).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}