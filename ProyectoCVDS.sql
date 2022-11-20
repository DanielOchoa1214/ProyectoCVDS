use bd2168821;

show tables ;

CREATE table RECURSO (
    `name` varchar(50) NOT NULL,
    `location` varchar(30) NOT NULL,
    `type` varchar(20) NOT NULL,
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
) ENGINE=InnoDB;

DROP TABLE RESERVA;
DROP TABLE RECURSO;

INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 'AJF-267', 10, 14, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 'AJF-268', 10, 14, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Academico', 'AJF-269', 10, 14, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo Integral', 'Pasillo 4 Estanteria 4', 'Academico', 'DGR-738', 10, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo Integral', 'Pasillo 4 Estanteria 4', 'Academico', 'DGR-634', 10, 17, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 'ALS-956', 10, 19, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 'ALS-957', 10, 19, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 'ALS-958', 10, 19, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Academico', 'ALS-959', 10, 19, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-230', 13, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-231', 13, 17, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-232', 13, 17, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-233', 13, 17, 'DISPONIBLE');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Fantasia', 'HGL-234', 13, 17, 'DISPONIBLE');

INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('portatil', 'Pedir el ventanilla', 'Academico', 'PSK-520', 7, 17, 'RESERVADO');
INSERT INTO RECURSO (name, location, type, id, booking_schedule_start, booking_schedule_end, resource_state) values ('portatil', 'Pedir el ventanilla', 'Academico', 'PSK-521', 7, 17, 'DISPONIBLE');

INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-001', 'ALS-958', 'Libro academico', '2022-11-02', '2022-11-02', '2022-11-03', false, NULL);
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-002', 'HGL-231', 'Libro narrativo', '2022-11-10', '2022-11-10', '2022-11-11', true, '2022-11-12');
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-003', 'HGL-232', 'Libro narrativo', '2022-11-11', '2022-11-11', '2022-11-12', false, NULL);
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate, recurrent, nextBookingDate) values ('RES-004', 'PSK-520', 'Portatil de uso academico', '2022-11-03', '2022-11-03', '2022-11-04', false, NULL);

DELETE FROM RECURSO WHERE id = 'PSK-520';
DELETE FROM RESERVA WHERE id = 'RES-004';

SELECT * FROM RECURSO;
SELECT * FROM RESERVA;


        SELECT
            r.name AS nameal,
            r.location AS location,
            r.type AS type,
            (SELECT c AS capacity FROM (SELECT name AS n, COUNT(name) AS c FROM RECURSO GROUP BY name) AS nc WHERE nameal = n) AS capacity,
            r.id AS id,
            r.booking_schedule_start AS booking_schedule_start,
            r.booking_schedule_end AS booking_schedule_start,
            r.resource_state AS resource_state
        FROM
            RECURSO as r
        WHERE
            r.name LIKE '% de tronos%' AND r.type = 'Fantasia';
