package com.morxz.eco_trace.repo;

import com.morxz.eco_trace.models.Trip;
import com.morxz.eco_trace.models.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStatsRepository extends JpaRepository<UserStats, Long> {
    List<Trip> findByUserId(String Userid);

}
