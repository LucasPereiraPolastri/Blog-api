ALTER TABLE tb_comentario
    CHANGE COLUMN texto comentario TEXT NOT NULL,
    ADD COLUMN data DATE NOT NULL AFTER id;