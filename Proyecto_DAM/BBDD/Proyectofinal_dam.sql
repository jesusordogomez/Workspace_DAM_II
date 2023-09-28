create schema if not exists proyectofinal_DAM;
use proyectofinal_DAM;

-- TABLAS

CREATE TABLE `proyectofinal_dam`.`Usuario` (
  `Usuario` VARCHAR(45) NOT NULL,
  `Contraseña` INT NOT NULL,
  `Rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Usuario`));


create table centro_ed(
Id_centro int not null primary key auto_increment,
nombre_centro varchar(45) not null,
cod_seneca varchar(30) not null,
ubicacion varchar(45) not null,
num_telefono int,
correo_electronico varchar(45),
l_activo boolean not null,
observaciones varchar(45)
);

create table centro_nivel(
Id_centro int not null,
Id_nivel int not null,
primary key (Id_centro,Id_nivel)
);

create table nivel_ed(
Id_nivel int not null primary key auto_increment,
nombre varchar(70) not null,
descripcion varchar(45),
codigo varchar(10) not null,
rama varchar(45) not null,
observaciones varchar(45),
index FK_Indx_id_nivel(Id_nivel)
);

create table personal(
Id_personal int not null primary key auto_increment,
nombre varchar(45) not null,
apellido1 varchar(45) not null,
apellido2 varchar(45),
NIF varchar(9) not null,
num_telefono int,
correo_electronico varchar(60),
cargo varchar(70),
titulacion varchar(70),
observaciones varchar(45),
l_activo boolean not null,
Id_centro int not null,
Id_curso int,
cod_departamento int not null
);

create table curso(
Id_curso int not null primary key auto_increment,
nombre_curso varchar(45) not null,
id_nivel int not null ,
n_maximo int not null,
inicio_curso int not null,
fin_curso int not null,
observaciones varchar(45),
cod_aula int not null
);

create table convocatorias(
cod_convocatoria int not null primary key auto_increment,
descripcion varchar(45) not null,
l_ordinaria boolean not null,
observaciones varchar(100),
Id_curso int not null
);

create table aulas(
cod_aula int not null primary key auto_increment,
descripcion varchar(45) not null,
codigo_aula int not null,
ubicacion varchar (45) not null,
capacidad int not null,
l_activo boolean not null,
observaciones varchar(45)
);

create table departamentos(
cod_departamento int not null primary key auto_increment,
nombre_departamento varchar(45) not null,
descripcion varchar(45) not null,
codigo varchar(10) not null,
rama varchar(45) not null,
l_activo boolean not null,
observaciones varchar(45)
);

create table imparte(
Id_curso int not null,
cod_materia int not null,
primary key(Id_curso,cod_materia)
);

create table materias(
cod_materia int not null primary key auto_increment,
nombre_materia varchar(70) not null,
descripcion varchar(45) not null,
nomenclatura varchar(10) not null,
n_horas int not null,
coste double not null,
l_activo boolean not null,
observaciones varchar(45),
cod_departamento int not null
);

create table notas(
cod_nota int not null primary key auto_increment,
curso int not null,
valor_nota int,
observaciones varchar(45),
cod_alumnos int not null,
cod_convocatoria int not null,
cod_materia int not null
);

create table matricula(
cod_alumnos int not null,
Id_curso int not null,
primary key(cod_alumnos,Id_curso)
);

create table alumnos(
cod_alumnos int not null primary key auto_increment,
matricula int not null,
dni varchar(45) not null,
nombre_alumno varchar(45) not null,
apellido1_alumno varchar(45) not null,
apellido2_alumno varchar(45),
cod_postal int not null,
localidad varchar(45) not null,
provincia varchar(45),
domicilio varchar(45) not null,
numero_telefono int not null,
correo_electronico varchar(45) not null,
fecha_nacimiento date not null,
observaciones varchar(45)
);

