SELECT * FROM artists;
SELECT * FROM awards;
SELECT * FROM movies;
SELECT * FROM artists_movies;

SELECT id, first_name AS name, last_name, birth  FROM artists;

# 
SELECT id, first_name AS name, last_name, ((YEAR(CURRENT_DATE) - YEAR(birth)) - (DATE_FORMAT(CURRENT_DATE, '%m%d') < DATE_FORMAT(birth, '%m%d'))) AS age FROM artists;
-- SELECT id, first_name AS name, last_name, $date = ((YEAR(CURRENT_DATE) - YEAR(birth)) - (DATE_FORMAT(CURRENT_DATE, '%m%d') < DATE_FORMAT(birth, '%m%d'))) AS age FROM artists where 'date' > 40;

# LIMIT
SELECT id, first_name AS name, last_name, birth  FROM artists LIMIT 2;
SELECT id, first_name AS name, last_name, birth  FROM artists LIMIT 2 OFFSET 3;
-- SELECT id, first_name AS name, last_name, birth  FROM artists LIMIT 2 OFFSET 2*2;

# ORDER BY DESC 
SELECT id, first_name AS name, last_name, birth  FROM artists ORDER BY name, id DESC  ;

# DISTINCT
SELECT DISTINCT first_name FROM artists; 

# COUNT(), MAX(), MIN(), AVG(), SUM()
SELECT COUNT(*) AS count FROM artists;
SELECT MAX(birth) FROM artists; 

# UPDATE 
UPDATE  artists SET first_name = 'Mark_uptd' WHERE first_name = 'Mark'; 
UPDATE  artists SET first_name = 'Mark' WHERE first_name = 'Mark_uptd'; 

# DELETE 
DELETE FROM  awards where id = 8;

#
SELECT aw.artist_id FROM awards aw WHERE aw.date = '2008' LIMIT 1;
SELECT a.first_name, a.last_name  FROM artists a WHERE a.id = (SELECT aw.artist_id FROM awards aw WHERE aw.date = '2008' LIMIT 1);
SELECT a.first_name, a.last_name  FROM artists a WHERE a.first_name like '%on%';

SELECT a.first_name, a.last_name, aw.title , aw.date  FROM artists a, awards aw WHERE a.id = aw.artist_id;

SELECT aw.artist_id FROM awards aw GROUP BY aw.artist_id;	
SELECT a.first_name, a.last_name FROM artists a where a.id = ( SELECT aw.artist_id FROM awards aw WHERE COUNT(aw.artist_id));

SELECT aw.date FROM awards aw;
SELECT SUM(w.date) from (SELECT date FROM awards) AS w;

SELECT COUNT(aw.id) from awards aw inner join artists a on aw.artist_id = a.id where a.first_name = 'Brad';


SELECT a.first_name, a.last_name, mv.title from movies mv 
join artists_movies am on mv.id = am.movie_id 
JOIN artists a on a.id = am.artist_id 
WHERE a.FIRST_NAME like '%leo%';

SELECT COUNT(*),  title from awards WHERE date > 2000 GROUP BY title; 
SELECT AVG(id),  title from awards WHERE date > 2000 GROUP BY title; 
SELECT SUM(id),  title from awards WHERE date > 2000 GROUP BY title; 
SELECT SUM(id),  title from awards WHERE date > 2000 GROUP BY title HAVING SUM(id) > 15; 
SELECT COUNT(*) from awards;
SELECT m.id , title , release_date FROM movies m WHERE id = 1;