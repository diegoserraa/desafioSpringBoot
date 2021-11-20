create table product (
    id int not null,
    name VARCHAR(100),
    image VARCHAR(300),
    oldPrice float,
    price float,
    description varchar(500),
    installments_id int not null
);

create table installments (
    id int not null,
    count int,
    value float
);