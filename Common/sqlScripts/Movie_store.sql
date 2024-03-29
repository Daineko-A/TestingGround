-- CREATE DATABASE movie_store;
USE movie_store;
CREATE TABLE artists (id INT AUTO_INCREMENT, first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) UNIQUE NOT NULL, birth DATE NOT NULL, PRIMARY KEY(id));

INSERT INTO artists (first_name, last_name, birth) VALUES ('Timothée', 'Chalamet', '1995-01-27');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Matthew', 'McConaughey', '1969-11-04');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Rebecca', 'Ferguson', '1983-10-19');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Colin', 'Farrell', '1976-05-31');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Charlie', 'Hunnam', '1980-04-10');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Leonardo', 'DiCaprio', '1974-11-11');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Joseph', 'Gordon-Levitt', '1981-02-17');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Marion', 'Cotillard', '1975-09-30');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Jeremy', 'Renner', '1971-01-07');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Anne', 'Hathaway', '1982-11-12');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Mila', 'Kunis', '1983-08-14');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Brad', 'Pitt', '1963-12-18');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Johnny', 'Depp', '1963-06-09');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Matt', 'Damon', '1970-10-08');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Mark', 'Wahlberg', '1971-06-05');
INSERT INTO artists (first_name, last_name, birth) VALUES ('Tom', 'Hanks', '1956-07-09');

CREATE TABLE awards (id INT AUTO_INCREMENT, title VARCHAR(50) NOT NULL, date YEAR NOT NULL, artist_id INT, PRIMARY KEY(id), FOREIGN KEY(artist_id) REFERENCES artists(id));
INSERT INTO awards (title, artist_id, date) VALUES ('Golden Globe', 13, 2008 );
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 14, 1998);
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 6, 2016 );
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 2, 2014 );
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 12, 2020 );
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 12, 2014 );
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 10, 2013 );
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 8, 2008 );
INSERT INTO awards (title, artist_id, date) VALUES ('Golden Globe', 4, 2009 );
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 16, 1995 );
INSERT INTO awards (title, artist_id, date) VALUES ('Oscar', 16, 1994 );

CREATE TABLE movies (id INT AUTO_INCREMENT, title VARCHAR(50) UNIQUE NOT NULL, release_date YEAR NOT NULL, PRIMARY KEY(id));
INSERT INTO movies (title, release_date) VALUES ('Interstellar', 2014);
INSERT INTO movies (title, release_date) VALUES ('The Martian', 2015);
INSERT INTO movies (title, release_date) VALUES ('The Departed', 2006);
INSERT INTO movies (title, release_date) VALUES ('Inception', 2010);
INSERT INTO movies (title, release_date) VALUES ('Shutter Island', 2009);
INSERT INTO movies (title, release_date) VALUES ('Pirates of the Caribbean', 2003);
INSERT INTO movies (title, release_date) VALUES ('Fantastic Beasts and Where to Find Them', 2016);
INSERT INTO movies (title, release_date) VALUES ('Uncharted', 2022);
INSERT INTO movies (title, release_date) VALUES ('Ted', 2012);
INSERT INTO movies (title, release_date) VALUES ('Friends with Benefits', 2011);
INSERT INTO movies (title, release_date) VALUES ('Fight Club', 1999);
INSERT INTO movies (title, release_date) VALUES ('Snatch', 2000);
INSERT INTO movies (title, release_date) VALUES ('The Curious Case of Benjamin Button', 2008);
INSERT INTO movies (title, release_date) VALUES ('Forrest Gump', 1994);
INSERT INTO movies (title, release_date) VALUES ('Catch Me If You Can', 2002);
INSERT INTO movies (title, release_date) VALUES ('The Green Mile', 1999);
INSERT INTO movies (title, release_date) VALUES ('Finch', 2021);

CREATE TABLE artists_movies (artist_id INT NOT NULL, movie_id INT NOT NULL, PRIMARY KEY(artist_id, movie_id), FOREIGN KEY(artist_id) REFERENCES artists(id), FOREIGN KEY(movie_id) REFERENCES movies(id));
INSERT INTO artists_movies (artist_id, movie_id) VALUES (16 ,17);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (16 ,16);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (16 ,14);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (12 ,12);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (12 ,11);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (11 ,10);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (6 ,15);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (6 ,4);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (6 ,3);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (14 ,3);
INSERT INTO artists_movies (artist_id, movie_id) VALUES (15 ,3);


--ALTER TABLE table_name ADD column_name datatype;
--ALTER TABLE users ADD country TEXT default "United States";
--ALTER TABLE table_name RENAME COLUMN old_name TO new_name;

# DROP
-- DROP DATABASE DATABASE movie_store;
-- DROP TABLE artists;
-- DROP TABLE awards;
-- DROP TABLE movies;
-- DROP TABLE artists_movies;