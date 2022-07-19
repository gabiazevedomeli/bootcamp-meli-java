DROP SCHEMA IF EXISTS company;
CREATE SCHEMA company;
USE company;

CREATE TABLE departamento(
                             depto_nro VARCHAR(10) PRIMARY KEY NOT NULL,
                             nome_depto VARCHAR(30) NOT NULL,
                             localizacao VARCHAR(30) DEFAULT NULL
) ENGINE=INNODB;

INSERT INTO departamento(depto_nro, nome_depto, localizacao)
VALUES ('D-000-1', 'Software', 'Los Tigres'),
       ('D-000-2', 'Sistemas', 'Guadalupe' ),
       ('D-000-3', 'Contabilidade', 'La Roca'),
       ('D-000-4', 'Vendas', 'Plata');

CREATE TABLE funcionario(
                            cod_func VARCHAR(10) PRIMARY KEY NOT NULL,
                            nome VARCHAR(30) NOT NULL ,
                            sobrenome VARCHAR(30) NOT NULL,
                            cargo VARCHAR(30) NOT NULL,
                            data_alta DATE,
                            salario INTEGER NOT NULL,
                            comissao INTEGER DEFAULT 0,
                            depto_nro VARCHAR(10),
                            FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
) ENGINE=INNODB;

INSERT INTO funcionario(cod_func, nome, sobrenome, cargo, data_alta, salario, comissao, depto_nro)
VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
       ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
       ('E-0003', 'Mariela', 'Barrios', 'Diretor', '2014-06-05', 185000, 0, 'D-000-3'),
       ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
       ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
       ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
       ('E-0007', 'Emilio', 'Galarza', 'Desenvolvedor', '2014-08-02', 60000, 0, 'D-000-1');
