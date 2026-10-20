package com.api.blog_api.mapper;

import com.api.blog_api.dto.request.ComentarioRequestDto;
import com.api.blog_api.dto.response.ComentarioResponseDto;
import com.api.blog_api.model.ComentarioModel;
import com.api.blog_api.model.PostModel;
import org.springframework.stereotype.Component;

@Component
public class ComentarioMapper {

    public ComentarioModel toEntity(ComentarioRequestDto dto, PostModel post) {
        if (dto == null) {
            return null;
        }
        return new ComentarioModel(
                dto.comentario(),
                dto.autor(),      // ← precisa existir no RequestDto
                post
        );
    }

    public ComentarioResponseDto toDto(ComentarioModel entity) {
        if (entity == null) {
            return null;
        }
        return new ComentarioResponseDto(
                entity.getId(),
                entity.getData(),
                entity.getComentario(),
                entity.getAutor()   // ← precisa existir no ResponseDto
        );
    }
}