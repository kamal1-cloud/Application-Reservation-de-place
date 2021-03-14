-- -- -- -- -- Role Table

CREATE TABLE Role
(
    idRole SERIAL,
    roleNom varchar(20) NOT NULL,
    PRIMARY KEY (idrole)
);
-- -- -- -- -- Utilisateur Table

CREATE TABLE Users
(
    idUser BIGSERIAL NOT NULL,
    nom varchar(20) NOT NULL,
    prenom varchar(25) NOT NULL,
    cin varchar(10) NOT NULL,
    email varchar(100) NOT NULL,
    password varchar(255) NOT NULL,
    currentdate timestamp ,
    idRole bigint,
    PRIMARY KEY (idUser),
	FOREIGN KEY(idRole) REFERENCES Role(idRole) ON UPDATE CASCADE
);
-- -- -- -- --  Admin Table

CREATE TABLE Admin
(
    idAdmin BIGSERIAL ,
    iduser bigint,
    PRIMARY KEY (idAdmin),
	FOREIGN KEY(idUser) REFERENCES Users(idUser) ON DELETE CASCADE
);

-- -- -- -- --  Apprenant Table

CREATE TABLE Apprenant
(
    idApprenant BIGSERIAL,
    status boolean,
    nDeReservation integer default 3,
    iduser bigint,
    PRIMARY KEY (idapprenant),
	FOREIGN KEY(idUser) REFERENCES Users(idUser) ON DELETE CASCADE
);

-- -- -- -- -- TypeReservation Table

CREATE TABLE TypeReservation(
	idType SERIAL,
	typeNom varchar(30),
	nombreDePlace integer,
	PRIMARY KEY (idType)
);

-- -- -- -- -- Reservation Table

CREATE TABLE Reservation
(
    idReservation BIGSERIAL,
    currentdate timestamp,
    Status boolean,
    idApprenant bigint,
	idType bigint,
    PRIMARY KEY (idReservation),
	FOREIGN KEY(idApprenant) REFERENCES Apprenant(idApprenant) ON UPDATE CASCADE,
	FOREIGN KEY(idType) REFERENCES TypeReservation(idType) ON UPDATE CASCADE
);
