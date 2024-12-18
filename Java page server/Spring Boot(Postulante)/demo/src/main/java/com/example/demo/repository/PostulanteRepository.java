package com.example.demo.repository;

import com.example.demo.model.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulante, Long> {
    Optional<Postulante> findByNroCedula(int nro_cedula);
}

