package com.api.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.blog.dto.request.ComentarioRequestDto;
import com.api.blog.dto.response.ComentarioResponseDto;
import com.api.blog.mapper.ComentarioMapper;
import com.api.blog.model.ComentarioModel;
import com.api.blog.repository.ComentarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.api.blog.dto.request.PostRequestDto;
import com.api.blog.dto.response.PostResponseDto;
import com.api.blog.mapper.PostMapper;
import com.api.blog.model.PostModel;
import com.api.blog.repository.PostRepository;

//regras de negocio podem serem colocadas nessa classe de serviço
//ela serve como uma camada intermediaria entre o controler e repository
//diminuir o acoplamento

@Service
public class PostServiceImpl implements PostService {

    private final ComentarioRepository comentarioRepository;
    private final ComentarioMapper comentarioMapper;
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostServiceImpl(ComentarioRepository comentarioRepository, ComentarioMapper comentarioMapper,
                           PostRepository postRepository, PostMapper postMapper) {
        this.comentarioRepository = comentarioRepository;
        this.comentarioMapper = comentarioMapper;
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponseDto> findAll() {
        List<PostModel> posts = postRepository.findAll();
        List<PostResponseDto> dtos = new ArrayList<>();

        for (PostModel post : posts) {
            dtos.add(postMapper.toDto(post));
        }
        return dtos;
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponseDto findById(UUID id) {
        Optional<PostModel> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            throw new RuntimeException("Post não encontrado com o ID: " + id);
        }

        PostModel post = optionalPost.get();
        return postMapper.toDto(post);
    }

    @Override
    @Transactional
    public PostResponseDto createPost(PostRequestDto dto) {
        PostModel post = postMapper.toEntity(dto);
        PostModel saved = postRepository.save(post);
        return postMapper.toDto(saved);
    }

    @Override
    @Transactional
    public PostResponseDto updatePost(UUID id, PostRequestDto dto) {
        Optional<PostModel> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            throw new RuntimeException("Post não encontrado com o ID: " + id);
        }

        PostModel post = optionalPost.get();
        postMapper.updateEntityFromDto(dto, post);

        PostModel updatedPost = postRepository.save(post);
        return postMapper.toDto(updatedPost);
    }

    @Override
    @Transactional
    public void deletePost(UUID id) {
        Optional<PostModel> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            throw new RuntimeException("Post não encontrado com o ID: " + id);
        }

        PostModel post = optionalPost.get();
        postRepository.delete(post);
    }
    @Override
    @Transactional
    public ComentarioResponseDto addComentario(UUID postId, ComentarioRequestDto dto){
        Optional<PostModel> optionalPost = postRepository.findById(postId);
        PostModel post = optionalPost.get();
        ComentarioModel comentario = new ComentarioModel(dto.comentario(), post);
        post.adicionarComentario(comentario);
        ComentarioModel saved = comentarioRepository.save(comentario);
        return comentarioMapper.toDto(saved);

    }

}