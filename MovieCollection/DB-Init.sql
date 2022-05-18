-- Create DB and user
CREATE DATABASE moviesdb;
CREATE USER moviesdbuser with ENCRYPTED PASSWORD '<preferred-password>';


-- Create required tables
CREATE TABLE UserData (
	username VARCHAR ( 50 ) NOT NULL,
	id INT PRIMARY KEY,
	password VARCHAR ( 50 ) NOT NULL,
	email_id VARCHAR ( 255 ) UNIQUE NOT NULL,
	f_name VARCHAR ( 50 ) NOT NULL,
	l_name VARCHAR ( 50 ) NOT NULL,
	sex VARCHAR ( 50 ) NOT NULL,
	dob VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE UserImage (
	id INT PRIMARY KEY,
	image bytea
);

CREATE TABLE TimeLog (
	userid VARCHAR ( 50 ) PRIMARY KEY,
	lastlogin VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE MovieData (
	name VARCHAR ( 255 ) PRIMARY KEY,
	lead_actor VARCHAR ( 255 ),
	other_actor VARCHAR ( 255 ),
	details VARCHAR ( 255 ),
	genre VARCHAR ( 50 ),
	rating VARCHAR ( 50 ),
	language VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE MovieImage (
	name VARCHAR ( 255 ) PRIMARY KEY,
	image bytea
);

CREATE TABLE MoviePath (
	name VARCHAR ( 255 ) PRIMARY KEY,
	path VARCHAR ( 255 ) NOT NULL
);


-- Provide all priviledges to the DB user
GRANT ALL PRIVILEGES ON DATABASE moviesdb TO moviesdbuser;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public to moviesdbuser;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public to moviesdbuser;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public to moviesdbuser;
