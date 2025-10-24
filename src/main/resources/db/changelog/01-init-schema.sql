create table region (
    code integer not null,
    name varchar(256) not null,
    primary key (code)
);

create table sub_region (
    code integer not null,
    name varchar(256) not null,
    code_region integer not null,
    primary key (code),
    constraint country_region foreign key(code_region) references region(code)
);

create table countries (
    code integer not null,
    alpha2_code varchar(2) not null,
    alpha3_code varchar(3) not null,
    name varchar(256) not null,
    code_region integer,
    code_sub_region integer,
    primary key (code),
    constraint country_region foreign key(code_region) references region(code),
    constraint country_sub_region foreign key(code_sub_region) references sub_region(code)
);