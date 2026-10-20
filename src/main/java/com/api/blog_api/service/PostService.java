package com.api.blog_api.service;

import com.api.blog_api.dto.request.ComentarioRequestDto;
import com.api.blog_api.dto.request.PostRequestDto;
import com.api.blog_api.dto.response.ComentarioResponseDto;
import com.api.blog_api.dto.response.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Page<PostResponseDto> findAll(Pageable pageable);

    Page<PostResponseDto> findAll(Pageable pageable, String titulo);

    PostResponseDto findById(Long id);

    PostResponseDto createPost(PostRequestDto dto);

    ComentarioResponseDto addComentario(Long postId, ComentarioRequestDto dto);

    void deletePost(Long id);

    PostResponseDto updatePost(Long id, PostRequestDto dto);

    void deleteComentario(Long id);

    ComentarioResponseDto updateComentario(Long id, ComentarioRequestDto dto);
}