CREATE TABLE `proyectofinal_dam`.`nivel_curso` (
  `Id_nivel` INT NOT NULL,
  `Id_curso` INT NOT NULL,
  PRIMARY KEY (`Id_nivel`, `Id_curso`),
  INDEX `FK_NivelCurso_idx` (`Id_curso` ASC) VISIBLE,
  CONSTRAINT `FK_Nivel_nivel`
    FOREIGN KEY (`Id_nivel`)
    REFERENCES `proyectofinal_dam`.`nivel_ed` (`Id_nivel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_NivelCurso`
    FOREIGN KEY (`Id_curso`)
    REFERENCES `proyectofinal_dam`.`curso` (`Id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- FOREIGN KEY
alter table personal
add constraint FK_Persona_Centro
foreign key (Id_centro) references centro_ed(ID_centro),
add constraint FK_Persona_Curso
foreign key (Id_curso) references curso(Id_curso),
add constraint FK_Persona_Departamento
foreign key (cod_departamento) references departamentos(cod_departamento);

alter table convocatorias
add constraint FK_Convocatoria_curso
foreign key (Id_curso) references curso(Id_curso);

alter table imparte
add constraint FK_Imparte_Materia
foreign key (cod_materia) references materias(cod_materia),
add constraint FK_Imparte_Curso
foreign key (Id_curso) references curso(Id_curso);

alter table materias
add constraint FK_Materia_Departamento
foreign key (cod_departamento) references departamentos(cod_departamento);

alter table matricula
add constraint FK_Matricula_alumno
foreign key(cod_alumnos) references alumnos(cod_alumnos),
add constraint FK_Matricula_Curso
foreign key (Id_curso) references curso(Id_curso);

alter table notas
add constraint FK_Notas_Alumnos
foreign key (cod_alumnos) references alumnos(cod_alumnos),
add constraint FK_Notas_Convocatoria
foreign key (cod_convocatoria) references convocatorias(cod_convocatoria),
add constraint FK_Notas_Materia
foreign key (cod_materia) references materias(cod_materia);

alter table centro_nivel
add constraint FK_Centro_Nivel
foreign key (Id_centro) references centro_ed (Id_centro),
add constraint FK_Nivel_Centro
foreign key (Id_nivel) references nivel_ed (Id_nivel);

alter table curso
add constraint FK_Curso_Nivel
foreign key (Id_nivel) references nivel_ed(Id_nivel),
add constraint FK_Curso_Aula
foreign key (cod_aula) references aulas(cod_aula);


-- INSERTAMOS LOS REGISTROS

-- ALUMNOS
INSERT INTO alumnos (cod_alumnos, matricula, dni, nombre_alumno, apellido1_alumno, apellido2_alumno, cod_postal, localidad, provincia, domicilio, numero_telefono, correo_electronico, fecha_nacimiento, observaciones) 
VALUES
(default, 1001, '12345678P', 'Pedro', 'Gómez', 'Martínez', 41008, 'Sevilla', 'Sevilla', 'Calle Principal 123', 954456789, 'juan@gmail.com', '2005-01-01', ''),
(default, 1002, '23456789D', 'María', 'García', 'López', 40503, 'Sevilla', 'Sevilla', 'Calle Secundaria 456', 954567890, 'maria@gmail.com', '2005-02-02', ' '),
(default, 1003, '34567890G', 'Pedro', 'Rodríguez', 'Sánchez', 40102, 'Sevilla', 'Sevilla', 'Calle Principal 789', 954678901, 'pedro@gmail.com', '2005-03-03', ''),
(default, 1004, '45678901E', 'Laura', 'López', 'Fernández', 40531, 'Sevilla', 'Sevilla', 'Calle Secundaria 012', 954789012, 'laura@gmail.com', '2005-04-04', ''),
(default, 1005, '56789012S', 'Carlos', 'González', 'Martínez', 45326, 'Sevilla', 'Sevilla', 'Calle Principal 345', 954890123, 'carlos@gmail.com', '2005-05-05', ''),
(default, 1006, '67890123E', 'Ana', 'Fernández', 'Ramírez', 49012, 'Sevilla', 'Sevilla', 'Calle Secundaria 678', 954901234, 'ana@gmail.com', '2005-06-06', ''),
(default, 1007, '78901234G', 'David', 'Martínez', 'Gómez', 46307, 'Sevilla', 'Sevilla', 'Calle Principal 901', 954012345, 'david@gmail.com', '2005-07-07', ''),
(default, 1008, '89012345T', 'Sara', 'Ramírez', 'Gómez', 40000, 'Sevilla', 'Sevilla', 'Calle Secundaria 234', 954123456, 'sara@gmail.com', '2005-08-08', ''),
(default, 1009, '90123456G', 'Javier', 'Sánchez', 'López', 41000, 'Sevilla', 'Sevilla', 'Calle Principal 567', 954234567, 'javier@gmail.com', '2005-09-09', ''),
(default, 1010, '12345678K', 'Marina', 'Sánchez', 'López', 41020, 'Sevilla', 'Sevilla', 'Calle Secundaria 890', 954456780, 'marina@gmail.com', '2005-10-10', '');


 
 -- CENTRO_ED
INSERT INTO centro_ed (Id_centro, nombre_centro, cod_seneca, ubicacion, num_telefono, correo_electronico, l_activo, observaciones)
VALUES ('1', 'Ilerna', '12345', 'Av. de la Innovación, 7-9', '954041212', 'ilerna@gmail.com', '1', '');


-- NIVEL_ED
INSERT INTO nivel_ed (Id_nivel, nombre, descripcion, codigo, rama, observaciones) 
VALUES 
('1', 'FP Grado Superior', '', '1234', 'FP Grado Superior', ''),
('2', 'Educación Infantil', '', '4321', 'Infantil', ''),
('3', 'Primaria', '', '2341', 'Primaria', ''),
('4', 'ESO', '', '3214', 'Educacion Secundaria Obligatoria', ''),
('5', 'Universidad', '', '4411', 'Universidad', '');


-- AULAS
INSERT INTO aulas (cod_aula, descripcion, codigo_aula, ubicacion, capacidad, l_activo, observaciones)
VALUES
('1', 'Aula informática', '124', '124', '25', '1', ' '),
('2', 'Aula multimedia', '126', '126', '25', '1', ' '),
('3', 'Aula de estimulación', '223', '223', '30', '1', ' '),
('4', 'Aula interactiva', '226', '226', '30', '0', ''),
('5', 'Aula promocional', '115', '115', '30', '1', ' '),
('6', 'Aula de análisis', '114', '114', '30', '0', ' '),
('7', 'Aula de odontología', '122', '122', '32', '1', ' '),
('8', 'Aula de cuidado oral', '121', '121', '35', '1', ' '),
('9', 'Aula de simulación', '213', '213', '27', '0', ''),
('10', 'Aula de realidad virtual', '216', '216', '28', '1', '');

-- DEPARTAMENTOS
INSERT INTO departamentos (cod_departamento, nombre_departamento, descripcion, codigo, rama, l_activo, observaciones)
 VALUES 
('1', 'Departamento de Profesores', 'Gestión informática', 'INF', 'Informática', '1', ''),
('2', 'Departamento de Profesores', 'Gestión sanitaria', 'SAN', 'Sanidad', '1', ''),
('3', 'Departamento de Profesores', 'Gestión de educación', 'INF', 'Infantil', '1', ''),
('4', 'Departamento de Profesores', 'Gestión comercial', 'COM', 'Comercio', '1', ''),
('5', 'Departamento de Mantenimiento', 'Gestión de limpieza', 'LIM', 'Limpieza', '1', ''),
('6', 'Departamento de Mantenimiento', 'Gestión Tecnica', 'TEC', 'Técnico', '1', ''),
('7', 'Departamento de Consejería', 'Gestión de atención', 'CONS', 'Conserje', '0', ''),
('8', 'Departamento de  Dirección', 'Gestión directiva', 'DIR', 'Directivo', '1', ''),
('9', 'Departamento de Secretaría', 'Gestión administrativa', 'ADM', 'Administrativo', '1', '');

-- cursos
INSERT INTO curso (Id_curso, nombre_curso, id_nivel, n_maximo, inicio_curso, fin_curso, observaciones, cod_aula)
VALUES
('1', '1º DAM', '1', '25', '2023', '2024', '', 1),
('2', '2º DAM', '1', '25', '2024', '2025', '', 2),
('3', '1º Educacion Infantil', '1', '30', '2023', '2024', '', 3),
('4', '2º Educacion Infantil', '1', '30', '2024', '2025', '', 4),
('5', '1º Marketing y Publicidad', '1', '30', '2023', '2024', '', 5),
('6', '2º  Marketing y Publicidad', '1', '30', '2024', '2025', '', 6),
('7', '1º Higiene bucodental', '1', '32', '2023', '2024', '', 7),
('8', '2º Higiene bucodental', '1', '35', '2024', '2025', '', 8),
('9', '1º Animaciones 3D', '1', '27', '2023', '2024', '', 9),
('10', '2º Animaciones 3D', '1', '28', '2024', '2025', '', 10);
-- MATERIAS
INSERT INTO materias (cod_materia, nombre_materia, descripcion, nomenclatura, n_horas, coste, l_activo, observaciones, cod_departamento) 
VALUES 
(default, 'Bases de datos', '', 'BBDD', '245', '350', '1', '', 1),
(default, 'Entornos de desarrollo', '', 'ED', '210', '350', '1', '', 1),
(default, 'Formación y orientación laboral', '', 'FOL', '100', '350', '1', '', 1),
(default, 'Lenguajes de marcas', '', 'LDM', '110', '350', '1', '', 1),
(default, 'Programación', '', 'PRO', '230', '350', '1', '', 1),
(default, 'Sistemas informáticos', '', 'SSII', '150', '350', '1', '', 1),
(default, 'Acceso a datos', '', 'AADD', '210', '280', '1', '', 1),
(default, 'Desarrollo de interfaces', '', 'DI', '140', '280', '1', '', 1),
(default, 'Empresa e iniciativa emprendedora', '', 'EIE', '160', '280', '1', '', 1),
(default, 'Formación en centros de trabajo', '', 'FCT', '120', '280', '1', '', 1),
(default, 'Programación de servicios y procesos', '', 'PSP', '170', '280', '1', '', 1),
(default, 'Programación multimedia y dispositivos móviles', '', 'PMD', '95', '280', '0', '', 1),
(default, 'Proyecto de desarrollo de aplicaciones multiplataforma', '', 'PDAM', '121', '280', '1', '', 1),
(default, 'Sistemas de gestión empresarial', '', 'SGE', '245', '280', '1', '', 1),
(default, 'Autonomía personal y salud infantil', '', 'APSI', '120', '310', '1', '', 3),
(default, 'Desarrollo cognitivo y motor', '', 'DCM', '132', '310', '1', '', 3),
(default, 'Desarrollo socio afectivo', '', 'DSA', '112', '310', '0', '', 3),
(default, 'Didáctica de la educación infantil', '', 'DEI', '190', '310', '1', '', 3),
(default, 'Formación y orientación laboral', '', 'FOL', '100', '310', '1', '', 3),
(default, 'Intervención con familias y atención a menores en riesgo social', '', 'IFAMRS', '140', '310', '1', '', 3),
(default, 'Primeros auxilios', '', 'PA', '150', '310', '1', '', 3),
(default, 'El juego infantil y su metodología', '', 'JIM', '160', '290', '1', '', 3),
(default, 'Empresa e iniciativa emprendedora', '', 'EIE', '70', '290', '1', '', 3),
(default, 'Expresión y comunicación', '', 'EC', '120', '290', '0', '', 3),
(default, 'Formación en centros de trabajo', '', 'FCT', '111', '290', '0', '', 3),
(default, 'Habilidades sociales', '', 'HS', '245', '290', '1', '', 3),
(default, 'Proyecto de atención a la infancia', '', 'PAI', '123', '290', '1', '', 3),
(default, 'Atención al cliente, consumidor y usuario', '', 'ACCU', '245', '300', '1', '', 4),
(default, 'Formación y orientación laboral', '', 'FOL', '100', '300', '1', '', 4),
(default, 'Gestión económica y financiera de la empresa', '', 'GEF', '170', '300', '1', '', 4),
(default, 'Inglés', '', 'ING', '100', '300', '1', '', 4),
(default, 'Investigación comercial', '', 'IC', '110', '300', '0', '', 4),
(default, 'Políticas de marketing', '', 'PM', '120', '300', '1', '', 4),
(default, 'Diseño y elaboración de material de comunicación', '', 'DEMC', '120', '300', '1', '', 4),
(default, 'Formación en centros de trabajo', '', 'FCT', '120', '300', '1', '', 4),
(default, 'Lanzamiento de productos y servicios', '', 'LPS', '102', '300', '1', '', 4),
(default, 'Marketing digital', '', 'MD', '103', '300', '1', '', 4),
(default, 'Medios y soportes de comunicación', '', 'MSC', '104', '300', '1', '', 4),
(default, 'Proyecto de marketing y publicidad', '', 'PMP', '105', '300', '0', '', 4),
(default, 'Relaciones públicas y organización de eventos de marketing', '', 'RPOE', '106', '300', '1', '', 4),
(default, 'Trabajo de campo en la investigación comercial', '', 'TCIC', '120', '300', '1', '', 4),
(default, 'Estudio de la cavidad oral', '', 'ESCO', '160', '320', '1', '', 2),
(default, 'Exploración de la cavidad oral', '', 'EXCO', '150', '320', '1', '', 2),
(default, 'Fisiopatología general', '', 'FG', '145', '320', '1', '', 2),
(default, 'Formación y orientación laboral', '', 'FOL', '100', '320', '1', '', 2),
(default, 'Intervención bucodental', '', 'IB', '120', '320', '1', '', 2),
(default, 'Primeros auxilios', 'Primeros auxilios - PA (200)', 'PA', '200', '320', '1', '', 2),
(default, 'Conservadora, periodoncia, cirugía e implantes', '', 'CPCI', '140', '320', '1', '', 2),
(default, 'Educación para la salud oral', '', 'EDSO', '135', '320', '1', '', 2),
(default, 'Empresa e iniciativa emprendedora', '', 'EIE', '70', '320', '0', '', 2),
(default, 'Epidemiología en salud oral', '', 'EPSO', '121', '320', '0', '', 2),
(default, 'Prótesis y ortodoncia', '', 'PO', '180', '320', '1', '', 2),
(default, 'Recepción y logística en la clínica dental', '', 'RLCD', '145', '320', '1', '', 2),
(default, 'Formación en centros de trabajo', '', 'FCT', '100', '320', '1', '', 2),
(default, 'Proyecto de higiene bucodental', '', 'PHB', '175', '320', '1', '', 2),
(default, 'Animación de elementos 2D y 3D', '', 'A2D3D', '120', '340', '1', '', 1),
(default, 'Color, iluminación y acabados 2D y 3D', '', 'CIA2D3D', '123', '340', '1', '', 1),
(default, 'Diseño, dibujo y modelado para animación', '', 'DDMA', '160', '340', '1', '', 1),
(default, 'Formación y Orientación Laboral', '', 'FOL', '100', '340', '0', '', 1),
(default, 'Realización de proyectos multimedia interactivos', '', 'RPMI', '180', '340', '0', '', 1),
(default, 'Desarrollo de entornos interactivos multidispositivo', '', 'DEIM', '120', '290', '1', '', 1),
(default, 'Empresa e iniciativa emprendedora', '', 'EIE', '70', '290', '1', '', 1),
(default, 'Formación en Centros de Trabajo', '', 'FCT', '70', '290', '1', '', 1),
(default, 'Proyecto de animaciones 3D, juegos y entornos interactivos', '', 'PA3DJI', '120', '290', '0', '', 1),
(default, 'Proyectos de animación audiovisual 2D y 3D', '', 'PAA2D3D', '95', '290', '1', '', 1),
(default, 'Proyectos de juegos y entornos interactivos', '', 'PJEI', '115', '290', '1', '', 1),
(default, 'Realización del montaje y postproducción de audiovisuales', '', 'RMPA', '110', '290', '1', '', 1);


-- personal
INSERT INTO personal (Id_personal, nombre, apellido1, apellido2, NIF, num_telefono, correo_electronico, cargo, titulacion, observaciones, l_activo, Id_centro, Id_curso, cod_departamento) 
VALUES
('1', 'Lorena', 'Romero', 'Torres', '12345678F', '968574654', 'lorenatowers@gmail.com', 'Limpiador', 'ESO', '', 1, 1, null, 5),
('2', 'Antonio', 'Pepito', 'Grillo', '91827364H', '968612312', 'antoinegrill@gmail.com', 'Limpiador', 'ESO', '', 1, 1, null, 5),
('3', 'Jesus', 'I', 'T', '51515151K', '912321321', 'jesusIT@gmail.com', 'Técnico', 'Titulación en Técnico de Mantenimiento Electrónico', '', 1, 1, null, 6),
('4', 'Jesus', 'Real', 'Betis', '11111112P', '908231232', 'jesusRB@gmail.com', 'Conserje', 'Titulación en Gestión de Edificios y Conserjería', '', 1, 1, null, 7),
('5', 'Olga', 'Bustra', 'Javascri', '92929291J', '933212312', 'olgaBustra@gmail.com', 'Profesor', 'Titulación en Informática y Desarrollo', '', 1, 1, 1, 1),
('6', 'Virginia', 'Direc', 'Tora', '12312312C', '919191911', 'virginiaDT@gmail.com', 'Directora', 'Titulación en Dirección y Administración', '', 1, 1, null, 8),
('7', 'Tomás', 'Tur', 'Bado', '76543287K', '912631273', 'turbaTomas@gmail.com', 'Secretario', 'Titulación en Secretariado y Administración', '', 1, 1, null, 9),
('8', 'Juan Carlos', 'Ja', 'Va', '22222222Y', '987444212', 'JCjava@gmail.com', 'Profesor', 'Ingeniero informático', '', 1, 1, 1, 1);

-- centro nivel
INSERT INTO centro_nivel (Id_centro, Id_nivel) 
VALUES 
('1', '1'),
('1', '2'),
('1', '3'),
('1', '4'),
('1', '5');


-- imparte
INSERT INTO imparte (Id_curso, cod_materia) 
VALUES 
('1', '1'),
('1', '2'),
('1', '3'),
('1', '4'),
('1', '5'),
('1', '6'),
('2', '7'),
('2', '8'),
('2', '9'),
('2', '10'),
('2', '11'),
('2', '12'),
('2', '13'),
('2', '14'),
('3', '15'),
('3', '16'),
('3', '17'),
('3', '18'),
('3', '19'),
('3', '20'),
('3', '21'),
('4', '22'),
('4', '23'),
('4', '24'),
('4', '25'),
('4', '26'),
('4', '27'),
('5', '28'),
('5', '29'),
('5', '30'),
('5', '31'),
('5', '32'),
('5', '33'),
('6', '34'),
('6', '35'),
('6', '36'),
('6', '37'),
('6', '38'),
('6', '39'),
('6', '40'),
('6', '41'),
('7', '42'),
('7', '43'),
('7', '44'),
('7', '45'),
('7', '46'),
('7', '47'),
('8', '48'),
('8', '49'),
('8', '50'),
('8', '51'),
('8', '52'),
('8', '53'),
('8', '54'),
('8', '55'),
('9', '56'),
('9', '57'),
('9', '58'),
('9', '59'),
('9', '60'),
('10', '61'),
('10', '62'),
('10', '63'),
('10', '64'),
('10', '65'),
('10', '66'),
('10', '67');


-- convocatoria
INSERT INTO convocatorias (cod_convocatoria, descripcion, l_ordinaria, observaciones, Id_curso)
 VALUES
('1', '1º Trimestre', '1', 'Ordinaria', '1'),
('2', '1º Trimestre', '0', 'Extrataordinaria', '1'),
('3', '2º Trimestre', '1', 'Ordinaria', '1'),
('4', '2º Trimestre', '0', 'Extrataordinaria', '1'),
('5', '3º Trimestre', '1', 'Ordinaria', '1'),
('6', '3º Trimestre', '0', 'Extrataordinaria', '1'),
('7', '1º Trimestre', '1', 'Ordinaria', '2'),
('8', '1º Trimestre', '0', 'Extrataordinaria', '2'),
('9', '2º Trimestre', '1', 'Ordinaria', '2'),
('10', '2º Trimestre', '0', 'Extrataordinaria', '2'),
('11', '3º Trimestre', '1', 'Ordinaria', '2'),
('12', '3º Trimestre', '0', 'Extrataordinaria', '2'),
('13', '1º Trimestre', '1', 'Ordinaria', '3'),
('14', '1º Trimestre', '0', 'Extrataordinaria', '3'),
('15', '2º Trimestre', '1', 'Ordinaria', '3'),
('16', '2º Trimestre', '0', 'Extrataordinaria', '3'),
('17', '3º Trimestre', '1', 'Ordinaria', '3'),
('18', '3º Trimestre', '0', 'Extrataordinaria', '3'),
('19', '1º Trimestre', '1', 'Ordinaria', '4'),
('20', '1º Trimestre', '0', 'Extrataordinaria', '4'),
('21', '2º Trimestre', '1', 'Ordinaria', '4'),
('22', '2º Trimestre', '0', 'Extrataordinaria', '4'),
('23', '3º Trimestre', '1', 'Ordinaria', '4'),
('24', '3º Trimestre', '0', 'Extrataordinaria', '4'),
('25', '1º Trimestre', '1', 'Ordinaria', '5'),
('26', '1º Trimestre', '0', 'Extrataordinaria', '5'),
('27', '2º Trimestre', '1', 'Ordinaria', '5'),
('28', '2º Trimestre', '0', 'Extrataordinaria', '5'),
('29', '3º Trimestre', '1', 'Ordinaria', '5'),
('30', '3º Trimestre', '0', 'Extrataordinaria', '5'),
('31', '1º Trimestre', '1', 'Ordinaria', '6'),
('32', '1º Trimestre', '0', 'Extrataordinaria', '6'),
('33', '2º Trimestre', '1', 'Ordinaria', '6'),
('34', '2º Trimestre', '0', 'Extrataordinaria', '6'),
('35', '3º Trimestre', '1', 'Ordinaria', '6'),
('36', '3º Trimestre', '0', 'Extrataordinaria', '6'),
('37', '1º Trimestre', '1', 'Ordinaria', '7'),
('38', '1º Trimestre', '0', 'Extrataordinaria', '7'),
('39', '2º Trimestre', '1', 'Ordinaria', '7'),
('40', '2º Trimestre', '0', 'Extrataordinaria', '7'),
('41', '3º Trimestre', '1', 'Ordinaria', '7'),
('42', '3º Trimestre', '0', 'Extrataordinaria', '7'),
('43', '1º Trimestre', '1', 'Ordinaria', '8'),
('44', '1º Trimestre', '0', 'Extrataordinaria', '8'),
('45', '2º Trimestre', '1', 'Ordinaria', '8'),
('46', '2º Trimestre', '0', 'Extrataordinaria', '8'),
('47', '3º Trimestre', '1', 'Ordinaria', '8'),
('48', '3º Trimestre', '0', 'Extrataordinaria', '8'),
('49', '1º Trimestre', '1', 'Ordinaria', '9'),
('50', '1º Trimestre', '0', 'Extrataordinaria', '9'),
('51', '2º Trimestre', '1', 'Ordinaria', '9'),
('52', '2º Trimestre', '0', 'Extrataordinaria', '9'),
('53', '3º Trimestre', '1', 'Ordinaria', '9'),
('54', '3º Trimestre', '0', 'Extrataordinaria', '9'),
('55', '1º Trimestre', '1', 'Ordinaria', '10'),
('56', '1º Trimestre', '0', 'Extrataordinaria', '10'),
('57', '2º Trimestre', '1', 'Ordinaria', '10'),
('58', '2º Trimestre', '0', 'Extrataordinaria', '10'),
('59', '3º Trimestre', '1', 'Ordinaria', '10'),
('60', '3º Trimestre', '0', 'Extrataordinaria', '10');

-- matricula
INSERT INTO matricula (cod_alumnos, Id_curso) 
VALUES 
('1', '1'),
('2', '2'),
('3', '3'),
('4', '4'),
('5', '5'),
('6', '6'),
('7', '7'),
('8', '8'),
('9', '9'),
('10', '10');

-- NOTAS
INSERT INTO notas (cod_nota, curso, valor_nota, cod_alumnos, cod_convocatoria, cod_materia)
VALUES
('1', '1', '9', '1', '1', '1'),
 ('2', '1', '5', '1', '3', '1'),
 ('3', '1', '8', '1', '5', '1'),
 ('4', '1', '7', '1', '1', '2'),
 ('5', '1', '9', '1', '3', '2'),
 ('6', '1', '6', '1', '5', '2'),
 ('7', '1', '5', '1', '1', '3'),
 ('8', '1', '7', '1', '3', '3'),
 ('9', '1', '8', '1', '5', '3'),
 ('10', '1', '9', '1', '1', '4'),
 ('11', '1', '5', '1', '3', '4'),
 ('12', '1', '5', '1', '5', '4'),
 ('13', '1', '6', '1', '1', '5'),
 ('14', '1', '8', '1', '3', '5'),
 ('15', '1', '9', '1', '5', '5'),
 ('16', '1', '10', '1', '1', '6'),
 ('17', '1', '6', '1', '3', '6'),
 ('18', '1', '8', '1', '5', '6'),
 ('19', '2', '7', '2', '7', '7'),
 ('20', '2', '9', '2', '9', '7'),
 ('21', '2', '5', '2', '11', '7'),
 ('22', '2', '6', '2', '7', '8'),
 ('23', '2', '7', '2', '9', '8'),
 ('24', '2', '9', '2', '11', '8'),
 ('25', '2', '4', '2', '7', '9'),
 ('26', '2', '5', '2', '9', '9'),
 ('27', '2', '9', '2', '10', '9'),
 ('28', '2', '8', '2', '11', '9'),
 ('29', '2', '7', '2', '7', '10'),
 ('30', '2', '6', '2', '9', '10'),
 ('31', '2', '9', '2', '11', '10'),
 ('32', '2', '6', '2', '7', '11'),
 ('33', '2', '7', '2', '9', '11'),
 ('34', '2', '8', '2', '11', '11'),
 ('35', '2', '5', '2', '7', '12'),
 ('36', '2', '6', '2', '9', '12'),
 ('37', '2', '7', '2', '11', '12'),
 ('38', '2', '8', '2', '7', '13'),
 ('39', '2', '9', '2', '9', '13'),
 ('40', '2', '6', '2', '11', '13'),
 ('41', '2', '8', '2', '7', '14'),
 ('42', '2', '7', '2', '9', '14'),
 ('43', '2', '6', '2', '11', '14'),
 ('44', '3', '8', '3', '13', '15'),
 ('45', '3', '9', '3', '15', '15'),
 ('46', '3', '7', '3', '17', '15'),
 ('47', '3', '6', '3', '13', '16'),
 ('48', '3', '6', '3', '15', '16'),
 ('49', '3', '8', '3', '17', '16'),
 ('50', '3', '7', '3', '13', '17'),
 ('51', '3', '6', '3', '15', '17'),
 ('52', '3', '8', '3', '17', '17'),
 ('53', '3', '9', '3', '13', '18'),
 ('54', '3', '8', '3', '15', '18'),
 ('55', '3', '7', '3', '17', '18'),
 ('56', '3', '6', '3', '13', '19'),
 ('57', '3', '8', '3', '15', '19'),
 ('58', '3', '9', '3', '17', '19'),
 ('59', '3', '6', '3', '13', '20'),
 ('60', '3', '8', '3', '15', '20'),
 ('61', '3', '6', '3', '17', '20'),
 ('62', '3', '8', '3', '13', '21'),
 ('63', '3', '7', '3', '15', '21'),
 ('64', '3', '9', '3', '17', '21'),
 ('65', '4', '6', '4', '19', '22'),
 ('66', '4', '5', '4', '21', '22'),
 ('67', '4', '8', '4', '23', '22'),
 ('68', '4', '7', '4', '19', '23'),
 ('69', '4', '5', '4', '21', '23'),
 ('70', '4', '6', '4', '23', '23'),
 ('71', '4', '6', '4', '19', '24'),
 ('72', '4', '7', '4', '21', '24'),
 ('73', '4', '6', '4', '23', '24'),
 ('74', '4', '8', '4', '19', '25'),
 ('75', '4', '7', '4', '21', '25'),
 ('76', '4', '6', '4', '23', '25'),
 ('77', '4', '5', '4', '19', '26'),
 ('78', '4', '8', '4', '21', '26'),
 ('79', '4', '3', '4', '23', '26'),
 ('80', '4', '9', '4', '24', '26'),
 ('81', '4', '8', '4', '19', '27'),
 ('82', '4', '7', '4', '21', '27'),
 ('83', '4', '6', '4', '23', '27'),
 ('84', '5', '5', '5', '25', '28'),
 ('85', '5', '7', '5', '27', '28'),
 ('86', '5', '9', '5', '29', '28'),
 ('87', '5', '6', '5', '25', '29'),
 ('88', '5', '8', '5', '27', '29'),
 ('89', '5', '7', '5', '29', '29'),
 ('90', '5', '6', '5', '25', '30'),
 ('91', '5', '9', '5', '27', '30'),
 ('92', '5', '5', '5', '29', '30'),
 ('93', '5', '8', '5', '25', '31'),
 ('94', '5', '9', '5', '27', '31'),
 ('95', '5', '6', '5', '29', '31'),
 ('96', '5', '6', '5', '25', '32'),
 ('97', '5', '7', '5', '27', '32'),
 ('98', '5', '6', '5', '29', '32'),
 ('99', '5', '7', '5', '25', '33'),
 ('100', '5', '6', '5', '27', '33'),
 ('101', '5', '5', '5', '29', '33'),
 ('102', '6', '5', '6', '31', '34'),
 ('103', '6', '6', '6', '33', '34'),
 ('104', '6', '8', '6', '35', '34'),
 ('105', '6', '9', '6', '31', '35'),
 ('106', '6', '7', '6', '33', '35'),
 ('107', '6', '5', '6', '35', '35'),
 ('108', '6', '9', '6', '31', '36'),
 ('109', '6', '6', '6', '33', '36'),
 ('110', '6', '8', '6', '35', '36'),
 ('111', '6', '6', '6', '31', '37'),
 ('112', '6', '7', '6', '33', '37'),
 ('113', '6', '8', '6', '35', '37'),
 ('114', '6', '5', '6', '31', '38'),
 ('115', '6', '6', '6', '33', '38'),
 ('116', '6', '9', '6', '35', '38'),
 ('117', '6', '0', '6', '31', '39'),
 ('118', '6', '6', '6', '32', '39'),
 ('119', '6', '9', '6', '33', '39'),
 ('120', '6', '9', '6', '35', '39'),
 ('121', '6', '6', '6', '31', '40'),
 ('122', '6', '8', '6', '33', '40'),
 ('123', '6', '7', '6', '35', '40'),
 ('124', '6', '6', '6', '31', '41'),
 ('125', '6', '5', '6', '33', '41'),
 ('126', '6', '8', '6', '35', '41'),
 ('127', '7', '9', '7', '37', '42'),
 ('128', '7', '7', '7', '39', '42'),
 ('129', '7', '7', '7', '41', '42'),
 ('130', '7', '9', '7', '37', '43'),
 ('131', '7', '8', '7', '39', '43'),
 ('132', '7', '6', '7', '41', '43'),
 ('133', '7', '5', '7', '37', '44'),
 ('134', '7', '6', '7', '39', '44'),
 ('135', '7', '8', '7', '41', '44'),
 ('136', '7', '9', '7', '37', '45'),
 ('137', '7', '7', '7', '39', '45'),
 ('138', '7', '8', '7', '41', '45'),
 ('139', '7', '9', '7', '37', '46'),
 ('140', '7', '9', '7', '39', '46'),
 ('141', '7', '6', '7', '41', '46'),
 ('142', '7', '8', '7', '37', '47'),
 ('143', '7', '7', '7', '39', '47'),
 ('144', '7', '8', '7', '41', '47'),
 ('145', '8', '6', '8', '43', '48'),
 ('146', '8', '9', '8', '45', '48'),
 ('147', '8', '6', '8', '47', '48'),
 ('148', '8', '8', '8', '43', '49'),
 ('149', '8', '6', '8', '45', '49'),
 ('150', '8', '5', '8', '47', '49'),
 ('151', '8', '6', '8', '43', '50'),
 ('152', '8', '5', '8', '45', '50'),
 ('153', '8', '5', '8', '47', '50'),
 ('154', '8', '5', '8', '43', '51'),
 ('155', '8', '6', '8', '45', '51'),
 ('156', '8', '9', '8', '47', '51'),
 ('157', '8', '8', '8', '43', '52'),
 ('158', '8', '8', '8', '45', '52'),
 ('159', '8', '7', '8', '47', '52'),
 ('160', '8', '1', '8', '43', '53'),
 ('161', '8', '6', '8', '44', '53'),
 ('162', '8', '5', '8', '45', '53'),
 ('163', '8', '9', '8', '47', '53'),
 ('164', '8', '6', '8', '43', '54'),
 ('165', '8', '7', '8', '45', '54'),
 ('166', '8', '2', '8', '47', '54'),
 ('167', '8', '5', '8', '48', '54'),
 ('168', '8', '9', '8', '43', '55'),
 ('169', '8', '8', '8', '45', '55'),
 ('170', '8', '9', '8', '47', '55'),
 ('171', '9', '6', '9', '49', '56'),
 ('172', '9', '8', '9', '51', '56'),
 ('173', '9', '6', '9', '53', '56'),
 ('174', '9', '9', '9', '49', '57'),
 ('175', '9', '5', '9', '51', '57'),
 ('176', '9', '6', '9', '53', '57'),
 ('177', '9', '5', '9', '49', '58'),
 ('178', '9', '5', '9', '51', '58'),
 ('179', '9', '6', '9', '53', '58'),
 ('180', '9', '8', '9', '49', '59'),
 ('181', '9', '9', '9', '51', '59'),
 ('182', '9', '6', '9', '53', '59'),
 ('183', '9', '8', '9', '49', '60'),
 ('184', '9', '9', '9', '51', '60'),
 ('185', '9', '6', '9', '53', '60'),
 ('186', '10', '7', '10', '55', '61'),
 ('187', '10', '8', '10', '57', '61'),
 ('188', '10', '7', '10', '59', '61'),
 ('189', '10', '8', '10', '55', '62'),
 ('190', '10', '7', '10', '57', '62'),
 ('191', '10', '9', '10', '59', '62'),
 ('192', '10', '8', '10', '55', '63'),
 ('193', '10', '7', '10', '57', '63'),
 ('194', '10', '5', '10', '59', '63'),
 ('195', '10', '6', '10', '55', '64'),
 ('196', '10', '9', '10', '57', '64'),
 ('197', '10', '6', '10', '59', '64'),
 ('198', '10', '9', '10', '55', '65'),
 ('199', '10', '8', '10', '57', '65'),
 ('200', '10', '7', '10', '59', '65'),
 ('201', '10', '8', '10', '55', '66'),
 ('202', '10', '9', '10', '57', '66'),
 ('203', '10', '6', '10', '59', '66'),
 ('204', '10', '8', '10', '55', '67'),
 ('205', '10', '9', '10', '57', '67'),
 ('206', '10', '6', '10', '59', '67');
 
 -- NIVEL_CURSO
INSERT INTO `proyectofinal_dam`.`nivel_curso` (`Id_nivel`, `Id_curso`) 
VALUES 
('1', '1'),
('1', '2'),
('1', '3'),
('1', '4'),
('1', '5'),
('1', '6'),
('1', '7'),
('1', '8'),
('1', '9'),
('1', '10');

-- IDENTIFICACION
INSERT INTO Usuario (Usuario, Contraseña, Rol) 
VALUES ('profesor', '111', 'profesor'),
('secretaria', '222', 'secretaria'),
('director', '333', 'direccion');

