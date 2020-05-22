
USE `product_directory`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$10$I/Q6pS.c//CkzwiY5z.SQe5BeNpVC13JCkEZO1fBMTXBRO5ycMs3a',1),
('mary','{bcrypt}mscPgvjiSzbXS3cehbZTuc5SDAMtGX4l16DxQz90ltshrSxufr5C',1),
('susan','{bcrypt}$2a$10$JmmtACPEysfoO678COODYOzzOm52nruZEyWwOTAW4XABca.KMRpte',1),
('ali','{bcrypt}$2a$10$QtLy1xZUc5oQNsVscQeAJeRUEpaImypm0/Tqg4bc6wxeiiDE8qgOu',1),
('fazil','{bcrypt}$2a$10$5rwtVU7GeFVYUkdRdUNQS.R3C7KOyUYOf7hznIehTkIhTZ3.zZJRu',1),;





