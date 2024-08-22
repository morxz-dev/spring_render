package com.morxz.eco_trace.controllers;

import com.morxz.eco_trace.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-stats")
public class UserStatsController {

    @Autowired
    private UserStatsService userStatsService;

    @GetMapping("/day/{userId}")
    public double getCurrentDayEmission(@PathVariable Long userId) {
        return userStatsService.getCurrentDayEmission(userId);
    }

    @GetMapping("/previous-day/{userId}")
    public double getPreviousDayEmission(@PathVariable Long userId) {
        return userStatsService.getPreviousDayEmission(userId);
    }

    @GetMapping("/week-max/{userId}")
    public double getCurrentWeekMaxEmission(@PathVariable Long userId) {
        return userStatsService.getCurrentWeekMaxEmission(userId);
    }

    @GetMapping("/week-min/{userId}")
    public double getCurrentWeekMinEmission(@PathVariable Long userId) {
        return userStatsService.getCurrentWeekMinEmission(userId);
    }

    @GetMapping("/week-average/{userId}")
    public double getCurrentWeekAverageEmission(@PathVariable Long userId) {
        return userStatsService.getCurrentWeekAverageEmission(userId);
    }

    @GetMapping("/total-since-creation/{userId}")
    public double getTotalEmissionSinceCreation(@PathVariable Long userId) {
        return userStatsService.getTotalEmissionSinceCreation(userId);
    }

    @GetMapping("/average-emission-for-all-users")
    public double getAverageEmissionForAllUsers() {
        return userStatsService.getAverageEmissionForAllUsers();
    }

    // New endpoints
    @GetMapping("/average-since-creation/{userId}")
    public double getAverageEmissionSinceCreation(@PathVariable Long userId) {
        return userStatsService.getAverageEmissionSinceCreation(userId);
    }

    @GetMapping("/max-since-creation/{userId}")
    public double getMaxEmissionSinceCreation(@PathVariable Long userId) {
        return userStatsService.getMaxEmissionSinceCreation(userId);
    }

    @GetMapping("/min-since-creation/{userId}")
    public double getMinEmissionSinceCreation(@PathVariable Long userId) {
        return userStatsService.getMinEmissionSinceCreation(userId);
    }
}
