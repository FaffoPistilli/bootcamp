CREATE TABLE usuarios (
                          id INT PRIMARY KEY,
                          username VARCHAR(100),
                          email VARCHAR(100),
                          role VARCHAR(50),
                          created_at TIMESTAMP
);

CREATE TABLE posts (
                       id INT PRIMARY KEY,
                       titulo VARCHAR(255),
                       mensaje TEXT,
                       user_id INT,
                       estado VARCHAR(50),
                       created_at TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES usuarios(id),
);
COMMENT ON COLUMN posts.mensaje IS 'Comentario sobre un post';

CREATE TABLE comentarios (
                             id INT PRIMARY KEY,
                             comentarios TEXT,
                             user_id INT,
                             post_id INT,
                             estado VARCHAR(30),
                             created_at TIMESTAMP,
                             FOREIGN KEY (user_id) REFERENCES usuarios(id),
                             FOREIGN KEY (post_id) REFERENCES posts(id),
);
COMMENT ON COLUMN comentarios.comentarios IS 'Comentario sobre un post';

CREATE TABLE seguidores (
                            seguidor_user_id INT,
                            seguido_user_id INT,
                            created_at TIMESTAMP,
                            PRIMARY KEY (seguidor_user_id, seguido_user_id),
                            FOREIGN KEY (seguidor_user_id) REFERENCES usuarios(id),
                            FOREIGN KEY (seguido_user_id) REFERENCES usuarios(id)
);