CREATE TABLE IF NOT EXISTS REPORT(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR NOT NULL,
    subject VARCHAR(50) NOT NULL,
    message VARCHAR NOT NULL
);