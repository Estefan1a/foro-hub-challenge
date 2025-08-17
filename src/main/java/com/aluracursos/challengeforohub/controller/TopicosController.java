package com.aluracursos.challengeforohub.controller;

import com.aluracursos.challengeforohub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository repository;
    
    //CREAR UN NUEVO TÓPICO
    @Transactional
    @PostMapping
    public ResponseEntity<String> crearTopico(@RequestBody @Valid DatosCrearTopico datos) {

        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            // Si ya existe un tópico con mismo título y mensaje
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un tópico con el mismo título y mensaje.");
        }

        Topico topico = new Topico(datos);
        repository.save(topico);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tópico creado exitosamente");
    }

    //LISTAR TÓPICOS POR FECHA Y MUESTRA DE A 10 POR PÁGINA
    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listar(@PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion){
        var page = repository.findAllByStatusDeTopico(StatusDeTopico.ACTIVO, paginacion).map(DatosListaTopico::new);

        return ResponseEntity.ok(page);
    }

    //BUSCAR DETALLE DE TÓPICO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(topico -> ResponseEntity.ok(new DatosDetalleTopico(topico)))
                .orElse(ResponseEntity.notFound().build());
    }

    //ACTUALIZAR DATOS DE TOPICO
    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        var topico = repository.getReferenceById(datos.id());
        topico.actualizarInformaciones(datos);
    }

    //ELIMINAR TÓPICOS TOTALMENTE
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.eliminar();
        return ResponseEntity.noContent().build();
    }

}
