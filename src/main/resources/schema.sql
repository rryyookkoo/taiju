create table if not exists taiju (
    id int primary key auto_increment,
    recorded_at bigint not null,
    weight float not null
) engine=InnoDB;

create table if not exists user (
    id int primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    created_at bigint not null
) engine=InnoDB;