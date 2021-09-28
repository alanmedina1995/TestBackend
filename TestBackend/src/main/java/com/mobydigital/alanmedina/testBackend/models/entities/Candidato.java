package com.mobydigital.alanmedina.testBackend.models.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidatos")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name = "tipoDocumento")
    private String tipoDocumento;

    @Column (name = "numeroDocumento")
    private int numeroDocumento;

    @Column (name = "fechaNacimiento")
    private Date fechaNacimiento;





}
