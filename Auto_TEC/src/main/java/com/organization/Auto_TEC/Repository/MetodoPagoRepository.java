package com.organization.Auto_TEC.Repository;

import com.organization.Auto_TEC.Entities.pagoMetodo;
import org.springframework.data.jpa.repository.JpaRepository;

// Al extender JpaRepository, automáticamente obtienes
// findAll(), findById(), save(), y deleteById().
public interface MetodoPagoRepository extends JpaRepository<pagoMetodo, Long> {


}