CREATE DATABASE IF NOT EXISTS `disco`;
USE `disco`;

create table cantante(
numcan integer,
nombre varchar(30) not null,
nacionalidad varchar(30) not null,
edad integer,
primary key(numcan)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

create table album(
numalbum integer,
titulo varchar(30) not null,
precio integer,
categoria varchar(20),
numcan integer,
primary key(numalbum)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `Album`
  ADD CONSTRAINT `can_al` FOREIGN KEY (`numcan`) REFERENCES `cantante` (`numcan`) ON DELETE CASCADE;