use bd2168821;

show tables ;

CREATE table RECURSO (
    `name` varchar(50) NOT NULL,
    `location` varchar(30) NOT NULL,
    `type` varchar(20) NOT NULL,
    `capacity` int(3) NOT NULL,
    `id` varchar(10) NOT NULL,
    `booking_schedule_start` int(3) NOT NULL,
    `booking_schedule_end` int(3) NOT NULL,
    `resource_state` varchar(20) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE table RESERVA (
    `id` varchar(10) NOT NULL,
    `resource` varchar(10) NOT NULL,
    `infoResource` varchar(50) NOT NULL,
    `requestDate` int(3) NOT NULL,
    `initialDate` int(3) NOT NULL,
    `finalDate` int(3) NOT NULL,
    `recurrent` boolean NOT NULL,
    `nextBookingDate` int(3) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`resource`)
        REFERENCES RECURSO(`id`)

);


DROP TABLE RECURSO;
DROP TABLE RESERVA;

INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 3, 'AJF-267', 10, 14, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 3, 'AJF-268', 10, 14, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 3, 'AJF-269', 10, 14, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo Integral', 'Pasillo 4 Estanteria 4', 'Academico', 2, 'DGR-738', 10, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo Integral', 'Pasillo 4 Estanteria 4', 'Academico', 2, 'DGR-634', 10, 17, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 4, 'ALS-956', 10, 19, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 4, 'ALS-957', 10, 19, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 4, 'ALS-958', 10, 19, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 4, 'ALS-959', 10, 19, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 5, 'HGL-230', 13, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 5, 'HGL-231', 13, 17, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 5, 'HGL-232', 13, 17, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 5, 'HGL-233', 13, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 5, 'HGL-234', 13, 17, 'DISPONIBLE');



SELECT * FROM RECURSO;



