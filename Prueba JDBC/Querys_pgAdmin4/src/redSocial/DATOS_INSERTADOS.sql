INSERT INTO public.usuarios(
	id, username, email, role, created_at)
	VALUES ('1','johndoe', 'johndoe@siu.com', 'user', '2023-11-28 12:34:56'),
	('2','janedoe', 'jane@siu.com', 'admin', '2023-11-28 13:00:00'),
	('3','guestuser', 'guestu@siu.com', 'guest', '2023-11-28 14:15:30'),
	('4','admina', 'admins@siu.com', 'superadmin', '2023-11-28 15:45:00');

INSERT INTO public.posts(
    id, titulo, mensaje, user_id, estado, created_at)
VALUES ('1', 'Primer Post', 'Este es mi primer post.',	'1', 'published', '2023-11-28 12:35:00'),
       ('2', 'Segundo Post', 'Un segundo post de prueba.', '2','draft', '2023-11-28 13:05:15'),
       ('3', 'Post Interesante', '¡Mira este post!', '3', 'published', '2023-11-28 14:20:45'),
       ('4', 'Anuncio Importante', '¡Atención!', '4', 'published', '2023-11-28 15:50:30');

INSERT INTO public.comentarios(
    id, comentarios, user_id, post_id, estado, created_at)
VALUES ('1', 'Buen post!',	'2', '1', 'approved', '2023-11-28 12:40:00'),
       ('2', '¿Puedes explicar más?', '3', '2', 'pending', '2023-11-28 13:10:30'),
       ('3', '¡Excelente idea!', '1', '3', 'approved', '2023-11-28 14:25:15'),
       ('4', 'Gracias por compartir.', '4', '4', 'approved', '2023-11-28 15:55:01');

INSERT INTO public.seguidores(
    seguidor_user_id, seguido_user_id, created_at)
VALUES ('1', '2', '2023-11-28 12:45:00'),
       ('2', '1', '2023-11-28 13:15:15'),
       ('3', '4','2023-11-28 14:30:30'),
       ('4', '3','2023-11-28 15:55:45');


