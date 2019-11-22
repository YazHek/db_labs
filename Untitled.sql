/*1*/
SELECT model, ram, price FROM Labor_SQL.Laptop WHERE ram=64 ORDER BY screen ASC;
/*2*/
SELECT name FROM Labor_SQL.Ships WHERE name LIKE 'w%n';
/*3*/
SELECT C1.model model1, C2.model model2, C1.ram, C1.speed FROM Labor_SQL.PC C1, PC C2 WHERE C1.ram = C2.ram AND C1.speed = C2.speed AND C1.model > C2.model;
/*4*/
SELECT ship, battle, date FROM Labor_SQL.Battles JOIN Outcomes ON battle=name WHERE result LIKE 'damaged';
/*55*/
SELECT maker FROM Labor_SQL.Product WHERE model IN (SELECT model FROM PC WHERE speed >= 750);
/*66*/
SELECT DATE_FORMAT(date, "%Y:%m:%e") AS DATE FROM Labor_SQL.Income;
/*77*/
SELECT PC.maker FROM ( SELECT maker FROM Product WHERE type='PC' GROUP BY maker HAVING COUNT(*)>=2) PC;
/*88*/
SELECT DISTINCT maker FROM Labor_SQL.Laptop INNER JOIN product ON laptop.model = product.model WHERE laptop.speed >= 600;
/*99*/
SELECT trip_no,plane, (CASE WHEN time_out > time_in THEN '12:00:00'-time_out+time_in+'12:00:00' ELSE time_in - time_out END ) airtime FROM trip;
/*10*/
SELECT name FROM ships WHERE name like '% % %' UNION SELECT ship FROM outcomes WHERE ship like '% % %'



