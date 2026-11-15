-- SESSION #1
-- #1
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;

-- #3
UPDATE pizzeria
SET name = 'Dead'
WHERE id = 1;

-- #5
UPDATE pizzeria
SET name = 'Lock'
WHERE id = 2;

-- #7
COMMIT;

-- SESSION #2
-- #2
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;

-- #4
UPDATE pizzeria
SET name = 'Lock'
WHERE id = 2;

-- #6
UPDATE pizzeria
SET name = 'Dead'
WHERE id = 1;

-- #8
COMMIT;