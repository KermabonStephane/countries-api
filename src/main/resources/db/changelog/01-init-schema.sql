create table countries (
    code integer not null,
    alpha2_code varchar2(2) not null,
    alpha3_code varchar2(3) not null,
    name varchar2(256) not null,
    primary key (code)
);