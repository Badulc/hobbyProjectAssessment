drop table if exists sneaker_dom CASCADE;
create table sneaker_dom (
id integer generated by default as identity, 
colour1 varchar(255) not null, 
colour2 varchar(255) not null, 
condit integer not null, 
material varchar(255) not null, 
name varchar(255) not null, 
serial_no integer not null, 
size integer not null, primary key (id)
);
