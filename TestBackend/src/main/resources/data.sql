DROP TABLE IF EXISTS candidatos;

CREATE TABLE candidatos (
                            id INTEGER(10) PRIMARY KEY auto_increment NOT NULL,
                            nombre VARCHAR(50) NOT NULL,
                            apellido VARCHAR(50) NOT NULL,
                            tipoDocumento VARCHAR(50) NOT NULL,
                            numeroDocumento INTEGER(25) NOT NULL,
                            fechaNacimiento DATE NOT NULL
);

DROP TABLE IF EXISTS tecnologias;

CREATE TABLE tecnologias (
                             id INTEGER(10) auto_increment NOT NULL,
                             nombre VARCHAR(50) NOT NULL,
                             version INTEGER(10) NOT NULL,
                             PRIMARY KEY (id)
);

DROP TABLE IF EXISTS candidatosXtecnologias;

CREATE TABLE candidatosXtecnologias (
                                        id INTEGER(10) PRIMARY KEY auto_increment NOT NULL,
                                        idCandidato INTEGER(10) NOT NULL,
                                        idTecnologia INTEGER(10) NOT NULL,
                                        anosExperiencia INTEGER(10) NOT NULL,
                                        FOREIGN KEY (idCandidato) REFERENCES candidatos(id),
                                        FOREIGN KEY (idTecnologia) REFERENCES tecnologias(id)
);



