package com.morxz.eco_trace.repo;

import com.morxz.eco_trace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Ajoutez ici vos méthodes personnalisées si nécessaire
}
