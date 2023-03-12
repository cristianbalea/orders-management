use orders;
insert into Product (productName, productPrice, productStock) values
("candelabru", 200, 30),
("canapea", 1500, 20),
("birou", 150, 10),
("pat", 400, 10),
("covor", 200, 30),
("paine", 5, 100),
("aspirator", 150, 50),
("masina de cusut", 400, 30), 
("televizor", 2000, 50), 
("geamantan", 150, 30),
("uscator de par", 75, 10),
("scaun bucatarie", 100, 40),
("scaun birou", 200, 30),
("noptiera", 150, 40),
("dulap", 400, 10),
("rafturi perete", 150, 10),
("masa bucatarie", 250, 30),
("frigider", 1000, 20),
("aragaz", 600, 30),
("masina de spalat haine", 900, 30),
("masina de spalat vase", 1400, 30),
("cuptor electric", 300, 10),
("cuptor cu microunde", 200, 50),
("dulap bucatarie", 400, 10),
("oglinda perete", 150, 40);

insert into Client(clientName, clientAddress, clientEmail) values 
("Popescu Ion", "Baritiu nr.6", "popescuion@gmail.com"),
("Galita Anamaria", "Observatorului nr.32", "galitanamaria@gmail.com"),
("Balea Cristian", "Unirii nr.14", "baleacristian@gmail.com"),
("Pop Radu", "Calea Turzii nr.36", "popradu@gmail.com"),
("Trif Diana", "Ceahlaului nr.77", "trifdiana@gmail.com"),
("Anca Constanta", "Viilor nr.47", "ancaconstanta@gmail.com"),
("Sicoe Roxana", "Republicii nr.32", "sicoeroxana@gmail.com"),
("Dumitrescu Marin", "Calea Manastur nr.15", "marindumitrescu@gmail.com"),
("Marton Laszlo", "Eroilor nr.78", "martonlaszlo@gmail.com"),
("Botar Mihai", "Revolutiei nr.48", "botarmihai@gmail.com"),
("Alexa Raul", "Militari nr.23", "alexaraul@gmail.com"),
("Szilagyi Timea", "Victor Babes nr.48", "szilagyitimea@gmail.com"),
("Mihaly Simona", "Dorobantilor nr.91", "mihalysimona@gmail.com"),
("Grozav Andreea", "Cetatii nr.26", "grozavandreea@gmail.com");

insert into Orders(clientID, productID, quantity) values
(3, 21, 4), (5, 24, 10), (7, 1, 5), (14, 25, 2), (1, 14, 6), (9, 13, 4), (3, 15, 2), (7, 18, 5), (11, 4, 4), (10, 7, 5);