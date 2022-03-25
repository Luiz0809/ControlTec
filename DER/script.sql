-- MySQL Script generated by MySQL Workbench
-- Fri Mar 25 18:56:49 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `Disco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Disco` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Disco` (
  `idDisco` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `serial` VARCHAR(45) NULL,
  `tamanho` INT NULL,
  `leiturasEmBytes` INT NULL,
  `escritasEmBytes` INT NULL,
  `tamanhoAtualDaFila` INT NULL,
  `tempoDeTransferencia` INT NULL,
  `fkMaquina` INT NOT NULL,
  PRIMARY KEY (`idDisco`),
  CONSTRAINT `fk_Disco_Maquina1`
    FOREIGN KEY (`fkMaquina`)
    REFERENCES `Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Disco_Maquina1_idx` ON `Disco` (`fkMaquina` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Instituicao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Instituicao` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Instituicao` (
  `idInstituicao` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `numero` INT NULL,
  `Rua` VARCHAR(45) NOT NULL,
  `Bairro` VARCHAR(45) NULL,
  `Cidade` VARCHAR(45) NULL,
  `Estado` CHAR(2) NULL,
  `CEP` VARCHAR(45) NULL,
  `Complemento` VARCHAR(45) NULL,
  `PontoReferencia` VARCHAR(40) NULL,
  PRIMARY KEY (`idInstituicao`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Logs` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Logs` (
  `Usuario` INT NOT NULL,
  `Maquina` INT NOT NULL,
  `Momento` DATETIME NOT NULL,
  `Temperatura` DOUBLE NULL,
  `ConsumoMemoria` INT NULL,
  `ConsumoCPU` INT NULL,
  `ProgramaUsado` VARCHAR(45) NULL,
  `ConsumoDisco` INT NULL,
  `tempoEmUso` INT NULL,
  `inicializado` DATETIME NULL,
  PRIMARY KEY (`Usuario`, `Maquina`, `Momento`),
  CONSTRAINT `fk_Usuario_has_Maquina_Usuario`
    FOREIGN KEY (`Usuario`)
    REFERENCES `Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Maquina_Maquina1`
    FOREIGN KEY (`Maquina`)
    REFERENCES `Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Usuario_has_Maquina_Maquina1_idx` ON `Logs` (`Maquina` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_Usuario_has_Maquina_Usuario_idx` ON `Logs` (`Usuario` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Maquina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Maquina` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Maquina` (
  `idMaquina` INT NOT NULL,
  `CodigoMaquina` VARCHAR(45) NULL,
  `Descrição` VARCHAR(45) NULL,
  PRIMARY KEY (`idMaquina`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Memoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Memoria` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Memoria` (
  `idMemoria` INT NOT NULL,
  `disponivel` INT NULL,
  `total` INT NULL,
  `fkMaquina` INT NOT NULL,
  PRIMARY KEY (`idMemoria`),
  CONSTRAINT `fk_Memoria_Maquina1`
    FOREIGN KEY (`fkMaquina`)
    REFERENCES `Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Memoria_Maquina1_idx` ON `Memoria` (`fkMaquina` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Processador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Processador` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Processador` (
  `idProcessador` INT NOT NULL,
  `fabricante` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  `identificador` VARCHAR(45) NULL,
  `microarquitetura` VARCHAR(45) NULL,
  `frequencia` INT NULL,
  `pacotesFisicos` INT NULL,
  `cpusFisicas` INT NULL,
  `uso` INT NULL,
  `fkMaquina` INT NOT NULL,
  PRIMARY KEY (`idProcessador`),
  CONSTRAINT `fk_Processador_Maquina1`
    FOREIGN KEY (`fkMaquina`)
    REFERENCES `Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Processador_Maquina1_idx` ON `Processador` (`fkMaquina` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Sistema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Sistema` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Sistema` (
  `idSistema` INT NOT NULL,
  `SO` VARCHAR(45) NULL,
  `fabricante` VARCHAR(45) NULL,
  `arquitetura` VARCHAR(45) NULL,
  `permissao` TINYINT NULL,
  `fkMaquina` INT NOT NULL,
  PRIMARY KEY (`idSistema`),
  CONSTRAINT `fk_Sistema_Maquina1`
    FOREIGN KEY (`fkMaquina`)
    REFERENCES `Maquina` (`idMaquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Sistema_Maquina1_idx` ON `Sistema` (`fkMaquina` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Turma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Turma` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Turma` (
  `idTurma` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `descricao` VARCHAR(40) NULL,
  `sala` VARCHAR(45) NULL,
  `fkInstituicao` INT NOT NULL,
  PRIMARY KEY (`idTurma`),
  CONSTRAINT `fk_Turma_Instituicao1`
    FOREIGN KEY (`fkInstituicao`)
    REFERENCES `Instituicao` (`idInstituicao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Turma_Instituicao1_idx` ON `Turma` (`fkInstituicao` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Usuario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Usuario` (
  `idUsuario` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `Idade` INT NULL,
  `CodigoInstituicao` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `Tipo_Usuario` INT NOT NULL,
  `fkInstituicao` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  CONSTRAINT `fk_Usuario_Instituicao1`
    FOREIGN KEY (`fkInstituicao`)
    REFERENCES `Instituicao` (`idInstituicao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Usuario_Instituicao1_idx` ON `Usuario` (`fkInstituicao` ASC) VISIBLE;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;