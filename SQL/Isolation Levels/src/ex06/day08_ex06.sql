-- SESSION #1
-- #1
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;

-- #3
SELECT SUM(rating) FROM pizzeria;

-- #6
SELECT SUM(rating) FROM pizzeria;

-- #7
COMMIT;

-- #8
SELECT SUM(rating) FROM pizzeria;

-- SESSION #2
-- #2
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;

-- #4
INSERT INTO pizzeria (id, name, rating)
VALUES (11, 'Kazan Pizza 2', 4);

-- #5
COMMIT;

-- #9
SELECT SUM(rating) FROM pizzeria;