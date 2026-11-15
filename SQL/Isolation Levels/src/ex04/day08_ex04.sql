-- SESSION #1
-- #1
BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;

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
BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;

-- #4
UPDATE pizzeria
SET rating = 3.0
WHERE name = 'Pizza Hut';

-- #5
COMMIT;

-- #9
SELECT * FROM pizzeria
WHERE name = 'Pizza Hut';