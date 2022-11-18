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
) ENGINE=InnoDB;

CREATE table RESERVA (
    `id` varchar(10) NOT NULL,
    `resource` varchar(10) NOT NULL,
    `infoResource` varchar(50) NOT NULL,
    `requestDate` DATE NOT NULL,
    `initialDate` DATE NOT NULL,
    `finalDate` DATE NOT NULL,
    `recurrent` boolean NOT NULL,
    `nextBookingDate` DATE NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_RESERVA_RECURSO_1` FOREIGN KEY (`resource`) REFERENCES RECURSO(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    /* CONSTRAINT `FK_RESERVA_RECURSO_2` FOREIGN KEY (`infoResource`) REFERENCES RECURSO(`name`) */
) ENGINE=InnoDB;



DROP TABLE RESERVA;
DROP TABLE RECURSO;


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

INSERT INTO RECURSO (name, location, type, capacity, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Portatil', 'Pedir el ventanilla', 'Academico', 1, 'PSK-520', 7, 17, 'RESERVADO');

INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-001', 'ALS-958', 'Libro academico', '2022-11-02', '2022-11-02', '2022-11-03', false, NULL);
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-002', 'HGL-231', 'Libro narrativo', '2022-11-10', '2022-11-10', '2022-11-11', true, '2022-11-12');
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-003', 'HGL-232', 'Libro narrativo', '2022-11-11', '2022-11-11', '2022-11-12', false, NULL);
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-004', 'PSK-520', 'Portatil de uso academico', '2022-11-03', '2022-11-03', '2022-11-04', false, NULL);

DELETE FROM RECURSO WHERE id = '123';

SELECT * FROM RECURSO;
SELECT * FROM RESERVA;


