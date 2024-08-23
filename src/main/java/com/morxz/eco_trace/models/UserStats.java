package com.morxz.eco_trace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalCarbonEmission;
    private double averageCarbonEmission;
    private double maxEmission;
    private double minEmission;
    private double weeklyChange;
    private double monthlyChange;
    private double yearlyChange;

    // New field for weekly emissions
    private double sundayEmission;
    private double mondayEmission;
    private double tuesdayEmission;
    private double wednesdayEmission;
    private double thursdayEmission;
    private double fridayEmission;
    private double saturdayEmission;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
