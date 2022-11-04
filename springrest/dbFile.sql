CREATE DATABASE mydb;
use mydb
CREATE TABLE tbl_rooms(room_id INT PRIMARY KEY NOT NULL);
INSERT INTO tbl_rooms VALUES(101);
INSERT INTO tbl_rooms VALUES(102);
INSERT INTO tbl_rooms VALUES(103);
INSERT INTO tbl_rooms VALUES(104);

CREATE TABLE tbl_bookings(booking_id SERIAL PRIMARY KEY, room_id INT, first_name VARCHAR(100) NOT NULL, last_name VARCHAR(100) NOT NULL, booking_start_time TIMESTAMP,booking_end_time TIMESTAMP);;
