create schema cwbgames;

use cwbgames;

create table usuario(
	id_usuario int not null auto_increment,
    nome varchar(60) not null, 
    ultimo_nome varchar (60) not null,
    email varchar (60) not null unique,
    senha varchar(32) not null,
	
    primary key (id_usuario)
);

create table telefone (
	id_telefone int not null auto_increment,
    ddd char(2) not null,
    fone char(9) not null,
    
    primary key (id_telefone)

);

create table tipo_fone(
	id_tipo_fone int not null auto_increment,
    descricao varchar(25) not null,
    
    primary key(id_tipo_fone)


);

create table console(
	id_console int not null auto_increment,
    descricao varchar(25) not null,
    
    primary key(id_console)

);

create table genero_jogos(
	id_genero int not null auto_increment,
    descricao varchar(25) not null,
    
    primary key(id_genero)
);

create table jogos_anuncio(
	id_anuncio int not null auto_increment,
    descricao varchar(255),
    ativo bit not null default 1,
    img varchar(64),
    
    primary key (id_anuncio)

);



create table cometarios(
	id_cometario int not null auto_increment,
    descricao varchar(255),
    
    primary key (id_cometario)


);

create table bairro(
	id_bairro int not null auto_increment,
    descricao varchar(70) not null,
    
    primary key (id_bairro)

);



alter table jogos_anuncio 
add column id_console int not null,
add constraint fk_id_console foreign key (id_console) references console(id_console);

alter table jogos_anuncio
add column id_genero int not null, 
add constraint fk_id_genero foreign key (id_genero) references genero_jogos(id_genero);

alter table jogos_anuncio
add column id_usuario int not null, 
add constraint fk_id_usuario foreign key (id_usuario) references usuario(id_usuario);

alter table telefone 
add column id_tipo_fone int not null,
add constraint fk_tipo_fone foreign key (id_tipo_fone) references tipo_fone(id_tipo_fone);

alter table telefone
add column id_usuario int not null,
add constraint fk_id_usu foreign key (id_usuario) references usuario(id_usuario);

alter table usuario
add column id_bairro int not null,
add constraint fk_id_bairro foreign key (id_bairro) references bairro(id_bairro);

alter table cometarios
add column id_usuario int not null,
add constraint fk_id_user foreign key (id_usuario) references usuario(id_usuario);

alter table cometarios
add column id_anuncio int not null,
add constraint fk_id_anuncio foreign key (id_anuncio) references jogos_anuncio(id_anuncio);


insert into genero_jogos(descricao) values('Ação');
insert into genero_jogos(descricao) values('Aventura');
insert into genero_jogos(descricao) values('Estratégia');
insert into genero_jogos(descricao) values('RPG');
insert into genero_jogos(descricao) values('Esportes');
insert into genero_jogos(descricao) values('Corrida');
insert into genero_jogos(descricao) values('Simulação');
insert into genero_jogos(descricao) values('Outros');

insert into tipo_fone(descricao) values('Celular');
insert into tipo_fone(descricao) values('Comercial');
insert into tipo_fone(descricao) values('Residencial');

insert into console(descricao) values('PlayStation 2');
insert into console(descricao) values('PlayStation 3');
insert into console(descricao) values('PlayStation 4');
insert into console(descricao) values('PSP');
insert into console(descricao) values('PSP-Vita');
insert into console(descricao) values('Xbox 360');
insert into console(descricao) values('Xbox One');
insert into console(descricao) values('Nintendo Wii');
insert into console(descricao) values('Nintendo Wii U');
insert into console(descricao) values('Nintendo 3DS');
insert into console(descricao) values('Super Nintendo');


-- BAIRRO NOVO
insert into bairro(descricao) values ('Bairro Novo');
insert into bairro(descricao) values('Ganguinho');
insert into bairro(descricao) values('Sitio Cercado');
insert into bairro(descricao) values('Umbará');


-- BOA VISTA
insert into bairro(descricao) values ('Boa Vista');
insert into bairro(descricao) values('Abranches');
insert into bairro(descricao) values('Atuba');
insert into bairro(descricao) values('Bacacheri');
insert into bairro(descricao) values('Bairro Alto');
insert into bairro(descricao) values('Cachoeira');
insert into bairro(descricao) values('Pilarzinho');
insert into bairro(descricao) values('Santa Cândida');
insert into bairro(descricao) values('São Lourenço');
insert into bairro(descricao) values('Taboão');
insert into bairro(descricao) values('Tarumã');
insert into bairro(descricao) values('Tingui');



-- BOQUEIRAO
insert into bairro(descricao) values ('Boqueirão');
insert into bairro(descricao) values('Alto Boqueirão');
insert into bairro(descricao) values('Hauer');
insert into bairro(descricao) values('Xaxim');


-- CAJURU
insert into bairro(descricao) values ('Cajuru');
insert into bairro(descricao) values('Capão da Imbuia');	
insert into bairro(descricao) values('Guabirotuba');
insert into bairro(descricao) values('Jd. das Américas');
insert into bairro(descricao) values('Uberaba');



-- CIC
insert into bairro(descricao) values ('Cidade Industrial');	
insert into bairro(descricao) values('Augusta');
insert into bairro(descricao) values('Riviera');
insert into bairro(descricao) values('São Miguel');


