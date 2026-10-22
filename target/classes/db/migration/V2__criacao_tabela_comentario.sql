CREATE TABLE tb_comentario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    comentario TEXT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    data DATE NOT NULL,              -- ← coluna que faltava
    post_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_comentario_post
        FOREIGN KEY (post_id)
        REFERENCES tb_post(id)
);