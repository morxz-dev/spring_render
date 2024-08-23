package com.morxz.eco_trace.services;

import com.morxz.eco_trace.repo.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserStatsService {

    @Autowired
    private TripRepository tripRepository;

    public Map<String, Double> getWeeklyEmissions(String userId) {
        Map<String, Double> emissions = new HashMap<>();

        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);

        for (int i = 0; i < 7; i++) {
            LocalDate date = startOfWeek.plusDays(i);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            String dayName = dayOfWeek.name().toLowerCase() + "Emission"; // e.g., "mondayEmission"

            Double emission = tripRepository.findDailyEmissionForUser(userId, date);
            emissions.put(dayName, emission != null ? round(emission) : 0.0);
        }

        return emissions;
    }

    public double getCurrentDayEmission(String userId) {
        LocalDate today = LocalDate.now();
        Double emission = tripRepository.findDailyEmissionForUser(userId, today);
        return emission != null ? round(emission) : 0.0;
    }

    public double getPreviousDayEmission(String userId) {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        Double emission = tripRepository.findDailyEmissionForUser(userId, yesterday);
        return emission != null ? round(emission) : 0.0;
    }

    public double getCurrentWeekMaxEmission(String userId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        Double emission = tripRepository.findMaxEmissionForUserBetweenDates(userId, startOfWeek, today);
        return emission != null ? round(emission) : 0.0;
    }

    public double getCurrentWeekMinEmission(String userId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        Double emission = tripRepository.findMinEmissionForUserBetweenDates(userId, startOfWeek, today);
        return emission != null ? round(emission) : 0.0;
    }

    public double getCurrentWeekAverageEmission(String userId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        Double emission = tripRepository.findAverageEmissionForUserBetweenDates(userId, startOfWeek, today);
        return emission != null ? round(emission) : 0.0;
    }

    public double getTotalEmissionSinceCreation(String userId) {
        Double emission = tripRepository.findTotalEmissionForUser(userId);
        return emission != null ? round(emission) : 0.0;
    }

    public double getAverageEmissionForAllUsers() {
        LocalDate startOfWeek = LocalDate.now().with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        Double emission = tripRepository.findAverageEmissionForAllUsersBetweenDates(startOfWeek, endOfWeek);
        return emission != null ? round(emission) : 0.0;
    }

    public double getAverageEmissionSinceCreation(String userId) {
        Double emission = tripRepository.findAverageEmissionForUser(userId);
        return emission != null ? round(emission) : 0.0;
    }

    public double getMaxEmissionSinceCreation(String userId) {
        Double emission = tripRepository.findMaxEmissionForUser(userId);
        return emission != null ? round(emission) : 0.0;
    }

    public double getMinEmissionSinceCreation(String userId) {
        Double emission = tripRepository.findMinEmissionForUser(userId);
        return emission != null ? round(emission) : 0.0;
    }

    // New method to get emission for a specific day of the week
    public double getDailyEmission(String userId, DayOfWeek dayOfWeek) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        LocalDate targetDate = startOfWeek.with(dayOfWeek);

        if (targetDate.isAfter(today)) {
            return 0.0;
        }

        Double emission = tripRepository.findDailyEmissionForUser(userId, targetDate);
        return emission != null ? round(emission) : 0.0;
    }

    private double round(Double value) {
        return new BigDecimal(value).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
