CREATE DATABASE  IF NOT EXISTS `product_directory`

USE `product_directory`;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `product_brand` varchar(45) DEFAULT NULL,
  `product_price` float(10,2) DEFAULT NULL,
  `quantity` integer(100) DEFAULT NOT NULL,
  `product_model`  varchar(10) DEFAULT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


