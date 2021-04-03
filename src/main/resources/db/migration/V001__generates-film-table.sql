create table film(

	id bigint not null auto_increment,
	titulo varchar(255) not null,
	descricao varchar(255) not null,
	link varchar(255) not null,
	
	primary key(id)

);

INSERT INTO film (id, titulo, descricao, link) VALUES (NULL,"Hackers Criminosos ou Heróis?","Documentário sobre Hacker exibido pelo Discovery Science em 2019", "https://www.youtube.com/watch?v=8VjcWoWvbMw");