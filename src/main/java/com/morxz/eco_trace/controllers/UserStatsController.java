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
    public double getCurrentDayEmission(@PathVariable String userId) {
        return userStatsService.getCurrentDayEmission(userId);
    }

    @GetMapping("/previous-day/{userId}")
    public double getPreviousDayEmission(@PathVariable String userId) {
        return userStatsService.getPreviousDayEmission(userId);
    }

    @GetMapping("/week-max/{userId}")
    public double getCurrentWeekMaxEmission(@PathVariable String userId) {
        return userStatsService.getCurrentWeekMaxEmission(userId);
    }

    @GetMapping("/week-min/{userId}")
    public double getCurrentWeekMinEmission(@PathVariable String userId) {
        return userStatsService.getCurrentWeekMinEmission(userId);
    }

    @GetMapping("/week-average/{userId}")
    public double getCurrentWeekAverageEmission(@PathVariable String userId) {
        return userStatsService.getCurrentWeekAverageEmission(userId);
    }

    @GetMapping("/total-since-creation/{userId}")
    public double getTotalEmissionSinceCreation(@PathVariable String userId) {
        return userStatsService.getTotalEmissionSinceCreation(userId);
    }

    @GetMapping("/average-emission-for-all-users")
    public double getAverageEmissionForAllUsers() {
        return userStatsService.getAverageEmissionForAllUsers();
    }

    @GetMapping("/average-since-creation/{userId}")
    public double getAverageEmissionSinceCreation(@PathVariable String userId) {
        return userStatsService.getAverageEmissionSinceCreation(userId);
    }

    @GetMapping("/max-since-creation/{userId}")
    public double getMaxEmissionSinceCreation(@PathVariable String userId) {
        return userStatsService.getMaxEmissionSinceCreation(userId);
    }

    @GetMapping("/min-since-creation/{userId}")
    public double getMinEmissionSinceCreation(@PathVariable String userId) {
        return userStatsService.getMinEmissionSinceCreation(userId);
    }
}
