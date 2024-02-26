CREATE TABLE user(
    id int AUTO_INCREMENT primary key,
    name varchar(255),
    email varchar(255),
    password varchar(255)
);

CREATE TABLE category(
    c_id int AUTO_INCREMENT primary key,
    name varchar(255),
    uid int,
    foreign key (uid) references user(id)
);

CREATE TABLE transaction(
    t_id int AUTO_INCREMENT primary key,
    price int,
    type varchar(255),
    date timestamp,
    note varchar(255),
    uid int,
    cid int,
    foreign key (uid) references user(id),
    foreign key (cid) references category(c_id)
);