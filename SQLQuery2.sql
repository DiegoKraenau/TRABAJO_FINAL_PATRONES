create database patronesTF
use patronesTF


create table Alumno(
codigoAlumno varchar(20) primary key,
contraseñaAlumno varchar(50),
nombreAlumno varchar(50),
)



insert into Alumno values('u201710397','diego2009','Diego Kraenau')
insert into Alumno values('u20171A154','rodolfo2009','Rodolfo Arias')
insert into Alumno values('u201715840','miguel2009','Miguel Aspilcueta')
insert into Alumno values('u201621893','carlos2009','Carlos Rodriguez')
insert into Alumno values('u20171B079','diego2009','Diego Hilario')
insert into Alumno values('201613518','guillermo2009','Guillermo Rosales')



create table Curso(
codigoCurso varchar(20) primary key,
nombreCurso varchar(50)
)

insert into Curso values('C001','Base de Datos')
insert into Curso values('C002','Diseño y Patrones de Software')
insert into Curso values('C003','Algoritmos')
insert into Curso values('C004','IHC')
insert into Curso values('C005','Fisica II')
insert into Curso values('C006','Aplicaciones Web')
insert into Curso values('C007','Open Source')
insert into Curso values('C008','Calculo 2')
insert into Curso values('C009','Arquitectura de computadoras y SO')
insert into Curso values('C010','Fisica III')
insert into Curso values('C011','Contabilidad')



create table AlumnoCurso(
codigoAlumno2 varchar(20),
codigoCurso2 varchar(20),

constraint fk_1 foreign key (codigoAlumno2) references Alumno(codigoAlumno),
constraint fk_2 foreign key (codigoCurso2) references Curso(codigoCurso)
)


insert into AlumnoCurso values('u201710397','C001')
insert into AlumnoCurso values('u201710397','C002')
insert into AlumnoCurso values('u201710397','C004')
insert into AlumnoCurso values('u201710397','C008')
insert into AlumnoCurso values('u201710397','C011')

insert into AlumnoCurso values('u201710397','C002')
insert into AlumnoCurso values('u20171A154','C006')
insert into AlumnoCurso values('u20171A154','C007')
insert into AlumnoCurso values('u20171A154','C008')
insert into AlumnoCurso values('u20171A154','C010')

insert into AlumnoCurso values('u201715840','C002')
insert into AlumnoCurso values('u201715840','C006')
insert into AlumnoCurso values('u201715840','C007')
insert into AlumnoCurso values('u201715840','C008')
insert into AlumnoCurso values('u201715840','C010')

insert into AlumnoCurso values('u201621893','C002')
insert into AlumnoCurso values('u201621893','C003')
insert into AlumnoCurso values('u201621893','C008')
insert into AlumnoCurso values('u201621893','C011')


insert into AlumnoCurso values('u201621893','C002')
insert into AlumnoCurso values('u201621893','C003')
insert into AlumnoCurso values('u201621893','C008')
insert into AlumnoCurso values('u201621893','C011')

insert into AlumnoCurso values('u20171B079','C002')
insert into AlumnoCurso values('u20171B079','C006')
insert into AlumnoCurso values('u20171B079','C007')
insert into AlumnoCurso values('u20171B079','C008')
insert into AlumnoCurso values('u20171B079','C009')

create table Profesor(
codigoProfesor varchar(20) primary key,
nombreProfesor varchar(30),
contraseñaProfesor varchar(40)
)


insert into Profesor values('P001','Maritza Vilca','maritza2009')
insert into Profesor values('P002','Sebastian Gimenez','sebastian2009')


SELECT * FROM Profesor

create table ProfesorCurso(
codigoProfesor2 varchar(20),
codigoCurso3 varchar(20),
constraint fk foreign key (codigoProfesor2) references Profesor(codigoProfesor),
constraint tk foreign key (codigoCurso3) references Curso(codigoCurso)
)



insert into ProfesorCurso values ('P001','C011')
insert into ProfesorCurso values ('P002','C011')
insert into ProfesorCurso values ('P002','C008')




create table Recomendacion(
codigoRecomendacion int  not null IDENTITY(1,1) ,
codigoAlumnoReco varchar(20),
codigoProfesorReco varchar(20),
codigoCursoReco varchar(20),
descripcionReco varchar(100),
puntuacion int,


PRIMARY KEY(codigoRecomendacion),
constraint fk_5 foreign key (codigoAlumnoReco) references Alumno(codigoAlumno),
constraint fk_6 foreign key (codigoProfesorReco) references Profesor(codigoProfesor),
constraint fk_7  foreign key (codigoCursoReco) references Curso(codigoCurso)
)


insert into Recomendacion values('u201710397','P001','C011','Mala Profesora',3)
insert into Recomendacion values('u201710397','P001','C011','Buena Profesora',4)
insert into Recomendacion values ('u201710397','P001','C011','Exelente Profesora',6)




