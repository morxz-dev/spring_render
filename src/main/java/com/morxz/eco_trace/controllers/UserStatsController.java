package com.morxz.eco_trace.controllers;

import com.morxz.eco_trace.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.Map;

@RestController
@RequestMapping("/api/user-stats")
public class UserStatsController {

    @Autowired
    private UserStatsService userStatsService;


    @GetMapping("/weekly-emissions/{userId}")
    public Map<String, Double> getWeeklyEmissions(@PathVariable String userId) {
        return userStatsService.getWeeklyEmissions(userId);
    }



    @GetMapping("/day/{userId}")
    public double getCurrentDayEmission(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getCurrentDayEmission(userId);
    }

    @GetMapping("/previous-day/{userId}")
    public double getPreviousDayEmission(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getPreviousDayEmission(userId);
    }

    @GetMapping("/week-max/{userId}")
    public double getCurrentWeekMaxEmission(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getCurrentWeekMaxEmission(userId);
    }

    @GetMapping("/week-min/{userId}")
    public double getCurrentWeekMinEmission(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getCurrentWeekMinEmission(userId);
    }

    @GetMapping("/week-average/{userId}")
    public double getCurrentWeekAverageEmission(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getCurrentWeekAverageEmission(userId);
    }

    @GetMapping("/total-since-creation/{userId}")
    public double getTotalEmissionSinceCreation(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getTotalEmissionSinceCreation(userId);
    }

    @GetMapping("/average-emission-for-all-users")
    public double getAverageEmissionForAllUsers() {
        return userStatsService.getAverageEmissionForAllUsers();
    }

    // New endpoints
    @GetMapping("/average-since-creation/{userId}")
    public double getAverageEmissionSinceCreation(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getAverageEmissionSinceCreation(userId);
    }

    @GetMapping("/max-since-creation/{userId}")
    public double getMaxEmissionSinceCreation(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getMaxEmissionSinceCreation(userId);
    }

    @GetMapping("/min-since-creation/{userId}")
    public double getMinEmissionSinceCreation(@PathVariable String userId) { // Changed Long to String
        return userStatsService.getMinEmissionSinceCreation(userId);
    }

    //////
    // Endpoints for daily emissions of the current week
    @GetMapping("/emission-monday/{userId}")
    public double getMondayEmission(@PathVariable String userId) {
        return userStatsService.getDailyEmission(userId, DayOfWeek.MONDAY);
    }

    @GetMapping("/emission-tuesday/{userId}")
    public double getTuesdayEmission(@PathVariable String userId) {
        return userStatsService.getDailyEmission(userId, DayOfWeek.TUESDAY);
    }

    @GetMapping("/emission-wednesday/{userId}")
    public double getWednesdayEmission(@PathVariable String userId) {
        return userStatsService.getDailyEmission(userId, DayOfWeek.WEDNESDAY);
    }

    @GetMapping("/emission-thursday/{userId}")
    public double getThursdayEmission(@PathVariable String userId) {
        return userStatsService.getDailyEmission(userId, DayOfWeek.THURSDAY);
    }

    @GetMapping("/emission-friday/{userId}")
    public double getFridayEmission(@PathVariable String userId) {
        return userStatsService.getDailyEmission(userId, DayOfWeek.FRIDAY);
    }

    @GetMapping("/emission-saturday/{userId}")
    public double getSaturdayEmission(@PathVariable String userId) {
        return userStatsService.getDailyEmission(userId, DayOfWeek.SATURDAY);
    }

    @GetMapping("/emission-sunday/{userId}")
    public double getSundayEmission(@PathVariable String userId) {
        return userStatsService.getDailyEmission(userId, DayOfWeek.SUNDAY);
    }


}