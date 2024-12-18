package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "postulante")
public class Postulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int nro_cedula;
    private String correo;
    private String telefono;
    private String direccion;
    private boolean experiencia_laboral;
    private boolean estudio_universitario;
    private boolean notebook;
    private boolean aceptado;

    @Column(name = "bootcamp_id")
    private Long bootcamp_id;

    public Postulante() {}

    public Postulante(String nombre, String apellido, int nro_cedula, String correo, String telefono,
                      String direccion, boolean experiencia_laboral, boolean estudio_universitario,
                      boolean notebook, boolean aceptado, Long bootcamp_id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nro_cedula = nro_cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.experiencia_laboral = experiencia_laboral;
        this.estudio_universitario = estudio_universitario;
        this.notebook = notebook;
        this.aceptado = aceptado;
        this.bootcamp_id = bootcamp_id;
    }
}
