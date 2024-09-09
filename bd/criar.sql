CREATE TABLE USER (
    id_user INTEGER NOT NULL,
    name VARCHAR(55) NOT NULL,
    username VARCHAR(70) UNIQUE NOT NULL,
    password CHAR(11) NOT NULL,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT null,
    PRIMARY KEY (id_user)
);

CREATE TABLE TASK (
    id_task INTEGER NOT NULL PRIMARY KEY,
    title VARCHAR(50),
    description TEXT,
    start_at TIMESTAMP,
    end_at TIMESTAMP,
    priority VARCHAR(6),
    id_user INTEGER,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_priority CHECK (priority IN ('BAIXA', 'MEDIA', 'ALTA')),
    CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES cecilia_schema.USER(id_user)
);

DROP TABLE cecilia_schema."USER" ;
