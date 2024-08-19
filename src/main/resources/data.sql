create table tb_cidade(
    id bigint not null primary key,
    nome varchar(100) not null,
    habitantes bigint
);

insert into tb_cidade(id, nome, habitantes) values
                                                (1,'São Paulo', 12000000),
                                                (2,'Rio de Janeiro', 6000000),
                                                (3,'Belo Horizonte', 3000000),
                                                (4,'Curitiba', 2000000),
                                                (5,'Porto Alegre', 1500000),
                                                (6,'Salvador', 3000000),
                                                (7,'Recife', 2500000),
                                                (8,'Fortaleza', 2500000),
                                                (9,'Brasília', 3000000),
                                                (10,'Goiânia', 2000000),
                                                (11, 'Porto Velho', 500000);

