create table taiju (
    id int primary key auto_increment,
    recorded_at bigint not null,
    weight float not null
) engine=InnoDB;