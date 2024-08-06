package com.morxz.eco_trace.controllers;

import com.morxz.eco_trace.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-stats")
public class UserStatsController {

    @Autowired
    private UserStatsService userStatsService;

    @GetMapping("/current-day-emission/{userId}")
    public double getCurrentDayEmission(@PathVariable Long userId) {
        return userStatsService.getCurrentDayEmission(userId);
    }

    @GetMapping("/previous-day-emission/{userId}")
    public double getPreviousDayEmission(@PathVariable Long userId) {
        return userStatsService.getPreviousDayEmission(userId);
    }

    @GetMapping("/current-week-max-emission/{userId}")
    public double getCurrentWeekMaxEmission(@PathVariable Long userId) {
        return userStatsService.getCurrentWeekMaxEmission(userId);
    }

    @GetMapping("/current-week-min-emission/{userId}")
    public double getCurrentWeekMinEmission(@PathVariable Long userId) {
        return userStatsService.getCurrentWeekMinEmission(userId);
    }

    @GetMapping("/current-week-average-emission/{userId}")
    public double getCurrentWeekAverageEmission(@PathVariable Long userId) {
        return userStatsService.getCurrentWeekAverageEmission(userId);
    }

    @GetMapping("/total-emission-since-creation/{userId}")
    public double getTotalEmissionSinceCreation(@PathVariable Long userId) {
        return userStatsService.getTotalEmissionSinceCreation(userId);
    }

    @GetMapping("/average-emission-for-all-users")
    public double getAverageEmissionForAllUsers() {
        return userStatsService.getAverageEmissionForAllUsers();
    }

    // New endpoints
    @GetMapping("/average-emission-since-creation/{userId}")
    public double getAverageEmissionSinceCreation(@PathVariable Long userId) {
        return userStatsService.getAverageEmissionSinceCreation(userId);
    }

    @GetMapping("/max-emission-since-creation/{userId}")
    public double getMaxEmissionSinceCreation(@PathVariable Long userId) {
        return userStatsService.getMaxEmissionSinceCreation(userId);
    }

    @GetMapping("/min-emission-since-creation/{userId}")
    public double getMinEmissionSinceCreation(@PathVariable Long userId) {
        return userStatsService.getMinEmissionSinceCreation(userId);
    }
}
