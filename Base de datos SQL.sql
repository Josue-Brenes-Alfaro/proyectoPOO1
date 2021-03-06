--Creación de la base de dato Proyecto_POO1
CREATE DATABASE Proyecto_POO1
--Se coloca en la base de datos Proyecto_POO1 para hacerle modificaciones
USE Proyecto_POO1;

CREATE TABLE EscuelaOArea(
  codigoCarrera varchar(20) NOT NULL,
  nombreCarrera varchar(70) NOT NULL,
  tieneEscuela bit NOT NULL,
  PRIMARY KEY (codigoCarrera),
);

CREATE TABLE PlanesPorEscuela (
 codigoCarrera varchar(20),
 idPlan varchar(10),
 FOREIGN KEY (idPlan) REFERENCES PlanDeEstudio (idPlan) 
 ON DELETE CASCADE,
 FOREIGN KEY (codigoCarrera) REFERENCES EscuelaOArea (codigoCarrera)
 ON DELETE CASCADE
);

CREATE TABLE CursosPorEscuela (
 codigoCarrera varchar(20),
 codigoCurso varchar(10),
 FOREIGN KEY (codigoCurso) REFERENCES Curso (codigoCurso) 
 ON DELETE CASCADE,
 FOREIGN KEY (codigoCarrera) REFERENCES EscuelaOArea (codigoCarrera)
 ON DELETE CASCADE,
);

CREATE TABLE Curso(
  codigoCurso varchar(10) NOT NULL,
  nombreCurso varchar(70) NOT NULL,
  cantidadCreditos int NOT NULL,
  horasLectivas int NOT NULL,
  cantidadCursos int NOT NULL,
  PRIMARY KEY (codigoCurso)
  );

CREATE TABLE PlanDeEstudio(
  idPlan varchar(10) NOT NULL,
  fechaVigencia datetime NOT NULL,
  cantidadCursos int NULL,
  cantidadCreditos int NULL,
  PRIMARY KEY (idPlan)
);

CREATE TABLE CursosPorPlan (
 idPlan varchar(10),
 codigoCurso varchar(10),
 numBloque int,
 FOREIGN KEY (codigoCurso) REFERENCES Curso (codigoCurso)
 ON DELETE CASCADE,
 FOREIGN KEY (idPlan) REFERENCES PlanDeEstudio (idPlan)
 ON DELETE CASCADE
);

CREATE TABLE Requisito(
  nombreCurso varchar(10),
  cursoRequisito varchar(10),
  cursoCorrequisito varchar(10),
  FOREIGN KEY (nombreCurso) REFERENCES Curso(codigoCurso) ON DELETE CASCADE,
  FOREIGN KEY (cursoRequisito) REFERENCES Curso(codigoCurso),
  FOREIGN KEY (cursoCorrequisito) REFERENCES Curso(codigoCurso)
);

INSERT INTO  Curso VALUES ('No tiene', 'No tiene ',0,0,0)
