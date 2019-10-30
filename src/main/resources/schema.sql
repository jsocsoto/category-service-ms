SET sql_mode = '';

create table if not exists categories (
	id int(11) not null auto_increment,
	name VARCHAR(75),
	sort int,
	status int,
	picture VARCHAR(75),
	icon VARCHAR(75),
	featured tinyint(4) not null,
	primary key (id)
	
);