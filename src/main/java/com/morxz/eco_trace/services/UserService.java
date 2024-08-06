package com.morxz.eco_trace.services;

import com.morxz.eco_trace.dtos.UserDTO;
import com.morxz.eco_trace.models.User;

import com.morxz.eco_trace.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }



    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User updateUser(String id, User user) {
        User existingUser = getUserById(id);
        // Mettre à jour les champs de l'utilisateur existant avec les nouvelles valeurs
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setProfilePicture(user.getProfilePicture());
        return userRepository.save(existingUser);
    }

    public void deleteUser(String id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    private User mapToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setProfilePicture(userDTO.getProfilePicture());
        // Mapper les trips, dashboard et userStats si nécessaires
        return user;
    }

    private UserDTO mapToDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setProfilePicture(user.getProfilePicture());
        // Ajouter les autres champs si nécessaires
        return userDTO;
    }

}
