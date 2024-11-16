CREATE DATABASE IF NOT EXISTS upofitnessCentral;

USE upofitnessCentral;

CREATE TABLE warehouse (
    id INT PRIMARY KEY AUTO_INCREMENT,
    location VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product_category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS supplier (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    payment_method VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    price DECIMAL(10,2),
    description VARCHAR(255) NOT NULL,
    warehouse_id INT,
    category_id INT,
    supplier_id INT,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse(id) ON DELETE SET NULL,
    FOREIGN KEY (category_id) REFERENCES product_category(id) ON DELETE SET NULL,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id) ON DELETE SET NULL
);

CREATE TABLE Shipment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    shipping_address VARCHAR(255),
    shipping_date DATE,
    tracking_number VARCHAR(50),
    delivery_date DATE
);

INSERT INTO warehouse (location) VALUES
('Lappeenranta'),
('Helsinki'),
('Tampere'),
('Oulu'),
('Turku');

INSERT INTO product_category (name, description) VALUES
('Weightlifting', 'Equipment for weightlifting'),
('Cardio', 'Equipment for cardiovascular exercise'),
('Yoga', 'Equipment for yoga and pilates'),
('Fitness Accessories', 'Accessories for fitness and workouts'),
('Nutrition', 'Nutritional supplements and products');

INSERT INTO supplier (name, country, phone_number, email, payment_method) VALUES
('Fitness Equipment Co.', 'United States', '+1 555 123 4567', 'fitness@equipment.com', 'Credit Card'),
('Nordic Strength', 'Sweden', '+46 555 890 1234', 'nordic@strength.se', 'Bank Transfer'),
('Zen Health', 'India', '+91 555 789 0123', 'zen@health.in', 'PayPal'),
('Active Gear', 'China', '+86 555 678 9012', 'active@gear.cn', 'Cash on Delivery'),
('NutriFit', 'Australia', '+61 555 567 8901', 'nutri@fit.au', 'Check');

INSERT INTO product (price, description, warehouse_id, category_id, supplier_id) VALUES
(299.99, 'Barbell set with weights', 1, 1, 1),
(149.99, 'Treadmill', 2, 2, 2),
(79.99, 'Yoga mat', 3, 3, 3),
(24.99, 'Water bottle', 4, 4, 4),
(49.99, 'Protein powder', 5, 5, 5);

INSERT INTO Shipment (shipping_address, shipping_date, tracking_number, delivery_date)
VALUES
('Calle Mayor, 23, Madrid, Spain', '2023-11-25', 'ABC123DEF', '2023-11-28'),
('Passeig de Gràcia, 5, Barcelona, Spain', '2023-11-26', 'GHI456JKL', '2023-11-30'),
('Avenida del Mar, 100, Valencia, Spain', '2023-11-27', 'MNO789PQR', '2023-12-02'),
('Calle Sierpes, 34, Sevilla, Spain', '2023-11-28', 'STU012VWX', '2023-12-01'),
('Alameda Principal, 15, Malaga, Spain', '2023-11-29', 'YZ123ABC', '2023-12-03'),
('Avenida da Liberdade, 25, Lisbon, Portugal', '2023-11-30', 'DEF456GHI', '2023-12-04'),
('Rua de Santa Catarina, 110, Porto, Portugal', '2023-12-01', 'JKL789MNO', '2023-12-05'),
('Avenida da Liberdade, 150, Braga, Portugal', '2023-12-02', 'PQR012STU', '2023-12-06'),
('Rua de Santo António, 50, Faro, Portugal', '2023-12-03', 'VWX123YZ', '2023-12-07'),
('Rua Ferreira Borges, 20, Coimbra, Portugal', '2023-12-04', 'ABC456DEF', '2023-12-08');