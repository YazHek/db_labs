DROP SCHEMA IF EXISTS `mydb` ;

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;


DROP TABLE IF EXISTS `mydb`.`city` ;
DROP TABLE IF EXISTS `mydb`.`country` ;
DROP TABLE IF EXISTS `mydb`.`day_of_week` ;
DROP TABLE IF EXISTS `mydb`.`pictures` ;
DROP TABLE IF EXISTS `mydb`.`cloud_state` ;
DROP TABLE IF EXISTS `mydb`.`catastrophy_warning` ;
DROP TABLE IF EXISTS `mydb`.`weather_conditions` ;




CREATE TABLE `mydb`.`city` (
  `id` INT NOT NULL,
  `city_name` VARCHAR(45) NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`))
ENGINE = InnoDB;


CREATE TABLE `mydb`.`country` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `city_id` INT NOT NULL,
  `city_country_id` INT NOT NULL,
  PRIMARY KEY (`id`, `city_id`, `city_country_id`),
  CONSTRAINT `fk_country_city1`
    FOREIGN KEY (`city_id` , `city_country_id`)
    REFERENCES `mydb`.`city` (`id` , `country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_country_city1_idx` ON `mydb`.`country` (`city_id` ASC, `city_country_id` ASC) VISIBLE;


CREATE TABLE `mydb`.`day_of_week` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE `mydb`.`pictures` (
  `id` INT NOT NULL,
  `picture_name` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `mydb`.`cloud_state` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE `mydb`.`catastrophy_warning` (
  `id` INT NOT NULL,
  `catastrophy_picture_id` INT NULL,
  `weather_condition_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE `mydb`.`weather_conditions` (
  `id` INT NOT NULL,
  `temparature` INT NULL,
  `huminity` DOUBLE NULL,
  `wind_direction` VARCHAR(45) NULL,
  `wind_speed` VARCHAR(45) NULL,
  `water_temp` INT NULL,
  `date` DATE NULL,
  `hour` INT NULL,
  `day_of_week_id` INT NOT NULL,
  `pictures_id` INT NOT NULL,
  `cloud_state_id` INT NOT NULL,
  `city_id` INT NOT NULL,
  `city_country_id` INT NOT NULL,
  `catastrophy_warning_id` INT NOT NULL,
  PRIMARY KEY (`id`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`),
  CONSTRAINT `fk_weather_conditions_day_of_week`
    FOREIGN KEY (`day_of_week_id`)
    REFERENCES `mydb`.`day_of_week` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_weather_conditions_pictures1`
    FOREIGN KEY (`pictures_id`)
    REFERENCES `mydb`.`pictures` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_weather_conditions_cloud_state1`
    FOREIGN KEY (`cloud_state_id`)
    REFERENCES `mydb`.`cloud_state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_weather_conditions_city1`
    FOREIGN KEY (`city_id` , `city_country_id`)
    REFERENCES `mydb`.`city` (`id` , `country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_weather_conditions_catastrophy_warning1`
    FOREIGN KEY (`catastrophy_warning_id`)
    REFERENCES `mydb`.`catastrophy_warning` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_weather_conditions_day_of_week_idx` ON `mydb`.`weather_conditions` (`day_of_week_id` ASC) VISIBLE;

CREATE INDEX `fk_weather_conditions_pictures1_idx` ON `mydb`.`weather_conditions` (`pictures_id` ASC) VISIBLE;

CREATE INDEX `fk_weather_conditions_cloud_state1_idx` ON `mydb`.`weather_conditions` (`cloud_state_id` ASC) VISIBLE;

CREATE INDEX `fk_weather_conditions_city1_idx` ON `mydb`.`weather_conditions` (`city_id` ASC, `city_country_id` ASC) VISIBLE;

CREATE INDEX `fk_weather_conditions_catastrophy_warning1_idx` ON `mydb`.`weather_conditions` (`catastrophy_warning_id` ASC) VISIBLE;



START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (1, 'Lviv', 10);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (2, 'Kyiv', 9);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (3, 'Warsaw', 8);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (4, 'Ternopil', 7);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (5, 'Kharkiv', 6);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (6, 'Donetsk', 5);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (7, 'New York', 4);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (8, 'Lutsk', 3);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (9, 'Lublin', 2);
INSERT INTO `mydb`.`city` (`id`, `city_name`, `country_id`) VALUES (10, 'Odessa', 1);

COMMIT;

START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (1, 'Ukraine', 10, 1);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (2, 'USA', 7, 4);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (3, 'Germany', 2, 9);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (4, 'Poland', 3, 8);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (5, 'Russia', 4, 7);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (6, 'England', 5, 6);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (7, 'Irland', 6, 5);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (8, 'Turkey', 8, 3);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (9, 'Egypt', 9, 2);
INSERT INTO `mydb`.`country` (`id`, `name`, `city_id`, `city_country_id`) VALUES (10, 'Iran', 10, 1);

COMMIT;


START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`day_of_week` (`id`, `name`) VALUES (1, 'Monday');
INSERT INTO `mydb`.`day_of_week` (`id`, `name`) VALUES (2, 'Tuesday');
INSERT INTO `mydb`.`day_of_week` (`id`, `name`) VALUES (3, 'Wednesday');
INSERT INTO `mydb`.`day_of_week` (`id`, `name`) VALUES (4, 'Thursday');
INSERT INTO `mydb`.`day_of_week` (`id`, `name`) VALUES (5, 'Friday');
INSERT INTO `mydb`.`day_of_week` (`id`, `name`) VALUES (6, 'Saturday');
INSERT INTO `mydb`.`day_of_week` (`id`, `name`) VALUES (7, 'Sunday');

COMMIT;


START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`pictures` (`id`, `picture_name`) VALUES (1, NULL);
INSERT INTO `mydb`.`pictures` (`id`, `picture_name`) VALUES (2, NULL);
INSERT INTO `mydb`.`pictures` (`id`, `picture_name`) VALUES (3, NULL);
INSERT INTO `mydb`.`pictures` (`id`, `picture_name`) VALUES (4, NULL);

COMMIT;


START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`cloud_state` (`id`, `name`) VALUES (1, NULL);
INSERT INTO `mydb`.`cloud_state` (`id`, `name`) VALUES (2, NULL);
INSERT INTO `mydb`.`cloud_state` (`id`, `name`) VALUES (3, NULL);

COMMIT;

START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`catastrophy_warning` (`id`, `catastrophy_picture_id`, `weather_condition_id`) VALUES (1, 9, 21);
INSERT INTO `mydb`.`catastrophy_warning` (`id`, `catastrophy_picture_id`, `weather_condition_id`) VALUES (2, 8, 23);
INSERT INTO `mydb`.`catastrophy_warning` (`id`, `catastrophy_picture_id`, `weather_condition_id`) VALUES (3, 7, 24);

COMMIT;


START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`weather_conditions` (`id`, `temparature`, `huminity`, `wind_direction`, `wind_speed`, `water_temp`, `date`, `hour`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`) VALUES (1, 10, 50, 'North', '7', 20, '2001-06-21', 12.34, 1, 3, 1, 10, 1, 2);
INSERT INTO `mydb`.`weather_conditions` (`id`, `temparature`, `huminity`, `wind_direction`, `wind_speed`, `water_temp`, `date`, `hour`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`) VALUES (2, 10, 100, 'West', '20', 45, '1978-07-11', 13.00, 2, 2, 2, 9, 2, 3);
INSERT INTO `mydb`.`weather_conditions` (`id`, `temparature`, `huminity`, `wind_direction`, `wind_speed`, `water_temp`, `date`, `hour`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`) VALUES (3, 14, 40, 'East', '3', 13, '1945-03-19', 17.45, 3, 1, 2, 8, 3, 1);
INSERT INTO `mydb`.`weather_conditions` (`id`, `temparature`, `huminity`, `wind_direction`, `wind_speed`, `water_temp`, `date`, `hour`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`) VALUES (4, 21, 20, 'South', '5', 2, '1975-01-01', 05.00, 4, 3, 1, 7, 4, 2);
INSERT INTO `mydb`.`weather_conditions` (`id`, `temparature`, `huminity`, `wind_direction`, `wind_speed`, `water_temp`, `date`, `hour`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`) VALUES (5, 30, 40, 'South-West', '9', 0, '2005-06-12', 15.19, 5, 2, 1, 6, 5, 1);
INSERT INTO `mydb`.`weather_conditions` (`id`, `temparature`, `huminity`, `wind_direction`, `wind_speed`, `water_temp`, `date`, `hour`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`) VALUES (6, 3, 80, 'North-East', '12', 18, '2001-07-19', 19.20, 6, 1, 3, 5, 6, 2);
INSERT INTO `mydb`.`weather_conditions` (`id`, `temparature`, `huminity`, `wind_direction`, `wind_speed`, `water_temp`, `date`, `hour`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`) VALUES (7, 9, 90, 'South-East', '15', 34, '2016-04-16', 07.13, 7, 4, 2, 4, 7, 3);
INSERT INTO `mydb`.`weather_conditions` (`id`, `temparature`, `huminity`, `wind_direction`, `wind_speed`, `water_temp`, `date`, `hour`, `day_of_week_id`, `pictures_id`, `cloud_state_id`, `city_id`, `city_country_id`, `catastrophy_warning_id`) VALUES (8, 26, 55, 'North-West', '13', 14, '2014-05-15', 03.16, 2, 2, 1, 3, 8, 1);
COMMIT;