-- FAZENDINHA-PORTÃO
insert into bairro(descricao) values ('Fazendinha/Portão');	
insert into bairro(descricao) values('Agua Verde');
insert into bairro(descricao) values('Campo Comprido');
insert into bairro(descricao) values('Fanny');
insert into bairro(descricao) values('Fazendinha');	
insert into bairro(descricao) values('Guaíra');
insert into bairro(descricao) values('Lindoia');
insert into bairro(descricao) values('Novo Mundo');
insert into bairro(descricao) values('Parolin');	
insert into bairro(descricao) values('Portão');
insert into bairro(descricao) values('Santa Quitéria');
insert into bairro(descricao) values('Vila Izabel');	



-- MATRIZ

insert into bairro(descricao) values('Ahú');
insert into bairro(descricao) values('Alto da Glória');
insert into bairro(descricao) values('Alto da XV');
insert into bairro(descricao) values('Batel');	
insert into bairro(descricao) values('Bigorrilho');
insert into bairro(descricao) values('Bom Retiro');
insert into bairro(descricao) values('Cabral');	
insert into bairro(descricao) values('Centro');
insert into bairro(descricao) values('Centro Cívico');
insert into bairro(descricao) values('Cristo Rei');
insert into bairro(descricao) values('Hugo Lange');	
insert into bairro(descricao) values('Jardim Botânico');
insert into bairro(descricao) values('Jardim Social');
insert into bairro(descricao) values('Juvevê');
insert into bairro(descricao) values('Mercês');
insert into bairro(descricao) values('Prado Velho');	
insert into bairro(descricao) values('Rebouças');
insert into bairro(descricao) values('São Francisco');


-- PINHEIRINHO
insert into bairro(descricao) values ('Pinheirinho');
insert into bairro(descricao) values('Campo de Santana');	
insert into bairro(descricao) values('Capão Raso');
insert into bairro(descricao) values('Caximba');
insert into bairro(descricao) values('Tatuquara');

-- SANTA FELICIDADE	
insert into bairro(descricao) values ('Santa Felicidade');
insert into bairro(descricao) values('Butiatuvinha');
insert into bairro(descricao) values('Campina do Siqueira');
insert into bairro(descricao) values('Campo Comprido');
insert into bairro(descricao) values('Cascatinha');
insert into bairro(descricao) values('Lamenha Pequena');	
insert into bairro(descricao) values('Mossunguê');
insert into bairro(descricao) values('Orleans');
insert into bairro(descricao) values('Santo Inácio');
insert into bairro(descricao) values('São Braz');
insert into bairro(descricao) values('São João');
insert into bairro(descricao) values('Seminário');	
insert into bairro(descricao) values('Vista Alegre');

-- REGIÃO METROPOLITANA
insert into bairro(descricao) values ('Região Metropolitana');

alter table jogos_anuncio
add column nome varchar(40) not null;


DELIMITER $$
CREATE PROCEDURE inserir_dados_cadastro
	(IN prim_nome VARCHAR(60), IN ult_nome VARCHAR(60), IN e_mail VARCHAR(60), IN usu_senha VARCHAR(32), IN bairro_id INT, 
    IN dddtel char(2), IN fonetel char(9), IN id_fone_tipo int)
BEGIN

	DECLARE EXIT HANDLER FOR 1062 SELECT 'Já existe um cadastro utilizando esse email, tente outro ou recupere sua senha!';
	DECLARE EXIT HANDLER FOR 1452 SELECT 'Insira um Bairro válido!';


	INSERT INTO usuario(nome, ultimo_nome, email, senha, id_bairro) VALUES (prim_nome, ult_nome, e_mail, md5(usu_senha), bairro_id);
    INSERT INTO telefone(ddd, fone, id_tipo_fone, id_usuario) VALUES (dddtel, fonetel, id_fone_tipo, last_insert_id());
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE alterar_dados_cadastro
	(IN prim_nome VARCHAR(60), IN ult_nome VARCHAR(60), IN e_mail VARCHAR(60), IN usu_senha VARCHAR(32), IN bairro_id INT, IN id_usuario INT, 
    IN dddtel char(2), IN fonetel char(9), IN id_fone_tipo int)
BEGIN

	DECLARE EXIT HANDLER FOR 1062 SELECT 'Já existe um cadastro utilizando esse email, tente outro ou recupere sua senha!';
	DECLARE EXIT HANDLER FOR 1452 SELECT 'Insira um Bairro válido!';


	update usuario set nome = prim_nome, ultimo_nome = ult_nome, email = e_mail ,senha = MD5(usu_senha), id_bairro = bairro_id where id_usuario = id_usuario ;
    update telefone set ddd = dddtel, fone = fonetel, id_tipo_fone = id_fone_tipo where id_usuario = id_usuario ;
END $$
DELIMITER ;



delimiter $$
create procedure atualiza_img(in imgs varchar(60))
begin
	declare ultimo_id int;
	select max(id_anuncio) into ultimo_id from jogos_anuncio;
	update jogos_anuncio SET img = imgs WHERE id_anuncio = ultimo_id;
end $$

