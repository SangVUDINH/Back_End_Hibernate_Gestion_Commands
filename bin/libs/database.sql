-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------

DROP DATABASE IF EXISTS OneToOne;
CREATE DATABASE OneToOne;
USE OneToOne;


-- -----------------------------------------------------------------------------
-- - Construction de la table des informations utilisateurs                  ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_UserInformations (
    idInformations      int    PRIMARY KEY AUTO_INCREMENT,
    address             text,
    city                text,
    email               text,
    phoneNumber         text
);

INSERT INTO T_UserInformations (address, city, email, phoneNumber) 
VALUES ( 'Inconnue', 'La matrice', 'neo@matrix.com', '1234567890' ),
       ( 'rue du Faucon', 'L''étoile noire', 'luke@glaforce.wars', '0147258369' ),
       ( '1997, Manhattan', 'New York', 'snake@carpenter.com', '9638527410' ),
       ( 'Nostromo', 'La bas', 'ripley@nostromo.alien', '9876543210' ),
       ( 'SIS Building', 'London', '007@mi6.uk', '7007007007' );

SELECT * FROM T_UserInformations;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Users (
    idUser              int         PRIMARY KEY AUTO_INCREMENT,
    login               varchar(20) NOT NULL,
    password            varchar(20) NOT NULL,
    connectionNumber    int         NOT NULL DEFAULT 0,
    idUserInformations  int         UNIQUE NOT NULL REFERENCES T_UserInformations(idInformations)
);

INSERT INTO T_Users (login, password, idUserInformations) 
VALUES ( 'Anderson',    'Neo', 1 ),
       ( 'Skywalker',   'Luke', 2 ),
       ( 'Plissken',    'Snake', 3 ),
       ( 'Ripley',      'Ellen', 4 ),
       ( 'Bond',        'James', 5 );

SELECT * FROM T_Users;