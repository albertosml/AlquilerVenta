CREATE TABLE Cliente (
id integer primary key autoincrement,
nombre varchar(60) );

CREATE TABLE Piso (
id integer primary key,
domicilio varchar(100),
inquilino integer,
preciomes float,
foreign key (inquilino) references Cliente(id) );

CREATE TABLE Elemento (
id integer primary key,
nombre varchar(30),
preciounidad float );

CREATE TABLE Venta (
idElemento integer,
cliente integer,
dia varchar(2),
mes varchar(10),
anio varchar(4),
cantidad float,
precio float,
foreign key (idElemento) references Elemento(id),
foreign key (cliente) references Cliente(id),
primary key (idElemento, cliente, dia, mes, anio) );

CREATE TABLE Alquiler (
idPiso integer,
mes varchar(10),
anio varchar(4),
inquilino integer,
precio float, concepto varchar(8),
foreign key (inquilino) references Piso(inquilino),
FOREIGN KEY (idPiso) REFERENCES Piso(id),
primary key (idPiso,mes,anio,concepto) );