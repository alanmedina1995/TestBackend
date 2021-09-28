package com.mobydigital.alanmedina.testBackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TestBackendApplication implements CommandLineRunner {

	private JdbcTemplate template;

	public static void main(String[] args) {

		SpringApplication.run(TestBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("DROP TABLE candidatos IF EXISTS");
		template.execute("CREATE TABLE candidatos(id INTEGER(10) PRIMARY KEY auto_increment NOT NULL, nombre VARCHAR(50) NOT NULL, apellido VARCHAR(50) NOT NULL, tipoDocumento VARCHAR(50) NOT NULL, numeroDocumento INTEGER(25) NOT NULL, fechaNacimiento DATE NOT NULL");
		template.execute("DROP TABLE tecnologias IF EXISTS");
		template.execute("CREATE TABLE tecnologias(id INTEGER(10) PRIMARY KEY auto_increment NOT NULL, nombre VARCHAR(50) NOT NULL), version DOUBLE(50) NOT NULL");
		template.execute("DROP TABLE candidatosXtecnologias IF EXISTS");
		template.execute("CREATE TABLE candidatosXtecnologias(id INTEGER(10) PRIMARY KEY auto_increment NOT NULL, idCandidato INTEGER(10) FOREIGN KEY REFERENCES candidatos(id) NOT NULL, idTecnologia INTEGER(10) FOREIGN KEY REFERENCES tecnologias(id) NOT NULL, anosExperiencia INTEGER(10) NOT NULL)");



	}
}
