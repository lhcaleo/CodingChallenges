UPDATE salary
SET sex = 
    CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END
;
# or 
UPDATE salary
SET sex = 
    CASE
        WHEN sex ='m' THEN 'f'
        ELSE 'm'
    END
;

# IF(condition, value_if_true, value_if_false)
UPDATE salary
SET sex = IF (sex = 'm', 'f', 'm')
;
