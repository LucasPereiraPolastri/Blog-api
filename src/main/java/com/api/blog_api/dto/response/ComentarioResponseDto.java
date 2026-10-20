package com.api.blog_api.dto.response;

import java.time.LocalDate;

public record ComentarioResponseDto(
        Long id,
        LocalDate data,
        String comentario,
        String autor
) {}