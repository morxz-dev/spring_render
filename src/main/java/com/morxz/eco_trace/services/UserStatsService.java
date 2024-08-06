package com.morxz.eco_trace.services;

import com.morxz.eco_trace.repo.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class UserStatsService {

    @Autowired
    private TripRepository tripRepository;

    public double getCurrentDayEmission(Long userId) {
        LocalDate today = LocalDate.now();
        Double emission = tripRepository.findDailyEmissionForUser(userId, today);
        return emission != null ? emission : 0.0;
    }

    public double getPreviousDayEmission(Long userId) {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        Double emission = tripRepository.findDailyEmissionForUser(userId, yesterday);
        return emission != null ? emission : 0.0;
    }

    public double getCurrentWeekMaxEmission(Long userId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(java.time.DayOfWeek.MONDAY);
        Double emission = tripRepository.findMaxEmissionForUserBetweenDates(userId, startOfWeek, today);
        return emission != null ? emission : 0.0;
    }

    public double getCurrentWeekMinEmission(Long userId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(java.time.DayOfWeek.MONDAY);
        Double emission = tripRepository.findMinEmissionForUserBetweenDates(userId, startOfWeek, today);
        return emission != null ? emission : 0.0;
    }

    public double getCurrentWeekAverageEmission(Long userId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(java.time.DayOfWeek.MONDAY);
        Double emission = tripRepository.findAverageEmissionForUserBetweenDates(userId, startOfWeek, today);
        return emission != null ? emission : 0.0;
    }

    public double getTotalEmissionSinceCreation(Long userId) {
        Double emission = tripRepository.findTotalEmissionForUser(userId);
        return emission != null ? emission : 0.0;
    }

    public double getAverageEmissionForAllUsers() {
        LocalDate startOfWeek = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
        LocalDate endOfWeek = startOfWeek.plus(6, ChronoUnit.DAYS);
        Double emission = tripRepository.findAverageEmissionForAllUsersBetweenDates(startOfWeek, endOfWeek);
        return emission != null ? emission : 0.0;
    }

    // New methods
    public double getAverageEmissionSinceCreation(Long userId) {
        Double emission = tripRepository.findAverageEmissionForUser(userId);
        return emission != null ? emission : 0.0;
    }

    public double getMaxEmissionSinceCreation(Long userId) {
        Double emission = tripRepository.findMaxEmissionForUser(userId);
        return emission != null ? emission : 0.0;
    }

    public double getMinEmissionSinceCreation(Long userId) {
        Double emission = tripRepository.findMinEmissionForUser(userId);
        return emission != null ? emission : 0.0;
    }
}
