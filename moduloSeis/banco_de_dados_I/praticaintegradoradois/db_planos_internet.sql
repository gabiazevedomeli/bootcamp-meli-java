create database if not exists empresa_internet;
use empresa_internet;

create table Clientes (
                          cpf_cliente char(14) primary key not null,
                          nome varchar(45) not null,
                          sobrenome varchar(45) not null,
                          data_nascimento date,
                          estado varchar(30) not null,
                          cidade varchar(30) not null
);

create table Planos_Internet (
                                 id_plano int primary key not null auto_increment,
                                 megabytes_vel int not null,
                                 preco decimal not null,
                                 desconto varchar(10) default null,
                                 id_cliente char(14),
                                 foreign key (id_cliente) references Clientes (cpf_cliente)
);

insert into Clientes(cpf_cliente, nome, sobrenome, data_nascimento, estado, cidade)
values ('123.456.789-00', 'Gabriela', 'Azevedo', '1988-09-11', 'Rio de Janeiro', 'Petrópolis'),
       ('122.543.765-01', 'Iuri', 'Silva', '1973-09-30', 'Rio de Janeiro', 'Rio de Janeiro'),
       ('124.543.725-01', 'Marcos', 'Santos', '1980-05-05', 'São Paulo', 'São Paulo'),
       ('124.543.765-01', 'Ana', 'Ferreira', '1990-04-23', 'Bahia', 'Salvador'),
       ('124.513.465-03', 'Cristiano', 'Mendes', '1982-07-31', 'Minas Gerais', 'Belo Horizonte'),
       ('124.543.345-09', 'José', 'Oliveira', '1960-03-03', 'Paraná', 'Curitiba'),
       ('124.543.765-08', 'Joice', 'Martins', '1975-10-20', 'Mato Grosso', 'Cuiabá'),
       ('124.543.765-04', 'Fernando', 'Alves', '1999-06-01', 'Pernambuco', 'Recife'),
       ('124.543.765-05', 'Álvaro', 'Canedo', '1990-12-06', 'Amazonas', 'Manaus'),
       ('124.543.765-06', 'Marina', 'Lima', '1981-08-27', 'Rio Grande do Sul', 'Porto Alegre');

insert into Planos_internet(id_plano, megabytes_vel, preco, desconto, id_cliente)
values (1, 10, 89.90, '5%', '123.456.789-00'),
       (2, 100, 179.90, '', '124.543.725-01'),
       (3, 50, 120.00, '10%', '124.543.765-06'),
       (4, 10, 89.90, '5%', '124.543.765-04'),
       (5, 100, 179.90, '', '124.543.765-08');