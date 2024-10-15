CREATE DATABASE clinica_medica;

USE clinica_medica;

CREATE TABLE administrador (
    login VARCHAR(100) PRIMARY KEY,
    senha VARCHAR(100)
);

CREATE TABLE Paciente (
    idPaciente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(15) UNIQUE,
    endereco VARCHAR(100),
    Email VARCHAR(100)
);

CREATE TABLE Medico (
    idMedico INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(15) UNIQUE,
    especialidade VARCHAR(100),
    email VARCHAR(100),
    sexo VARCHAR(50)
);

CREATE TABLE Agenda (
    idAgenda INT AUTO_INCREMENT PRIMARY KEY,
    procedimento VARCHAR(50),
    horario VARCHAR(50),
    data VARCHAR(50),
    id_Medico INT,
    id_Paciente INT,
    FOREIGN KEY (id_Medico) REFERENCES Medico(idMedico),
    FOREIGN KEY (id_Paciente) REFERENCES Paciente(idPaciente)
);

INSERT INTO administrador (login, senha) VALUES ('admin', 'admin');


SELECT * FROM paciente;
SELECT * FROM administrador;
SELECT * FROM agenda;
SELECT * FROM medico;






