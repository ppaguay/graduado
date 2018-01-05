ALTER TABLE graduado
add column foto  character varying(300)
--default photo for user 
UPDATE `graduado` SET `foto` = '/img/graduado.png'