package com.api.blog_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_comentario")
public class ComentarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comentario;

    @Column(nullable = false)
    private String autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private PostModel post;

    public ComentarioModel() {}

    public ComentarioModel(String comentario, String autor, PostModel post) {
        this.comentario = comentario;
        this.autor = autor;
        this.post = post;
        this.data = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }
}