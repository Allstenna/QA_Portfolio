CREATE INDEX idx_person_name
ON person (upper(name));

EXPLAIN ANALYZE
SELECT COUNT(DISTINCT upper(name)) FROM person