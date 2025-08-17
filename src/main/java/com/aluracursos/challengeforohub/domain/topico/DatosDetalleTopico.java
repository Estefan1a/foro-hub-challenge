package com.aluracursos.challengeforohub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 LocalDateTime fechaCreacion,
                                 String autor,
                                 String curso,
                                 StatusDeTopico statusDeTopico) {

    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getStatusDeTopico()
        );
    }
}
