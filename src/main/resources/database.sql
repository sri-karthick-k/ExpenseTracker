CREATE TABLE user(
    id int AUTO_INCREMENT primary key,
    name varchar(255),
    email varchar(255),
    password varchar(255)
);

CREATE TABLE category(
    id int AUTO_INCREMENT primary key,
    name varchar(255),
    uid int,
    foreign key (uid) references user(id)
);