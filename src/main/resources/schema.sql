DROP DATABASE IF EXISTS raa;
CREATE DATABASE raa;
use raa;

-- Database name: Restaurant App API

DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS food_items;
DROP TABLE IF EXISTS saved_order;
DROP TABLE IF EXISTS orders;

CREATE TABLE food_items (
    food_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    ingredients TEXT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    emoji VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci
);

CREATE TABLE customer_order (
    customer_order_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    food_id INT,
    FOREIGN KEY (food_id) REFERENCES food_items(food_id) ON DELETE SET NULL
);

CREATE TABLE orders (
    orders_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    status ENUM('ORDERED', 'PENDING', 'COMPLETED') DEFAULT 'ORDERED'
);

CREATE TABLE saved_order (
    saved_order_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    order_id INT,
    food_id INT,
    price DECIMAL(10, 2) NOT NULL,
    name VARCHAR(255) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(orders_id),
    FOREIGN KEY (food_id) REFERENCES food_items(food_id) ON DELETE SET NULL
);

INSERT INTO food_items (name, ingredients, price, emoji) VALUES
    ('Pizza', 'pepperoni, mushrooms, mozzarella', 14, '🍕'),
    ('Hamburger', 'beef, cheese, lettuce', 12, '🍔'),
    ('Beer', 'grain, hops, yeast, water', 12, '🍺'),
    ('Hot dog', 'sausage, bread', 2, '🌭');
    