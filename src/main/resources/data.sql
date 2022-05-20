create table `almacenes`
(
	`codigo` int,
    `lugar` varchar(100),
    `capacidad` int,
    primary key (`codigo`)
);

create table `cajas`
(
	`num_referencia` varchar(5),
    `contenido` varchar(100),
    `valor` int,
    `id_almacen` int,
    primary key (`num_referencia`),
    foreign key (`id_almacen`) references `almacenes`(`codigo`)
);

insert into `almacenes` (`codigo`, `lugar`, `capacidad`) values (1, 'Otro', 500);
insert into `almacenes` (`codigo`, `lugar`, `capacidad`) values (2, 'Cantabria', 4500);
insert into `almacenes` (`codigo`, `lugar`, `capacidad`) values (3, 'Santiago', 5500);
insert into `almacenes` (`codigo`, `lugar`, `capacidad`) values (4, 'Pontevedra', 2500);
insert into `almacenes` (`codigo`, `lugar`, `capacidad`) values (5, 'Ourense', 1500);

insert into `cajas` (`num_referencia`, `contenido`, `valor`, `id_almacen`) values ('C1', 'Tuercas', 1500, 1);
insert into `cajas` (`num_referencia`, `contenido`, `valor`, `id_almacen`) values ('C2', 'Tacos', 2500, 2);
insert into `cajas` (`num_referencia`, `contenido`, `valor`, `id_almacen`) values ('C3', 'Martillos', 3500, 3);
insert into `cajas` (`num_referencia`, `contenido`, `valor`, `id_almacen`) values ('C4', 'Destornilladores', 4500, 4);
insert into `cajas` (`num_referencia`, `contenido`, `valor`, `id_almacen`) values ('C5', 'Tornillos', 11500, 5);
