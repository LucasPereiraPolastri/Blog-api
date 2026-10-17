CREATE TABLE tb_comentario (
    id BINARY(16) NOT NULL AUTO_INCREMENT,
    texto TEXT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    post_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_comentario_post
        FOREIGN KEY (post_id)
        REFERENCES tb_post(id)
);