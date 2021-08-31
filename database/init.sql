CREATE DATABASE IF NOT EXISTS `spring-boot-jpa-example`;

USE `spring-boot-jpa-example`;
CREATE TABLE `User` (
  user_id INT(11) NOT NULL,
  user_name VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO `User` VALUES (1, "Huy");
INSERT INTO `User` VALUES (2, "Hai");