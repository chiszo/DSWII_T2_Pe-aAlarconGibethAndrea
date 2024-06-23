CREATE TABLE Autor
(
 IdAutor 		INT NOT NULL AUTO_INCREMENT,
 NomAutor		VARCHAR(50) NOT NULL,
 ApeAutor 		VARCHAR(50) NOT NULL,
 FechNacAutor	DATE NOT NULL,
 PRIMARY KEY (IdAutor)
);

CREATE TABLE Publicacion
(
 IdPublicacion 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Resumen 			VARCHAR(250) NOT NULL,
 FechPublicacion	DATE NOT NULL,
 IdAutor 			INT NOT NULL,
 PRIMARY KEY (IdPublicacion),
 FOREIGN KEY (IdAutor) REFERENCES Autor(IdAutor)
 );
INSERT INTO `autor` VALUES (1,'Edgar Allan','Poe','1809-01-19'),(2,'Cesar','Vallejo','1892-03-16'),(3,'Mario','Vargas Llosa','1936-03-28'),(4,'Ricardo','Palma','1833-02-07'),(5,'Julio Ramón','Ribeyro','1929-08-31'),(6,'Jareth','Prime','1809-01-19');
INSERT INTO `publicacion` VALUES (1,'El gato negro','Cuento de terror','1843-08-19',1),(2,'La ciudad y los perros','Esta novela dio fama a Mario Vargas Llosa','1963-01-01',3),(3,'Paco Yunque','Paco Yunque es el título de un cuento o relato corto de tipo infantil, del escritor peruano César Vallejo.','1951-01-01',2),(4,'Los heraldos negros','Los heraldos negros es el título de un libro de poemas escrito por el poeta peruano César Vallejo entre 1915 y 1918, y publicado por primera vez en julio de 1919.','1919-01-01',2),(5,'Trilce','Trilce es el poemario más importante y conocido del poeta peruano César Vallejo','1922-01-01',2),(6,'Gatita mimosa 123','miau miau miau miau','2023-08-19',6);