Hair Salon

Description
A web based application that the owner can a stylist and a client to the stylist and each client is assigned to one stylist.

Setup/Installation Requirements
For setup you need:
CREATE DATABASE hair_salon;

CREATE TABLE clients (id serial PRIMARY KEY, name varchar, description varchar);

CREATE TABLE stylists (id serial PRIMARY KEY, name varchar, description varchar);

gradle will download and install junit and spark

the 'gradle run' command will deploy the site to port 4567 by default

Technologies used
Java 1.8.0_101
Gradle 3.0
JUnit 4.+
Spark 2.3
Velocity Template Engine 1.7
Postgresql 9.6
Contributer
Macmillan kimutai
