


CREATE TABLE cards (
                       id SERIAL PRIMARY KEY,
                       card_number VARCHAR(255) NOT NULL,
                       expiration_date DATE NOT NULL,
                       card_type VARCHAR(50) NOT NULL,
                       balance NUMERIC(15, 2) NOT NULL,
                       created_at DATE NOT NULL,
                       user_id INTEGER,
                       FOREIGN KEY (user_id) REFERENCES users(id)
);
