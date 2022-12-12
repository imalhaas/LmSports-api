CREATE TABLE categoria (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('Academia');
INSERT INTO categoria (nome) values ('Futebol');
INSERT INTO categoria (nome) values ('Basquete');
INSERT INTO categoria (nome) values ('Volei');
INSERT INTO categoria (nome) values ('Outros');