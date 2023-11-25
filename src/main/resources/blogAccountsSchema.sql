create table if not exists BlogAccounts(
     accountID int not null auto_increment primary key,
     firstName varchar(255) not null,
     lastName varchar(255) not null,
     email varchar(255) not null,
     password varchar(64) not null
);