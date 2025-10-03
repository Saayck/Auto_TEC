package com.organization.Auto_TEC.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.organization.Auto_TEC.Entities.administradorEntitie;

@Repository
public interface AdministradorRepository extends JpaRepository<administradorEntitie, Long> {
    Optional<administradorEntitie> findByEmail(String email);
    Optional<administradorEntitie> findByUsername(String username);
    Optional<administradorEntitie> findByUsernameOrEmail(String username, String email);
}
