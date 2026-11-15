-- SESSION #1
-- #1
BEGIN TRANSACTION ISOLATION LEVEL READ COMMITTED;

-- #3
SELECT * FROM pizzeria
WHERE name = 'Pizza Hut';

-- #6
SELECT * FROM pizzeria
WHERE name = 'Pizza Hut';

-- #7
COMMIT;

-- #8
SELECT * FROM pizzeria
WHERE name = 'Pizza Hut';

-- SESSION #2
-- #2
BEGIN TRANSACTION ISOLATION LEVEL READ COMMITTED;

-- #4
UPDATE pizzeria
SET rating = 3.6
WHERE name = 'Pizza Hut';

-- #5
COMMIT;

-- #9
SELECT * FROM pizzeria
WHERE name = 'Pizza Hut';