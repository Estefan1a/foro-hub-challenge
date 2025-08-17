package com.aluracursos.challengeforohub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion=LocalDateTime.now();
    private String autor;
    private String curso;

    @Enumerated(EnumType.STRING)
    private StatusDeTopico statusDeTopico = StatusDeTopico.ACTIVO;

    public Topico(DatosCrearTopico datos) {
        this.id=null;
        this.titulo=datos.titulo();
        this.mensaje=datos.mensaje();
        this.fechaCreacion=LocalDateTime.now();
        this.statusDeTopico=StatusDeTopico.ACTIVO;
        this.autor=datos.autor();
        this.curso=datos.curso();
    }

    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos) {
        if(datos.titulo() != null){
            this.titulo=datos.titulo();
        }
        if(datos.mensaje() != null){
            this.mensaje=datos.mensaje();
        }
        if(datos.curso() != null){
            this.curso=datos.curso();
        }

    }

    public void eliminar() {
        this.statusDeTopico=StatusDeTopico.ELIMINADO;
    }

}
