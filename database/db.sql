-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema attendance
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema attendance
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `attendance` DEFAULT CHARACTER SET utf8 ;
USE `attendance` ;

-- -----------------------------------------------------
-- Table `attendance`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `attendance`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `privilage` INT NULL,
  `last_updated` TIMESTAMP NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `attendance`.`attendance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `attendance`.`attendance` (
  `user_id` INT NOT NULL,
  `login` INT NOT NULL,
  `last_updated` TIMESTAMP NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_attendance_uid`
    FOREIGN KEY (`user_id`)
    REFERENCES `attendance`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `attendance`.`report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `attendance`.`report` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `date` DATE NULL,
  `day` VARCHAR(45) NULL,
  `time_of_login` TIME NULL,
  `time_of_logout` TIME NULL,
  `worked_hours` INT NULL,
  `flag` VARCHAR(45) NULL,
  `last_updated` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_uid_idx` (`user_id` ASC),
  CONSTRAINT `fk_report_uid`
    FOREIGN KEY (`user_id`)
    REFERENCES `attendance`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
