select * from role;

select c.id, first_name,name,date,hour,count-sell as remind from users
          inner join cinemamovie c on users.id = c.cinema_id
           inner join movie m on m.id = c.movie_id ;

select cinemamovie.id, first_name,name,date,hour,count-cinemamovie.sell from cinemamovie
    inner join movie m on m.id = cinemamovie.movie_id
    inner join users u on u.id = cinemamovie.cinema_id;


select * from users;




ALTER TABLE ticket
ADD COLUMN user_id int references users(id);

select count(*) from ticket where cinemamovie_id = 3;
UPDATE cinemamovie SET sell = 2 WHERE id = 3;

SELECT count-cinemamovie.sell  FROM cinemamovie  WHERE id = 1;




SELECT date ,hour FROM ticket INNER JOIN  cinemamovie c ON c.id = ticket.cinemamovie_id WHERE ticket.id = 7;

select t.id,u.first_name as cinema,m.name as moviename,c.date,c.hour, from ticket t
    inner join cinemamovie c on c.id = t.cinemamovie_id
    INNER JOIN movie m on m.id = c.movie_id
      INNER JOIN users u on u.id = c.cinema_id WHERE c.cinema_id = 4;
select * from cinemamovie
select *
from ticket;
select t.id,u.first_name,m.name,cm.date,cm.hour from cinemamovie cm
    inner join ticket t on cm.id = t.cinemamovie_id
    inner join users u on u.id = cm.cinema_id
   inner join movie m on m.id = cm.movie_id where cm.cinema_id =4 ;
select * from users
SELECT c.id, first_name,name,date,hour,count-sell as remind  FROM users
                         INNER JOIN cinemamovie c ON users.id = c.cinema_id
                          INNER JOIN movie m ON m.id = c.movie_id;


select * from movie;
select * from cinemamovie;
select * from movie where name like 'matrix'

SELECT m.id,U.first_name,  m.name,cm.date,m.time  FROM cinemamovie cm INNER JOIN movie m on m.id = cm.movie_id
INNER JOIN users u on u.id = cm.cinema_id
WHERE date = '2022-01-5';


SELECT m.id,u.first_name,m.name,c.date,c.hour FROM movie m INNER JOIN cinemamovie c on m.id = c.movie_id inner join users u on u.id = c.cinema_id WHERE m.name like 'Taxi'



SELECT c.id, first_name,name,date,hour,count-sell as remind  FROM users
                          INNER JOIN cinemamovie c ON users.id = c.cinema_id
                           INNER JOIN movie m ON m.id = c.movie_id;

select sum(sell) * 10  from cinemamovie where cinema_id = 4;