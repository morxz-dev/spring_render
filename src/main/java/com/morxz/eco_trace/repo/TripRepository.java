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
    List<Trip> findByUserId(String id);

    List<Trip> findByUser(User user);
    @Modifying
    @Transactional
    @Query("DELETE FROM Trip t WHERE t.user.id = :userId")
    void deleteByUserId(@Param("userId") String userId);
    Optional<Trip> findByIdAndUserId(Long id, String userId);

    @Query("SELECT SUM(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date = :date")
    Double findDailyEmissionForUser(@Param("userId") Long userId, @Param("date") LocalDate date);

    @Query("SELECT SUM(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date >= :startDate AND t.date <= :endDate")
    Double findTotalEmissionForUserBetweenDates(@Param("userId") Long userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT AVG(t.carbonEmission) FROM Trip t WHERE t.date >= :startDate AND t.date <= :endDate")
    Double findAverageEmissionForAllUsersBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT MAX(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date >= :startDate AND t.date <= :endDate")
    Double findMaxEmissionForUserBetweenDates(@Param("userId") Long userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT MIN(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date >= :startDate AND t.date <= :endDate")
    Double findMinEmissionForUserBetweenDates(@Param("userId") Long userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT AVG(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId AND t.date >= :startDate AND t.date <= :endDate")
    Double findAverageEmissionForUserBetweenDates(@Param("userId") Long userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT SUM(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId")
    Double findTotalEmissionForUser(@Param("userId") Long userId);

    // New methods
    @Query("SELECT AVG(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId")
    Double findAverageEmissionForUser(@Param("userId") Long userId);

    @Query("SELECT MAX(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId")
    Double findMaxEmissionForUser(@Param("userId") Long userId);

    @Query("SELECT MIN(t.carbonEmission) FROM Trip t WHERE t.user.id = :userId")
    Double findMinEmissionForUser(@Param("userId") Long userId);
}
