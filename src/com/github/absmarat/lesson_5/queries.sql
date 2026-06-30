\echo Выводит в консоль всех роботов
SELECT *
  FROM jaegers
ORDER BY model_name;

\echo ВЫВОДИТ В КОНСОЛЬ ТОЛЬКО НЕ УНИЧТОЖЕННЫХ РОБОТОВ
SELECT *
  FROM jaegers
WHERE status NOT IN ('Destroyed')
ORDER BY model_name;

\echo ВЫВОДИТ В КОНСОЛЬ ТОЛЬКО РОБОТОВ СЕРИИ МАРК-1 И МАРК-4
SELECT *
  FROM jaegers
WHERE mark IN (1, 4)
ORDER BY model_name;

\echo ВЫВОДИТ В КОНСОЛЬ ВСЕХ РОБОТОВ, КРОМЕ МАРК-1 И МАРК-4
SELECT *
  FROM jaegers
WHERE mark NOT IN (1, 4)
ORDER BY mark DESC;

\echo ВЫВОДИТ В КОНСОЛЬ САМЫХ СТАРЫХ РОБОТОВ
SELECT *
  FROM jaegers
WHERE launch = (SELECT MIN (launch)
                            FROM jaegers)
ORDER BY model_name;

\echo ВЫВОДИТ В КОНСОЛЬ РОБОТОВ, КОТОРЫЕ УНИЧТОЖИЛИ БОЛЬШЕ ВСЕХ KAIJU
SELECT model_name,
           mark,
           launch,
           kaiju_kill
  FROM jaegers
WHERE kaiju_kill = (SELECT MAX (kaiju_kill)
                               FROM jaegers)
ORDER BY model_name;

\echo ВЫВОДИТ В КОНСОЛЬ СРЕДНИЙ ВЕС РОБОТОВ
SELECT ROUND(AVG(weight), 3) AS avg_weight
  FROM jaegers;

\echo УВЕЛИЧИВАЕТ НА ЕДИНИЦУ КОЛИЧЕСТВО УБИТЫХ KAIJU У НЕ УНИЧТОЖЕННЫХ РОБОТОВ
UPDATE jaegers
      SET kaiju_kill = kaiju_kill + 1
 WHERE status NOT IN ('Destroyed');

SELECT *
  FROM jaegers
ORDER BY model_name;

\echo УДАЛЯЕТ ВСЕХ УНИЧТОЖЕННЫХ РОБОТОВ
DELETE FROM jaegers
WHERE status = 'Destroyed';

SELECT *
  FROM jaegers
ORDER BY model_name;







