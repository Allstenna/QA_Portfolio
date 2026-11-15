CREATE TABLE paths (
	point1 VARCHAR(1) NOT NULL,
	point2 VARCHAR(1) NOT NULL,
	cost INT CHECK (cost > 0),
	PRIMARY KEY (point1, point2)
);

INSERT INTO paths VALUES
	('a', 'b', 10), ('b', 'a', 10),
	('a', 'c', 15), ('c', 'a', 15),
	('a', 'd', 20), ('d', 'a', 20),
	('b', 'c', 35), ('c', 'b', 35),
	('b', 'd', 25), ('d', 'b', 25),
	('c', 'd', 30), ('d', 'c', 30);

WITH RECURSIVE tours AS (
	SELECT DISTINCT point1 AS current_p,
		   point1::VARCHAR AS tour,
		   point1 AS start_p,
		   0 AS total_cost,
		   1 AS visited_count
	FROM paths
	WHERE point1 = 'a'

	UNION ALL

	SELECT paths.point2,
		   CONCAT(tours.tour, ',', paths.point2)::VARCHAR,
		   tours.start_p,
		   tours.total_cost + paths.cost,
		   tours.visited_count + 1
	FROM tours
	JOIN paths ON paths.point1 = tours.current_p
	WHERE tours.visited_count < 4 AND
		  position(',' || paths.point2 || ',' IN ',' || tours.tour || ',') = 0
),

completed_tours AS (
	SELECT tours.total_cost + paths.cost AS total_cost,
	       '{' || tours.tour || ',' || tours.start_p || '}' AS tour
	FROM tours
	JOIN paths ON paths.point1 = tours.current_p AND paths.point2 = tours.start_p
	WHERE tours.visited_count = 4
)

SELECT total_cost, tour
FROM completed_tours
WHERE total_cost = (SELECT MIN(total_cost) FROM completed_tours) 
ORDER BY total_cost, tour;