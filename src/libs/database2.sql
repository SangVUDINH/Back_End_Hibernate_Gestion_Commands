-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------

DROP DATABASE IF EXISTS ManyToOne;
CREATE DATABASE ManyToOne;
USE ManyToOne;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Users (
    idUser              int         PRIMARY KEY AUTO_INCREMENT,
    login               varchar(20) NOT NULL,
    password            varchar(20) NOT NULL,
    connectionNumber    int         NOT NULL DEFAULT 0
);

INSERT INTO T_Users (login, password) 
VALUES ( 'Anderson',    'Neo' ),
       ( 'Skywalker',   'Luke' ),
       ( 'Plissken',    'Snake' ),
       ( 'Ripley',      'Ellen' ),
       ( 'Bond',        'James' );

SELECT * FROM T_Users;

-- -----------------------------------------------------------------------------
-- - Construction de la table des commandes                                 ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Commands (
    idCommand       int         PRIMARY KEY AUTO_INCREMENT,
    idUser          int         NOT NULL REFERENCES T_Users(IdUser),
    commandDate     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO T_Commands (idUser)
VALUES (1), (2), (1);

SELECT * FROM T_Commands;