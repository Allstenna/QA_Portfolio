-- SESSION #1
-- #1
BEGIN TRANSACTION ISOLATION LEVEL READ COMMITTED;

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
BEGIN TRANSACTION ISOLATION LEVEL READ COMMITTED;

-- #4
INSERT INTO pizzeria (id, name, rating)
VALUES (10, 'Kazan Pizza', 5);

-- #5
COMMIT;

-- #9
SELECT SUM(rating) FROM pizzeria;