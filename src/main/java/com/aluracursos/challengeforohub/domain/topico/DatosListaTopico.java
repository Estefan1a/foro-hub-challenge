package com.aluracursos.challengeforohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListaTopico(Long id,
                               String titulo,
                               String mensaje,
                               LocalDateTime fechaCreacion,
                               StatusDeTopico statusDeTopico,
                               String autor,
                               String curso) {

    public DatosListaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatusDeTopico(),
                topico.getAutor(),
                topico.getCurso());
    }
}
