INSERT INTO categoria (nome) values ("Medicamentos");
INSERT INTO categoria (nome) values ("Remédios genéricos");
INSERT INTO categoria (nome) values ("Convênios");


INSERT INTO produto (nome,preco,quantidade,validade,categoria_codigo) values ("Dipirona", 12.30, 10, "2023-01-15", 1);
INSERT INTO produto (nome,preco,quantidade,validade,categoria_codigo) values ("Melhoral Infantil", 1.0, 10, "2023-01-20", 2);
INSERT INTO produto (nome,preco,quantidade,validade,categoria_codigo) values ("Drogaria", 1.0, 100, "2023-01-05", 3);

INSERT INTO pedido (horario) values ("2022-08-31 20:45:10");
INSERT INTO pedido (horario) values ("2022-09-05 20:27:10");
INSERT INTO pedido (horario) values ("2022-09-04 19:35:10");

INSERT INTO item_pedido(quantidade, preco, pedido_codigo, produto_codigo) values (2, 5.00, 3,2);
