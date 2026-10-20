package com.api.blog_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ComentarioRequestDto(

        @NotBlank(message = "{comentario.comentario.obrigatorio}")
        String comentario,

        @NotBlank(message = "{comentario.autor.obrigatorio}")
        @Size(max = 70, message = "{comentario.autor.tamanho}")
        String autor
) {}