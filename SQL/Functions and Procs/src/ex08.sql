CREATE OR REPLACE FUNCTION fnc_fibonacci(pstop INTEGER DEFAULT 10)
RETURNS TABLE(fibonacci_number INTEGER) AS $$
BEGIN
  RETURN QUERY
  WITH RECURSIVE fib(i, j) AS(
    SELECT 0, 1
    UNION ALL
    SELECT j, i + j
    FROM fib
    WHERE j < pstop
  )
  SELECT i FROM fib
  WHERE i < pstop;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM fnc_fibonacci(100);
SELECT * FROM fnc_fibonacci();