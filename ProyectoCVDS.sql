use bd2168821;

show tables ;

CREATE table RECURSO (
    `name` varchar(50) NOT NULL,
    `location` varchar(30) NOT NULL,
    `type` varchar(20) NOT NULL,
    `id` varchar(10) NOT NULL,
    `info` varchar(100) NOT NULL,
    `booking_schedule_start` int(3) NOT NULL,
    `booking_schedule_end` int(3) NOT NULL,
    `resource_state` varchar(20) NOT NULL,
    PRIMARY KEY (`id`),
    KEY(`info`)
) ENGINE=InnoDB;

CREATE TABLE Libro (
    `id` varchar(10) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_RESERVA_RECURSO_1` FOREIGN KEY (`id`) REFERENCES RECURSO(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE table RESERVA (
    `id` varchar(10) NOT NULL,
    `resource` varchar(10) NOT NULL,
    `infoResource` varchar(100) NOT NULL,
    `requestDate` DATE NOT NULL,
    `initialDate` DATE NOT NULL,
    `finalDate` DATE NOT NULL,
    `recurrent` boolean NOT NULL,
    `nextBookingDate` DATE NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_RESERVA_RECURSO_1` FOREIGN KEY (`resource`) REFERENCES RECURSO(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_RESERVA_RECURSO_2` FOREIGN KEY (`infoResource`) REFERENCES RECURSO(`info`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 'AJF-267', 'Libro de calculo usado en cursos de CALV', 10, 14, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 'AJF-268', 'Libro de calculo usado en cursos de CALV', 10, 14, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 'AJF-269', 'Libro de calculo usado en cursos de CALV', 10, 14, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo Integral', 'Pasillo 4 Estanteria 4', 'Academico', 'DGR-738', 'Libro de calculo usado en cursos de CALI', 10, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo Integral', 'Pasillo 4 Estanteria 4', 'Academico', 'DGR-634', 'Libro de calculo usado en cursos de CALI', 10, 17, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 'ALS-956', 'Libro de calculo usado en cursos de CALD', 10, 19, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 'ALS-957', 'Libro de calculo usado en cursos de CALD', 10, 19, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 'ALS-958', 'Libro de calculo usado en cursos de CALD', 10, 19, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 'ALS-959', 'Libro de calculo usado en cursos de CALD', 10, 19, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-230', 'Libro para gente culta que ama la literatura', 13, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-231', 'Libro para gente culta que ama la literatura', 13, 17, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-232', 'Libro para gente culta que ama la literatura', 13, 17, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-233', 'Libro para gente culta que ama la literatura', 13, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-234', 'Libro para gente culta que ama la literatura', 13, 17, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('portatil', 'Pedir el ventanilla', 'Academico', 'PSK-520', 'Portatil de todo uso para quienes quieran sufrir un poco mas en la universidad', 7, 17, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('portatil', 'Pedir el ventanilla', 'Academico', 'PSK-521', 'Portatil de todo uso para quienes quieran sufrir un poco mas en la universidad', 7, 17, 'DISPONIBLE');

INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-001', 'ALS-958', 'Libro de calculo usado en cursos de CALD', '2022-11-02', '2022-11-02', '2022-11-03', false, NULL);
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-002', 'HGL-231', 'Libro para gente culta que ama la literatura', '2022-11-10', '2022-11-10', '2022-11-11', true, '2022-11-12');
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-003', 'HGL-232', 'Libro para gente culta que ama la literatura', '2022-11-11', '2022-11-11', '2022-11-12', false, NULL);
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-004', 'PSK-520', 'Portatil de todo uso para quienes quieran sufrir un poco mas en la universidad', '2022-11-03', '2022-11-03', '2022-11-04', false, NULL);

DELETE FROM RECURSO WHERE id = 'PSK-520';
DELETE FROM RECURSO WHERE id = 'ABC-123';
DELETE FROM RECURSO WHERE id = 'ABC-124';
DELETE FROM RESERVA WHERE id = 'RES-004';

DROP TABLE RESERVA;
DROP TABLE RECURSO;


SELECT * FROM RECURSO;
SELECT * FROM RESERVA;
