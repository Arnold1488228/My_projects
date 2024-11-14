CREATE TABLE books (
                       id              BIGINT PRIMARY KEY,
                       title           VARCHAR(255) NOT NULL,
                       author          VARCHAR(255) NOT NULL,
                       publication_year INT NOT NULL,
                       genre           VARCHAR(100)
);

CREATE TABLE transactions (
                              id            BIGINT PRIMARY KEY,
                              description   VARCHAR(500),
                              amount        NUMERIC(12, 2) NOT NULL,
                              date          DATE NOT NULL,
                              book_id       BIGINT,
                              CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES books(id)
);

CREATE TABLE genres (
                        id          BIGINT PRIMARY KEY,
                        name        VARCHAR(100) NOT NULL
);

ALTER TABLE books
    ADD COLUMN genre_id BIGINT,
    ADD CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES genres(id);
