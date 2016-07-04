-- MySQL Script generated by MySQL Workbench
-- Mon 04 Jul 2016 01:10:02 PM CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hospital` ;

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospital` DEFAULT CHARACTER SET utf8 ;
USE `hospital` ;

-- -----------------------------------------------------
-- Table `hospital`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`department` ;

CREATE TABLE IF NOT EXISTS `hospital`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`doctor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`doctor` ;

CREATE TABLE IF NOT EXISTS `hospital`.`doctor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_doctor_department_idx` (`department_id` ASC),
  CONSTRAINT `fk_doctor_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `hospital`.`department` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`patient` ;

CREATE TABLE IF NOT EXISTS `hospital`.`patient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_patient_department1_idx` (`department_id` ASC),
  CONSTRAINT `fk_patient_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `hospital`.`department` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`medical`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`medical` ;

CREATE TABLE IF NOT EXISTS `hospital`.`medical` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`cure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`cure` ;

CREATE TABLE IF NOT EXISTS `hospital`.`cure` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `doctor_id` INT NOT NULL,
  `patient_id` INT NOT NULL,
  `medical_id` INT NOT NULL,
  `count` REAL NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  `date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cure_doctor1_idx` (`doctor_id` ASC),
  INDEX `fk_cure_patient1_idx` (`patient_id` ASC),
  INDEX `fk_cure_medical1_idx` (`medical_id` ASC),
  CONSTRAINT `fk_cure_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `hospital`.`doctor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_cure_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital`.`patient` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_cure_medical1`
    FOREIGN KEY (`medical_id`)
    REFERENCES `hospital`.`medical` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`doctor_has_patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`doctor_has_patient` ;

CREATE TABLE IF NOT EXISTS `hospital`.`doctor_has_patient` (
  `doctor_id` INT NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`doctor_id`, `patient_id`),
  INDEX `fk_doctor_has_patient_patient1_idx` (`patient_id` ASC),
  INDEX `fk_doctor_has_patient_doctor1_idx` (`doctor_id` ASC),
  CONSTRAINT `fk_doctor_has_patient_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `hospital`.`doctor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_doctor_has_patient_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital`.`patient` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;