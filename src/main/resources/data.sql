CREATE TABLE usuario ( 
   id_usuario INT auto_increment primary key NOT NULL, 
   nome  VARCHAR(75) NOT NULL,
   email VARCHAR(50) NOT NULL,
   senha VARCHAR(100) NOT NULL
);


CREATE TABLE importacao ( 
   data_transacao_importacao DATE primary key NOT NULL,
   data_hora_importacao TIMESTAMP NOT NULL
);

CREATE TABLE transacao ( 
   id_transacao INT auto_increment primary key NOT NULL, 
   banco_origem VARCHAR(100) NOT NULL, 
   agencia_origem VARCHAR(10) NOT NULL, 
   conta_origem VARCHAR(10) NOT NULL, 
   banco_destino VARCHAR(100) NOT NULL, 
   agencia_destino VARCHAR(10) NOT NULL, 
   conta_destino VARCHAR(10) NOT NULL, 
   valor_transacao NUMERIC NOT NULL, 
   data_hora_transacao TIMESTAMP NOT NULL,
   data_transacao_importacao DATE,
   foreign key (data_transacao_importacao) references importacao(data_transacao_importacao)
);

INSERT INTO usuario (nome, email, senha)
VALUES ('Admin', ' admin@email.com.br', '123999');