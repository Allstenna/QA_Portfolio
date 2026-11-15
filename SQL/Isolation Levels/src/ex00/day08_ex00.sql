-- SESSION #1
-- #1
BEGIN;

-- #2
UPDATE pizzeria
SET rating = 5.0
WHERE name = 'Pizza Hut';

-- #3
SELECT * FROM pizzeria
WHERE name = 'Pizza Hut';

-- #5
COMMIT;

-- SESSION #2
-- #4 и 6
SELECT * FROM pizzeria
WHERE name = 'Pizza Hut';