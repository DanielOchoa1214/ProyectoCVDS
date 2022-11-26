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

CREATE TABLE LIBRO (
    `id` varchar(10) NOT NULL,
    `author` varchar(50) NOT NULL,
    `hard_cover` BOOLEAN NOT NULL,
    `pages` INT NOT NULL,
    `genre` varchar(30) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_LIBRO_RECURSO_1` FOREIGN KEY (`id`) REFERENCES RECURSO(`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE PORTATIL (
    `id` varchar(10) NOT NULL,
    `RAM_model` varchar(50) NOT NULL,
    `hard_drive_model` varchar(50) NOT NULL,
    `processor` varchar(50) NOT NULL,
    `screen_resolution` varchar(20) NOT NULL,
    `brand` varchar(30) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_PORTATIL_RECURSO_1` FOREIGN KEY (`id`) REFERENCES RECURSO(`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE table RESERVA (
    `id` varchar(10) NOT NULL,
    `resource` varchar(10) NOT NULL,
    `infoResource` varchar(100) NOT NULL,
    `requestDate` DATE NOT NULL,
    `initialDate` DATE NOT NULL,
    `finalDate` DATE NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_RESERVA_RECURSO_1` FOREIGN KEY (`resource`) REFERENCES RECURSO(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_RESERVA_RECURSO_2` FOREIGN KEY (`infoResource`) REFERENCES RECURSO(`info`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE table RESERVA_RECURRENTE (
    `id` varchar(10) NOT NULL,
    `next_booking_date` DATE NULL,
    `recurrence` varchar(20) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_RESERVA_RECURRENTE_RESERVA_1` FOREIGN KEY (`id`) REFERENCES RESERVA(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE table RESERVA_UNICA (
    `id` varchar(10) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_RESERVA_UNICA_RESERVA_1` FOREIGN KEY (`id`) REFERENCES RESERVA(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

DELIMITER $$
DROP PROCEDURE IF EXISTS before_insert_libro;
CREATE PROCEDURE before_insert_libro(
    name varchar(50),
    location varchar(30),
    type varchar(20),
    id varchar(10),
    info varchar(100),
    booking_schedule_start int(3),
    booking_schedule_end int(3),
    resource_state varchar(20),
    author varchar(50),
    hard_cover boolean,
    pages int,
    genre varchar(30))
        BEGIN
            INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state);
            INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES (id, author, hard_cover, pages, genre);
        end $$

INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo vectorial', 'Pasillo 4 Estanteria 3', 'Libro', 'AJF-267', 'Libro de calculo usado en cursos de CALV', 10, 14, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('AJF-267', 'Tu madre', true, 300, 'Academico');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Libro', 'AJF-268', 'Libro de calculo usado en cursos de CALV', 10, 14, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('AJF-268', 'Tu madre', true, 300, 'Academico');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('Calculo vectorial', 'Pasillo 4 Estanteria 3', 'Libro', 'AJF-269', 'Libro de calculo usado en cursos de CALV', 10, 14, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('AJF-269', 'Tu madre', false, 300, 'Academico');


INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo Integral', 'Pasillo 4 Estanteria 4', 'Libro', 'DGR-738', 'Libro de calculo usado en cursos de CALI', 10, 17, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('DGR-738', 'Tu padre', true, 500, 'Academico');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo Integral', 'Pasillo 4 Estanteria 4', 'Libro', 'DGR-634', 'Libro de calculo usado en cursos de CALI', 10, 17, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('DGR-634', 'Tu padre', true, 500, 'Academico');


INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Libro', 'ALS-956', 'Libro de calculo usado en cursos de CALD', 10, 19, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('ALS-956', 'Tu hermano', true, 1000, 'Academico');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Libro', 'ALS-957', 'Libro de calculo usado en cursos de CALD', 10, 19, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('ALS-957', 'Tu hermano', true, 1000, 'Academico');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Libro', 'ALS-958', 'Libro de calculo usado en cursos de CALD', 10, 19, 'RESERVADO');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('ALS-958', 'Tu hermano', false, 1000, 'Academico');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('calculo diferencial', 'Pasillo 4 Estanteria 2', 'Libro', 'ALS-959', 'Libro de calculo usado en cursos de CALD', 10, 19, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('ALS-959', 'Tu hermano', true, 1000, 'Academico');


INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Libro', 'HGL-230', 'Libro para gente culta que ama la literatura', 13, 17, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('HGL-230', 'Jorge Martinez', true, 3000, 'Fantasia');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Libro', 'HGL-231', 'Libro para gente culta que ama la literatura', 13, 17, 'RESERVADO');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('HGL-231', 'Jorge Martinez', true, 3000, 'Fantasia');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Libro', 'HGL-232', 'Libro para gente culta que ama la literatura', 13, 17, 'RESERVADO');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('HGL-232', 'Jorge Martinez', false, 3000, 'Fantasia');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Libro', 'HGL-233', 'Libro para gente culta que ama la literatura', 13, 17, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('HGL-233', 'Jorge Martinez', false, 3000, 'Fantasia');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('juego de tronos', 'Pasillo 10 Estanteria 5', 'Libro', 'HGL-234', 'Libro para gente culta que ama la literatura', 13, 17, 'DISPONIBLE');
INSERT INTO LIBRO (id, author, hard_cover, pages, genre) VALUES ('HGL-234', 'Jorge Martinez', false, 3000, 'Fantasia');


INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('portatil', 'Pedir el ventanilla', 'Portatil', 'PSK-520', 'Portatil de todo uso para quienes quieran sufrir un poco mas en la universidad', 7, 17, 'RESERVADO');
INSERT INTO PORTATIL (id, RAM_model, hard_drive_model, processor, screen_resolution, brand) VALUES ('PSK-520', 'DDR3L 8gb 1600 Mhz Kingston', 'Disco generico','Intel', '3840x2160', 'Marca pollito');
INSERT INTO RECURSO (name, location, type, id, info, booking_schedule_start, booking_schedule_end, resource_state) values ('portatil', 'Pedir el ventanilla', 'Portatil', 'PSK-521', 'Portatil de todo uso para quienes quieran sufrir un poco mas en la universidad', 7, 17, 'DISPONIBLE');
INSERT INTO PORTATIL (id, RAM_model, hard_drive_model, processor, screen_resolution, brand) VALUES ('PSK-521', 'DDR3L 8gb 1600 Mhz Kingston', 'Disco generico','Intel', '3840x2160', 'Marca pollito');


INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate) values ('RES-001', 'ALS-958', 'Libro de calculo usado en cursos de CALD', '2022-11-02', '2022-11-02', '2022-11-03');
INSERT INTO RESERVA_UNICA (id) VALUES ('RES-001');
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate) values ('RES-003', 'HGL-232', 'Libro para gente culta que ama la literatura', '2022-11-11', '2022-11-11', '2022-11-12');
INSERT INTO RESERVA_UNICA (id) VALUES ('RES-003');
INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate) values ('RES-004', 'PSK-520', 'Portatil de todo uso para quienes quieran sufrir un poco mas en la universidad', '2022-11-03', '2022-11-03', '2022-11-04');
INSERT INTO RESERVA_UNICA (id) VALUES ('RES-004');

INSERT INTO RESERVA (id, resource, infoResource, requestDate, initialDate, finalDate) values ('RES-002', 'HGL-231', 'Libro para gente culta que ama la literatura', '2022-11-10', '2022-11-10', '2022-11-11');
INSERT INTO RESERVA_RECURRENTE (id, next_booking_date, recurrence) VALUES ('RES-002', '2022-11-12', 'DIARIO');

DELETE FROM RECURSO WHERE id = 'PSK-520';
DELETE FROM RECURSO WHERE id = 'ABC-123';
DELETE FROM RECURSO WHERE id = 'ABC-124';
DELETE FROM RESERVA WHERE id = 'RES-004';


DROP TABLE RESERVA_RECURRENTE;
DROP TABLE RESERVA_UNICA;
DROP TABLE RESERVA;
DROP TABLE LIBRO;
DROP TABLE PORTATIL;
DROP TABLE RECURSO;


SELECT * FROM RECURSO;
SELECT * FROM LIBRO;
SELECT * FROM RESERVA;
