CREATE DATABASE IF NOT EXISTS upofitnessPortugal;

USE upofitnessPortugal;

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
    FOREIGN KEY (gym_id) REFERENCES gym(id)
);

CREATE TABLE IF NOT EXISTS appointment(
	id int PRIMARY KEY AUTO_INCREMENT,
    client_id int NOT NULL,
    employee_id int NOT NULL,
	date_hour datetime NOT NULL,
    length int NOT NULL,
    type varchar(255) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
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
('Lisbon Fitness Club', 'Avenida da Liberdade 123', 'Lisbon', '+351 215 555 123', 'lisbon@fitnessclub.pt', 'Mon-Fri 07:00-22:00, Sat-Sun 10:00-18:00', 120),
('Porto Sports Center', 'Rua de Santa Catarina 456', 'Porto', '+351 225 555 456', 'porto@sportscenter.pt', 'Mon-Fri 08:00-21:00, Sat-Sun 09:00-19:00', 150),
('Braga Gym', 'Rua do Largo da Torre 789', 'Braga', '+351 255 555 789', 'braga@gym.pt', 'Mon-Fri 06:00-23:00, Sat-Sun 08:00-20:00', 100),
('Faro Workout', 'Avenida dos Descobrimentos 1011', 'Faro', '+351 285 555 1011', 'faro@workout.pt', 'Mon-Fri 07:00-22:00, Sat-Sun 10:00-18:00', 130),
('Coimbra Fitness', 'Rua da Queimada de Fitas 1213', 'Coimbra', '+351 235 555 1213', 'coimbra@fitness.pt', 'Mon-Fri 08:00-21:00, Sat-Sun 09:00-19:00', 80);

INSERT INTO client (name, surname, birth_date, city, phone_number, email, inscription_date, membership_type, payment_method) VALUES
('João', 'Silva', '1990-01-01', 'Lisbon', '+351 915 555 123', 'joao.silva@gmail.com', '2023-01-01', 'Standard', 'Credit Card'),
('Maria', 'Santos', '1995-02-02', 'Porto', '+351 935 555 456', 'maria.santos@gmail.com', '2023-02-02', 'Premium', 'Bank Transfer'),
('Luis', 'Pereira', '1985-03-03', 'Braga', '+351 965 555 789', 'luis.pereira@gmail.com', '2023-03-03', 'Basic', 'PayPal'),
('Ana', 'Almeida', '1992-04-04', 'Faro', '+351 955 555 1011', 'ana.almeida@gmail.com', '2023-04-04', 'Standard', 'Cash on Delivery'),
('Pedro', 'Rodrigues', '1988-05-05', 'Coimbra', '+351 955 555 1213', 'pedro.rodrigues@gmail.com', '2023-05-05', 'Premium', 'Check');

INSERT INTO employee (name, surname, gym_id) VALUES
('Carlos', 'Costa', 1),
('Laura', 'Ribeiro', 2),
('David', 'Fernandes', 3),
('Marta', 'Alves', 4),
('Sergio', 'Oliveira', 5);

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