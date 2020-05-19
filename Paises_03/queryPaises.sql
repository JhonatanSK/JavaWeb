create database SistemaPaises;
use SistemaPaises;

create table paises(
	id int auto_increment primary key,
	nome varchar (100), 
	populacao bigint,
	area numeric (15,2)
);

insert into paises(nome, populacao, area) values ("Italia", 300000, 200.20);
insert into paises(nome, populacao, area) values ("Japão", 300000, 200.20);
insert into paises(nome, populacao, area) values ("Brasil", 400000, 200.20);

select * from paises;

CREATE TABLE usuario (
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	PRIMARY KEY (username));
