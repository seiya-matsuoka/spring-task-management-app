create table tasks (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    summary VARCHAR(256) NOT NULl,
    description VARCHAR(256) NOT NULl,
    priority INT NOT NULl,
    created_at timestamp without time zone
);