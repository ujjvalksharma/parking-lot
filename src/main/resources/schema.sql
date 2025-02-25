CREATE TABLE VECHILE(
id int PRIMARY KEY AUTO_INCREMENT,
plateNumber VARCHAR(20),
color VARCHAR(20)
);

CREATE TABLE CAR(
id int FOREIGN KEY REFERENCES Vehicle(id),
);

CREATE TABLE TRUCK(
id int FOREIGN KEY REFERENCES Vehicle(id),
);

CREATE TABLE PERSON(
  name VARCHAR(255),
  id INT PRIMARY KEY AUTO_INCREMENT,
  licenceNumber VARCHAR(20)
);

CREATE TABLE Location(
id int PRIMARY KEY AUTO_INCREMENT,
x DOUBLE,
y DOUBLE,
);

CREATE TABLE PARKING_SPOT(
id int PRIMARY KEY AUT0_INCREMENT,
is_available BOOLEAN DEFAULT TRUE,
int location_id FOREIGN KEY REFERENCES Location(id)
);

CREATE TABLE LARGE_PARKING_SPOT(
id int FOREIGN KEY REFERENCES (PARKING_SPOT(id))
);

CREATE TABLE SMALL_PARKING_SPOT(
id int FOREIGN KEY REFERENCES (PARKING_SPOT(id))
);

PARKING_FLOOR(
id int PRIMARY KEY AUTO_INCREMENT
);

PARKING_FLOOR_PARKING_SPOT(
parking_floor_id int FOREIGN KEY REFERENCES PARKING_FLOOR(id),
parking_spot_id int FOREIGN KEY REFERENCES PARKING_SPOT(id)
);

PARKING_LOT(
id int PRIMARY KEY AUTO_INCREMENT
);

PARKING_FLOOR_PARKING_SPOT(
parking_lot_id int FOREIGN KEY REFERENCES PARKING_LOT(id),
parking_floor_id int FOREIGN KEY REFERENCES PARKING_FLOOR(id)
);

CREATE TABLE TICKET(
id int PRIMARY KEY AUTO_INCREMENT,
parking_spot_id int FOREIGN KEY REFERENCES PARKING_SPOT(id),
vehicle_id int FOREIGN KEY REFERENCES VECHILE(id),
person_id int FOREIGN KEY REFERENCES PERSON(id),
issued_timestamp TIMESTAMP
)

CREATE TABLE PAYMENT(
id int PRIMARY KEY AUTO_INCREMENT,
payment_type ENUM('CREDIT_CARD', 'CASH'),
amount long,
payment_timestamp TIMESTAMP
ticket_id int FOREIGN KEY REFERENCES TICKET(id)
)
-- Use trigger to enforce a a constraint that limit of total parked vechiles cannot be more than 40k