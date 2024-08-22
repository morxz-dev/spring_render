package com.morxz.eco_trace.repo;

import com.morxz.eco_trace.models.Trip;
import com.morxz.eco_trace.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByUserId(String id); // No change needed

    List<Trip> findByUser(User user); // No change needed

    @Modifying
    @Transactional
    @Query("DELETE FROM Trip t WHERE t.user.id = :userId")
    void deleteByUserId(@Param("userId") String userId); // No change needed

    Optional<Trip> findByIdAndUserId(Long id, String userId); // No change needed

    @Query("SELECT SUM(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date = :date")
    Double findDailyEmissionForUser(@Param("userId") String userId, @Param("date") LocalDate date); // Changed Long to String

    @Query("SELECT SUM(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date >= :startDate AND t.date <= :endDate")
    Double findTotalEmissionForUserBetweenDates(@Param("userId") String userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate); // Changed Long to String

    @Query("SELECT AVG(t.carbonEmission) FROM Trip t WHERE t.date >= :startDate AND t.date <= :endDate")
    Double findAverageEmissionForAllUsersBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate); // No change needed

    @Query("SELECT MAX(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date >= :startDate AND t.date <= :endDate")
    Double findMaxEmissionForUserBetweenDates(@Param("userId") String userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate); // Changed Long to String

    @Query("SELECT MIN(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date >= :startDate AND t.date <= :endDate")
    Double findMinEmissionForUserBetweenDates(@Param("userId") String userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate); // Changed Long to String

    @Query("SELECT AVG(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date >= :startDate AND t.date <= :endDate")
    Double findAverageEmissionForUserBetweenDates(@Param("userId") String userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate); // Changed Long to String

    @Query("SELECT SUM(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId")
    Double findTotalEmissionForUser(@Param("userId") String userId); // Changed Long to String

    // New methods
    @Query("SELECT AVG(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId")
    Double findAverageEmissionForUser(@Param("userId") String userId); // Changed Long to String

    @Query("SELECT MAX(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId")
    Double findMaxEmissionForUser(@Param("userId") String userId); // Changed Long to String

    @Query("SELECT MIN(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId")
    Double findMinEmissionForUser(@Param("userId") String userId); // Changed Long to String
}