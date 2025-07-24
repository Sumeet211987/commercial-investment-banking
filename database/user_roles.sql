--
-- User Roles Table
--

CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role VARCHAR(255),

    CONSTRAINT fk_user FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


INSERT INTO user_roles VALUES (1, 'ROLE_USER');
INSERT INTO user_roles VALUES (2, 'ROLE_ADMIN');
