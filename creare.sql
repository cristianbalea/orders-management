drop database if exists orders;
create database orders;
use orders;

create table Product (
	productID bigint primary key auto_increment,
    productName varchar(100),
    productPrice bigint,
    productStock bigint
);

create table Client (
	clientID bigint primary key auto_increment,
    clientName varchar(100),
    clientAddress varchar(100),
    clientEmail varchar(100)
);

create table Orders (
	ordersID bigint primary key auto_increment,
    clientID bigint,
    productID bigint,
    quantity bigint,
    constraint FK_product foreign key(productID) references Product(productID),
    constraint FK_client foreign key(clientID) references Client(clientID)
);