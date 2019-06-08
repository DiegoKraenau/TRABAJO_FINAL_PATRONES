
use patronesTF

create table Alumno(
codigoAlumno varchar(20) primary key,
contrase�aAlumno varchar(20),
nombreAlumno varchar(50),
)

insert into Alumno values('u201710397','diego2009','Diego Kraenau')
insert into Alumno values('u20171A154','rodolfo2009','Rodolfo Arias')
insert into Alumno values('u201715840','miguel2009','Miguel Aspilcueta')
insert into Alumno values('u201621893','carlos2009','Carlos Rodriguez')
insert into Alumno values('u2017b079','diego2009','Diego Hilario')
insert into Alumno values('u201613518','guillermo2009','Guillermo Rosales')


create table Curso(
codigoCurso varchar(20) primary key,
nombreCurso varchar(50)
)

insert into Curso values('C001','Base de Datos')
insert into Curso values('C002','Dise�o y Patrones de Software')
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

create table Profesor(
codigoProfesor varchar(20) primary key,
contrase�aProfesor varchar(20),
nombreProfesor varchar(50)

)

insert into Profesor values('P001','maritza2009','Maritza Vilca')
insert into Profesor values('P002','sebastian2009','Sebastian Gimenez')


create table ProfesorCurso(
codigoProfesor2 varchar(20),
codigoCurso3 varchar(20),
constraint fk foreign key (codigoProfesor2) references Profesor(codigoProfesor),
constraint tk foreign key (codigoCurso3) references Curso(codigoCurso)
)



insert into ProfesorCurso values ('P001','C011')
insert into ProfesorCurso values ('P002','C011')

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

create table Salon(
codigoSalon varchar(20) primary key,
disponibilidad int
)



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
insert into Recomendacion values ('u201710397','P001','C011','Excelente Profesora',6)


create table TallerPresencial(
codigoTallerP int  not null IDENTITY(1,1) ,
salon varchar(20),
PRIMARY KEY(codigoTallerP)
)


