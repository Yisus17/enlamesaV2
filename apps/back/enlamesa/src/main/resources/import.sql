/* Creamos algunos usuarios con sus roles */
INSERT INTO `user` (enabled, password, username, name, last_name, email ) VALUES (1,'$2a$10$KWxRAw.xkrr4B7BBqcxBgOvPip9zxUr6PAlj0uvFLgbk1rnv6KsCO','jesus','jesus','arevalo', 'jaas1710@gmail.com'); 
INSERT INTO `user` (enabled, password, username) VALUES (1,'$2a$10$zDqxBNwgxziOBnTDo839MOgBVOCupatSvpF/yQf8.dDyvMuxoWOwi','admin','admin','ad_apellido','admin@admin.com');
INSERT INTO `user` (enabled, password, username, name, last_name, email ) VALUES (1,'$2a$10$GkUsW02zfert3sBn8vkoaedkUQTxsdXUtq0iwFJ6.nXG6DQlaLRJi','dora','dora','arevalo','dora@admin.com');

INSERT INTO `role` (name) VALUES ('ROLE_CLIENTE');
INSERT INTO `role` (name) VALUES ('ROLE_ADMIN');
INSERT INTO `role` (name) VALUES ('ROLE_EMPLEADO');

INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (95, 3);