package com.example.demo.service;

import com.example.demo.model.Postulante;
import com.example.demo.repository.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostulanteService {

    @Autowired
    private PostulanteRepository postulanteRepository;

    public List<Postulante> getAllPostulantes() {
        return postulanteRepository.findAll();
    }

    public Optional<Postulante> getPostulanteByCedula(int nro_cedula) {
        return postulanteRepository.findByNroCedula(nro_cedula);
    }

    public Postulante saveOrUpdatePostulante(Postulante postulante) {
        return postulanteRepository.save(postulante);
    }

    public void deletePostulante(Long id) {
        if (postulanteRepository.existsById(id)) {
            postulanteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Postulante con ID " + id + " no encontrado.");
        }
    }
}

