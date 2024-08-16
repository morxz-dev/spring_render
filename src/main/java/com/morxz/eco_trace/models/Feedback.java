package com.morxz.eco_trace.models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "feedbacks")
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String content;
}
