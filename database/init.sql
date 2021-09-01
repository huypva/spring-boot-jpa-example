CREATE DATABASE IF NOT EXISTS `spring_boot_jpa_example`;

USE `spring_boot_jpa_example`;
CREATE TABLE `user` (
  user_id INT(11) NOT NULL,
  user_name VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO `user` VALUES (1, "Huy");
INSERT INTO `user` VALUES (2, "Hai");