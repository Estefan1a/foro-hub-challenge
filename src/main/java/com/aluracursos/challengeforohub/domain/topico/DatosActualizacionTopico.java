package com.aluracursos.challengeforohub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(@NotNull Long id,
                                       String titulo,
                                       String mensaje,
                                       String curso) {
}
