CREATE TABLE `category`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    `created_date` datetime(6) DEFAULT CURRENT_TIMESTAMP,
    `updated_date` datetime(6) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);

CREATE TABLE `product`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `brand`       varchar(255) DEFAULT NULL,
    `color`       varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    `price`       double       DEFAULT NULL,
    `category_id` bigint(20) NOT NULL,
    `created_date` datetime(6) DEFAULT CURRENT_TIMESTAMP,
    `updated_date` datetime(6) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `FKjyk1alubes3jiqgdfmmus5lc1` (`category_id`),
    CONSTRAINT `FKjyk1alubes3jiqgdfmmus5lc1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
);

INSERT INTO category (name, description) VALUES ('Phone', 'Category phone');
INSERT INTO category (name, description) VALUES ('Laptop', 'Category laptop');

INSERT INTO product (name, brand, color, price, description, category_id) VALUES ('iPhone 11', 'Apple', 'Black', '1000', 'Iphone 11 256GB', 1);
INSERT INTO product (name, brand, color, price, description, category_id) VALUES ('iPhone 11 Pro Max', 'Apple', 'Gold', '1500', 'Iphone 11 256GB Pro Max', 1);
INSERT INTO product (name, brand, color, price, description, category_id) VALUES ('Galaxy S20', 'Samsung', 'Blue', '1000', 'Galaxy S20 Pro', 1);
INSERT INTO product (name, brand, color, price, description, category_id) VALUES ('Galaxy A20', 'Samsung', 'White', '1000', 'Galaxy A20 Pro', 1);

INSERT INTO product (name, brand, color, price, description, category_id) VALUES ('Macbook Pro', 'Apple', 'Silver', '2000', 'Macbook Pro SSD 512GB', 2);
