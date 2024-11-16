CREATE DATABASE IF NOT EXISTS upofitnessSpain;

USE upofitnessSpain;

CREATE TABLE IF NOT EXISTS gym (
	id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    schedule varchar(255) NOT NULL,
    max_capacity int NOT NULL
);

CREATE TABLE IF NOT EXISTS client(
	id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    birth_date date NOT NULL,
    city varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    inscription_date date NOT NULL,
    membership_type varchar(255) NOT NULL,
    payment_method varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee(
	id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    gym_id int NOT NULL,
    FOREIGN KEY (gym_id) REFERENCES gym(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS appointment(
	id int PRIMARY KEY AUTO_INCREMENT,
    client_id int NOT NULL,
    employee_id int NOT NULL,
	date_hour datetime NOT NULL,
    length int NOT NULL,
    type varchar(255) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS payment (
	id int PRIMARY KEY AUTO_INCREMENT,
    client_id int NOT NULL,
    payment_day date NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    method varchar(255) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

INSERT INTO gym (name, address, city, phone_number, email, schedule, max_capacity) VALUES
('Fitness Center Madrid', 'Calle Alcala 123', 'Madrid', '+34 915 555 123', 'madrid@fitness.es', 'Mon-Fri 07:00-22:00, Sat-Sun 10:00-18:00', 100),
('Barcelona Sports Club', 'Avenida Diagonal 456', 'Barcelona', '+34 935 555 456', 'barcelona@sportsclub.es', 'Mon-Fri 08:00-21:00, Sat-Sun 09:00-19:00', 150),
('Valencia Gym', 'Calle Colon 789', 'Valencia', '+34 965 555 789', 'valencia@gym.es', 'Mon-Fri 06:00-23:00, Sat-Sun 08:00-20:00', 80),
('Seville Workout', 'Plaza de España 1011', 'Sevilla', '+34 955 555 1011', 'seville@workout.es', 'Mon-Fri 07:00-22:00, Sat-Sun 10:00-18:00', 120),
('Malaga Fitness', 'Paseo del Parque 1213', 'Malaga', '+34 955 555 1213', 'malaga@fitness.es', 'Mon-Fri 08:00-21:00, Sat-Sun 09:00-19:00', 130);

INSERT INTO client (name, surname, birth_date, city, phone_number, email, inscription_date, membership_type, payment_method) VALUES
('Juan', 'Garcia', '1990-01-01', 'Madrid', '+34 600 123 456', 'juan.garcia@gmail.com', '2023-01-01', 'Standard', 'Credit Card'),
('María', 'Lopez', '1995-02-02', 'Barcelona', '+34 600 456 789', 'maria.lopez@gmail.com', '2023-02-02', 'Premium', 'Bank Transfer'),
('Luis', 'Perez', '1985-03-03', 'Valencia', '+34 600 789 012', 'luis.perez@gmail.com', '2023-03-03', 'Basic', 'PayPal'),
('Ana', 'Martinez', '1992-04-04', 'Seville', '+34 600 012 345', 'ana.martinez@gmail.com', '2023-04-04', 'Standard', 'Cash on Delivery'),
('Pedro', 'Rodriguez', '1988-05-05', 'Malaga', '+34 600 345 678', 'pedro.rodriguez@gmail.com', '2023-05-05', 'Premium', 'Check');

INSERT INTO employee (name, surname, gym_id) VALUES
('Carlos', 'Sanchez', 1),
('Laura', 'Fernandez', 2),
('David', 'Ramirez', 3),
('Marta', 'Lopez', 4),
('Sergio', 'Gonzalez', 5);

INSERT INTO appointment (client_id, employee_id, date_hour, length, type) VALUES
(1, 1, '2023-06-01 10:00:00', 60, 'Personal Training'),
(2, 2, '2023-07-02 15:00:00', 45, 'Group Class'),
(3, 3, '2023-08-03 18:00:00', 30, 'Pilates'),
(4, 4, '2023-09-04 12:00:00', 60, 'Yoga'),
(5, 5, '2023-10-05 17:00:00', 45, 'Zumba');

INSERT INTO payment (client_id, payment_day, amount, method) VALUES
(1, '2023-06-01', 50.00, 'Credit Card'),
(2, '2023-07-02', 35.00, 'Bank Transfer'),
(3, '2023-08-03', 25.00, 'PayPal'),
(4, '2023-09-04', 50.00, 'Cash on Delivery'),
(5, '2023-10-05', 35.00, 'Check');