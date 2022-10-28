CREATE TABLE if not exists tb_book (
  pk_book serial primary key,
  author varchar(255) not null,
  launch_date date NOT NULL,
  price decimal(65,2) NOT NULL,
  title varchar(255) not null
);
