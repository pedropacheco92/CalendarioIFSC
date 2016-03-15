-- -----------------------------------------------------
-- Table TipoUsuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TipoUsuario (
  idtipo INT NOT NULL UNIQUE,
  descricao VARCHAR(45) NULL,
  PRIMARY KEY (idtipo));


-- -----------------------------------------------------
-- Table Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
  cpf VARCHAR(14) NOT NULL UNIQUE,
  idtipo INT NOT NULL UNIQUE,
  email VARCHAR(45) NULL,
  senha VARCHAR(45) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (cpf, idtipo),
  CONSTRAINT fk_Usuario_TipoUsuario
    FOREIGN KEY (idtipo)
    REFERENCES TipoUsuario (idtipo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table TipoEvento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TipoEvento (
  idevento INT NOT NULL UNIQUE,
  descricao VARCHAR(10) NULL,
  PRIMARY KEY (idevento));


-- -----------------------------------------------------
-- Table aluno
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS aluno (
  cpf VARCHAR(14) NOT NULL UNIQUE,
  matricula VARCHAR(10) NULL,
  PRIMARY KEY (cpf),
  CONSTRAINT fk_aluno_Usuario1
    FOREIGN KEY (cpf)
    REFERENCES Usuario (cpf)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table turma
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS turma (
  idturma INT NOT NULL UNIQUE,
  descricao VARCHAR(45) NULL,
  PRIMARY KEY (idturma));


-- -----------------------------------------------------
-- Table matricula
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS matricula (
  idturma INT NOT NULL UNIQUE,
  cpf VARCHAR(18) NOT NULL,
  PRIMARY KEY (idturma, cpf),
  CONSTRAINT fk_matricual_turma1
    FOREIGN KEY (idturma)
    REFERENCES turma (idturma)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_matricual_aluno1
    FOREIGN KEY (cpf)
    REFERENCES aluno (cpf)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table calendario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS calendario (
  idcalendario INT NOT NULL UNIQUE,
  cpf VARCHAR(14) NOT NULL UNIQUE,
  idevento INT NOT NULL UNIQUE,
  datainicio DATE NULL,
  datafim DATE NULL,
  PRIMARY KEY (idcalendario, idevento, cpf),
  CONSTRAINT fk_calendario_TipoEvento1
    FOREIGN KEY (idevento)
    REFERENCES TipoEvento (idevento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_calendario_Usuario1
    FOREIGN KEY (cpf)
    REFERENCES Usuario (cpf)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
-- -----------------------------------------------------
-- Table TipoUsuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TipoUsuario (
  idtipo INT NOT NULL UNIQUE,
  descricao VARCHAR(45) NULL,
  PRIMARY KEY (idtipo));


-- -----------------------------------------------------
-- Table Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
  cpf VARCHAR(14) NOT NULL UNIQUE,
  idtipo INT NOT NULL UNIQUE,
  email VARCHAR(45) NULL,
  senha VARCHAR(60) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (cpf, idtipo),
  CONSTRAINT fk_Usuario_TipoUsuario
    FOREIGN KEY (idtipo)
    REFERENCES TipoUsuario (idtipo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table TipoEvento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TipoEvento (
  idevento INT NOT NULL UNIQUE,
  descricao VARCHAR(10) NULL,
  PRIMARY KEY (idevento));


-- -----------------------------------------------------
-- Table aluno
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS aluno (
  cpf VARCHAR(14) NOT NULL UNIQUE,
  matricula VARCHAR(10) NULL,
  PRIMARY KEY (cpf),
  CONSTRAINT fk_aluno_Usuario1
    FOREIGN KEY (cpf)
    REFERENCES Usuario (cpf)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table turma
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS turma (
  idturma INT NOT NULL UNIQUE,
  descricao VARCHAR(45) NULL,
  PRIMARY KEY (idturma));


-- -----------------------------------------------------
-- Table matricula
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS matricula (
  idturma INT NOT NULL UNIQUE,
  cpf VARCHAR(18) NOT NULL,
  PRIMARY KEY (idturma, cpf),
  CONSTRAINT fk_matricual_turma1
    FOREIGN KEY (idturma)
    REFERENCES turma (idturma)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_matricual_aluno1
    FOREIGN KEY (cpf)
    REFERENCES aluno (cpf)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table calendario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS calendario (
  idcalendario INT NOT NULL UNIQUE,
  cpf VARCHAR(14) NOT NULL UNIQUE,
  idevento INT NOT NULL UNIQUE,
  datainicio DATE NULL,
  datafim DATE NULL,
  PRIMARY KEY (idcalendario, idevento, cpf),
  CONSTRAINT fk_calendario_TipoEvento1
    FOREIGN KEY (idevento)
    REFERENCES TipoEvento (idevento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_calendario_Usuario1
    FOREIGN KEY (cpf)
    REFERENCES Usuario (cpf)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
