CREATE DATABASE ManejadorEscuela;

USE ManejadorEscuela;

create table alumnos(
	id int primary key not null auto_increment,
    nombre varchar(50) not null,
    email varchar(50) not null,
    edad int not null,
    genero varchar(50)
);

insert into alumnos(nombre, email, edad, genero)
values('Joaquin Coronado', 'joaquin@tecgurus.io', 25, 'm');

insert into alumnos(nombre, email, edad, genero)
values('Samantha Cavazos', 'Sammy@gmail.io', 7, 'f');

insert into alumnos(nombre, email, edad, genero)
values('Axl Cavazos', 'Axl@gmail.io', 14, 'm');

insert into alumnos(nombre, email, edad, genero)
values('Gyovanny Cavazos', 'Sammy@gmail.io', 38, 'm');

insert into alumnos(nombre, email, edad, genero)
values('Erika Cavazos', 'Sammy@gmail.io', 36, 'f');

SELECT * from alumnos;

UPDATE alumnos SET nombre="Wiggy Cavazos", email="wiggy2010@gmail.com" where id = 7;

CREATE TABLE cursos(
id int primary key auto_increment not null,
nombre varchar(50) not null
);
