create table products (
    id bigserial primary key,
    description text,
    product_code varchar(3) NOT NULL
);