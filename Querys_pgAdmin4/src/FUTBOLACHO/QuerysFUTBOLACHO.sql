CREATE TABLE fases (
	idfase INT PRIMARY KEY,
	nombre_fase VARCHAR(30)
	
);

CREATE TABLE grupos (
	idgrupo INT PRIMARY KEY,
	nombre_grupo VARCHAR(30)
	
);

CREATE TABLE equipos (
    idequipo INT PRIMARY KEY,
    nombre_equipo VARCHAR(100),
    pais VARCHAR(100),
    idgrupo INT,
    FOREIGN KEY (idgrupo) REFERENCES grupos(idgrupo)
);

CREATE TABLE partidos (
	idpartido INT PRIMARY KEY,
	idfase INT,
	FOREIGN KEY (idfase) REFERENCES fases(idfase)

);

CREATE TABLE partido_equipo (
	idpartido INT,
	idequipo INT,
	resultado VARCHAR(10),
	PRIMARY KEY (idpartido, idequipo),
    FOREIGN KEY (idpartido) REFERENCES partidos(idpartido),
    FOREIGN KEY (idequipo) REFERENCES equipos(idequipo)
);

CREATE TABLE jugadores (
    idjugador INT PRIMARY KEY,
    nombre_jugador VARCHAR(100),
    nacionalidad VARCHAR(100),
    idequipo INT,
    FOREIGN KEY (idequipo) REFERENCES equipos(idequipo)
);