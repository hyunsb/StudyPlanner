CREATE TABLE `studyplanner`.`member` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `email` VARCHAR(45) NOT NULL,
                                         `password` VARCHAR(45) NOT NULL,
                                         `name` VARCHAR(45) NOT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);