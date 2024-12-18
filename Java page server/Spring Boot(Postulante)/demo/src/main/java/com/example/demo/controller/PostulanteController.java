package com.example.demo.controller;

import com.example.demo.model.Postulante;
import com.example.demo.service.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteService postulanteService;

    @GetMapping
    public List<Postulante> getPostulantes() {
        return postulanteService.getAllPostulantes();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Postulante> getPostulanteByCedula(@PathVariable int cedula) {
        Optional<Postulante> postulante = postulanteService.getPostulanteByCedula(cedula);
        return postulante.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Postulante savePostulante(@RequestBody Postulante postulante) {
        return postulanteService.saveOrUpdatePostulante(postulante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostulante(@PathVariable Long id) {
        try {
            postulanteService.deletePostulante(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
