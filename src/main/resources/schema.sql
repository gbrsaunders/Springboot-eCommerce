CREATE TABLE IF NOT EXISTS `account_info` (
    `accountID` int AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL,
    `admin` boolean DEFAULT NULL,
    `sellingList` varchar(100) NOT NULL,
    `shoppingList` varchar(100) NOT NULL
);