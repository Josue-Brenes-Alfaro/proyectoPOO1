--Creación de la base de dato Proyecto_POO1
CREATE DATABASE Proyecto_POO1
--Se coloca en la base de datos Proyecto_POO1 para hacerle modificaciones
USE Proyecto_POO1;

CREATE TABLE EscuelaOArea(
  codigoCarrera varchar(20) NOT NULL,
  nombreCarrera varchar(70) NOT NULL,
  tieneEscuea bit NOT NULL,
  idPlan varchar(10),
  PRIMARY KEY (codigoCarrera),
);

CREATE TABLE PlanesPorEscuela (
 codigoCarrera varchar(20),
 idPlan varchar(10),
 FOREIGN KEY (idPlan) REFERENCES PlanDeEstudio (idPlan),
 FOREIGN KEY (codigoCarrera) REFERENCES EscuelaOArea (codigoCarrera)
);

CREATE TABLE CursosPorEscuela (
 codigoCarrera varchar(20),
 codigoCurso varchar(10),
 FOREIGN KEY (codigoCurso) REFERENCES Curso (codigoCurso),
 FOREIGN KEY (codigoCarrera) REFERENCES EscuelaOArea (codigoCarrera)
);

CREATE TABLE Curso(
  codigoCurso varchar(10) NOT NULL,
  nombreCurso varchar(70) NOT NULL,
  cantidadCreditos int NOT NULL,
  horasLectivas int NOT NULL,
  numBloque int NOT NULL,
  cantidadCursos int NOT NULL,
  PRIMARY KEY (codigoCurso)
);

CREATE TABLE PlanDeEstudio(
  idPlan varchar(10) NOT NULL,
  fechaVigencia datetime NOT NULL,
  cantidadCursos int NOT NULL,
  cantidadCreditos int NOT NULL,
  codigoCurso varchar(10) NOT NULL,
  PRIMARY KEY (idPlan)
);

CREATE TABLE CursosPorPlan (
 idPlan varchar(10),
 codigoCurso varchar(10),
 FOREIGN KEY (codigoCurso) REFERENCES Curso (codigoCurso),
 FOREIGN KEY (idPlan) REFERENCES PlanDeEstudio (idPlan),
);

CREATE TABLE Requisito(
  nombreCurso varchar(10),
  cursoRequisito varchar(10),
  cursoCorrequisito varchar(10),
  FOREIGN KEY (nombreCurso) REFERENCES Curso(codigoCurso),
  FOREIGN KEY (cursoRequisito) REFERENCES Curso(codigoCurso),
  FOREIGN KEY (cursoCorrequisito) REFERENCES Curso(codigoCurso)
);
