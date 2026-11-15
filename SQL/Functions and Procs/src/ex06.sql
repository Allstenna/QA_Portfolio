CREATE OR REPLACE FUNCTION fnc_person_visits_and_eats_on_date(
  pperson VARCHAR DEFAULT 'Dmitriy', 
  pprice INTEGER DEFAULT 500, 
  pdate DATE DEFAULT '2022-01-08')
RETURNS TABLE(pizzeria_name VARCHAR) AS $$
BEGIN
  RETURN QUERY
  SELECT pizzeria.name 
  FROM person_visits
  JOIN person ON person.id = person_visits.person_id
  JOIN pizzeria ON pizzeria.id = person_visits.pizzeria_id
  JOIN menu ON pizzeria.id = menu.pizzeria_id
  WHERE person.name = pperson AND menu.price < pprice AND visit_date = pdate;
END
$$ LANGUAGE plpgsql;

SELECT * FROM fnc_person_visits_and_eats_on_date(pprice := 800);
SELECT * FROM fnc_person_visits_and_eats_on_date(pperson := 'Anna', pprice := 1300, pdate := '2022-01-01');