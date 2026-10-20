package com.api.blog_api.repository;

import com.api.blog_api.model.PostModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {

    Page<PostModel> findByTituloContainingIgnoreCase(
            String titulo,
            Pageable pageable
    );
}