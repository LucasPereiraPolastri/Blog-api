CREATE TABLE tb_post (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data DATE NOT NULL,                 -- ← coluna que faltava
    titulo VARCHAR(255) NOT NULL,
    texto TEXT NOT NULL,                 -- ou conteudo, conforme a entidade
    autor VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);