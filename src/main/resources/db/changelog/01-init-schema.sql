create table countries (
    code integer not null,
    alpha2_code varchar(2) not null,
    alpha3_code varchar(3) not null,
    name varchar(256) not null,
    primary key (code)
);