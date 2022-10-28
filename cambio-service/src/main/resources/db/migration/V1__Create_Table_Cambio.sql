create table if not exists tb_cambio (
    pk_cambio serial primary key,
    from_currency varchar(3) not null,
    to_currency varchar(3) not null,
    conversion_factor decimal(65,2) not null
);