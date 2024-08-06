package com.morxz.eco_trace.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDTO {
    // Getters et Setters
    private String id; // UID provenant de l'authentification avec Firebase
    private String username;
    private String email;
    private String phoneNumber;
    private String profilePicture;
    private List<TripDTO> trips; // Liste des voyages associés à l'utilisateur

    // Constructeur par défaut
    public UserDTO() {
    }

    // Constructeur avec tous les champs
    public UserDTO(String id, String username, String email, String phoneNumber, String profilePicture, List<TripDTO> trips) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePicture = profilePicture;
        this.trips = trips;
    }

}