create table Sede(
codigoSede varchar(20),

PRIMARY KEY(codigoSede)
)


insert into Sede values('Villa')
insert into Sede values('Monterrico')
insert into Sede values('San Miguel')
insert into Sede values('San Isidro')

create table SedeProfesor(
codigoProfesor3 varchar(20),
codigoSede2 varchar(20),
FOREIGN KEY (codigoProfesor3) references Profesor(codigoProfesor),
FOREIGN KEY (codigoSede2) references Sede(codigoSede),
)


insert into SedeProfesor values('P001','Villa')
insert into SedeProfesor values('P001','Monterrico')
insert into SedeProfesor values('P002','Villa')





create table Aula(
codigoAula varchar(20),
aforoAula int,

PRIMARY KEY(codigoAula)
)

insert into Aula values('H205',40)



create table TallerVirtual(
codigoTaller varchar(20),
nombreDia varchar(20),
nombreCur varchar(30) NULL,
nombrePro varchar(60)  NULL,
fecha varchar(60),
hora varchar(20),
fin varchar(20),
)

insert into TallerVirtual values('1010','Lunes','Calculo','JoelRojas','16/10/19','10:00','12:00')
/*insert into Taller values('2020','Martes','Martes','8:00','10:00',1,NULL,NULL)*/

Update TallerVirtual set fecha='5050',nombreDia='Martes' where codigoTaller='1010'


UPDATE Alumno Set contraseñaAlumno = 123 wHERE codigoAlumno = 'u20171A154'


SELECT * FROM Alumno


--INSERT INTO Alumno Values('u201710','123','Rodolfo fake')



create table Taller(
codigoTaller int Primary KEY IDENTITY(1,1),
fechaTaller Date,
horaTaller varchar(30),
codigoProfesor varchar(20),
codigoAula varchar(20),
codigoCurso varchar(20),
duracionTaller int,
codigoSede varchar(20),
vacantes int,

FOREIGN KEY (codigoProfesor) references Profesor(codigoProfesor),
FOREIGN KEY (codigoSede) references Sede(codigoSede),
FOREIGN KEY (codigoCurso) references Curso(codigoCurso),
FOREIGN KEY (codigoAula) references Aula(codigoAula)
)

create table TallerAlumno(
codigoTaller int,
codigoAlumno varchar(20),
FOREIGN KEY (codigoTaller) references Taller(codigoTaller),
FOREIGN KEY (codigoAlumno) references Alumno(codigoAlumno)
)

--DROP TABLE TallerAlumno
--DROP TABLE Taller

--Select * From Taller
--Select * From Aula

--INSERT INTO Taller Values('2019-06-06','10:00','P001','H205','C008','1','Villa','40')
--SELECT * FROM Taller
--INSERT INTO TallerAlumno Values(2,'u20171A154')
--SELECT * FROM TallerAlumno

--Select t.codigoTaller, t.fechaTaller, t.horaTaller, t.codigoProfesor, t.duracionTaller, t.codigoSede from Taller t INNER JOIN TallerAlumno ta on t.codigoTaller = ta.codigoTaller

INSERT INTO Aula values ('H205','40')
INSERT INTO Aula values ('H206','40')

INSERT INTO Aula values ('H207','40')
INSERT INTO Aula values ('H208','40')
INSERT INTO Aula values ('H209','30')
INSERT INTO Aula values ('H210','40')
INSERT INTO Aula values ('H211','30')
INSERT INTO Aula values ('H212','40')
INSERT INTO Aula values ('H213','30')
INSERT INTO Aula values ('H214','40')
INSERT INTO Aula values ('H215','30')

select*from AulaSede

create table AulaSede(
codigoAula2 varchar(20),
codigoSede3 varchar(20),
nombreDia varchar(20),
hora varchar(30),
fin varchar(30),
estado bit,
nombrePro varchar(60)  NULL,
nombreCur varchar(30) NULL,


FOREIGN KEY (codigoAula2) references Aula(codigoAula),
FOREIGN KEY (codigoSede3) references Sede(codigoSede)

)

INSERT INTO AulaSede values ('H207','Villa','Jueves','8:00','10:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H215','Villa','Jueves','8:00','10:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H208','Monterrico','Viernes','7:00','9:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H209','San Miguel','Sabado','11:00','1:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H210','Villa','Lunes','10:00','12:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H211','Monterrico','Martes','12:00','14:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H212','San Isidro','Miercoles','12:00','14:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H213','Villa','Jueves','16:00','18:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H214','Monterrico','Viernes','18:00','20:00','1',NULL,NULL)
INSERT INTO AulaSede values ('H215','San Isidro','Sabado','13:00','15:00','1',NULL,NULL)

