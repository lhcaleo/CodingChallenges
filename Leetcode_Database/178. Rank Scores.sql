-- To determine the ranking of a score, count the number of distinct scores that are >= to that score
SELECT
    S1.Score 'Score',
    ( 
        SELECT 
            COUNT(DISTINCT Score) 
         FROM Scores S2 
         WHERE S2.Score >= S1.Score
    ) AS 'Rank'
FROM Scores S1
ORDER BY Score DESC
;

-- To determine the ranking of a score, count the number of distinct scores that are >= to that score
SELECT
    S1.Score 'Score',
    COUNT(DISTINCT S2.Score) AS 'Rank'
FROM Scores S1
     INNER JOIN Scores S2
     ON S2.Score >= S1.Score
GROUP BY
    S1.Id, S1.Score
ORDER BY 
    S1.Score DESC
;

SELECT S1.Score, COUNT(S2.Score) AS Rank FROM Scores S1,
(SELECT DISTINCT Score FROM Scores) AS S2
WHERE S2.Score >= S1.Score
GROUP BY S1.Id 
ORDER BY S1.Score DESC
;