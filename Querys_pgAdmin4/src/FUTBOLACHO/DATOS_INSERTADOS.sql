INSERT INTO public.fases(
    idfase, nombre_fase)
VALUES ('1', 'Semi-Final'), ('2', 'Final');

INSERT INTO public.grupos(
    idgrupo, nombre_grupo)
VALUES ('1', 'A'), ('2', 'B');

INSERT INTO public.equipos(
    idequipo, nombre_equipo, pais, idgrupo)
VALUES ('1', 'CCP', 'Paraguay', '1'),
       ('2', 'OLIMPIA', 'Paraguay', '2'),
       ('3', 'BARCELONA', 'España', '1'),
       ('4', 'REAL MADRID', 'España', '2');

INSERT INTO public.partidos(
    idpartido, idfase)
VALUES ('1', '1'),
       ('2', '1'),
       ('3', '2');

INSERT INTO public.partido_equipo(
    idpartido, idequipo, resultado)
VALUES ('1', '1', 'WINNER'),
       ('1', '2', 'LOSER'),
       ('2', '3', 'LOSER'),
       ('2', '4', 'WINER'),
       ('3', '1', 'WINNER'),
       ('3', '4', 'LOSER');

INSERT INTO public.jugadores (
    idjugador, nombre_jugador, nacionalidad, idequipo)
VALUES( 1, 'Raul', 'Paraguaya', 1),
    (2, 'Antonio', 'Paraguaya', 2),
    (3, 'Gustavo', 'Española', 3),
    (4, 'Julian', 'Española', 4);