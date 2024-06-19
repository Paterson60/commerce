CREATE TABLE `Inventory` (
  `inventory_Id` int AUTO_INCREMENT,
  `sku` varchar(255),
  `quantity` double,
  `category` varchar(255),
  `status` varchar(255),
  `created_at` date NOT NULL,
  `updated_at` date DEFAULT NULL,
  PRIMARY KEY (`inventory_Id`)
);