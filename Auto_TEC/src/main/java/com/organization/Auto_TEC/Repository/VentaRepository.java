package com.organization.Auto_TEC.Repository;

import com.organization.Auto_TEC.Entities.ventasEntitie;
import com.organization.Auto_TEC.Entities.ventaEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VentaRepository extends JpaRepository<ventasEntitie, Long> {

    List<ventasEntitie> findByEstado(ventaEstado estado);
}