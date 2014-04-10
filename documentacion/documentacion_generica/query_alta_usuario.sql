# Esta crea el esquema de BBDD
CREATE SCHEMA `db_hospital` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;

# Esta query te crea el usuario:d pwd:1
insert into db_hospital.usuario (nombre, apellidos, email, usuario, pwd, rol_id) 
values(1, 'Pepe', 'Pérez Alonso', 'dd@dd.com', 'd', 'c4ca4238a0b923820dcc509a6f75849b', 0);




