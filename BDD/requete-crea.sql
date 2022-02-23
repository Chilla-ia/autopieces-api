#Création de la table article
create table article(
   article_id INT NOT NULL AUTO_INCREMENT,
   article_name VARCHAR(100) NOT NULL,
   article_price decimal NOT NULL,
   PRIMARY KEY ( article_id )
);

#Création de la table contrat
create table contrat(
   contrat_id INT NOT NULL AUTO_INCREMENT,
   contrat_marge INT NOT NULL,
   PRIMARY KEY ( contrat_id )
);

#Création de la table clients
create table clients(
   clients_id INT NOT NULL AUTO_INCREMENT,
   clients_name VARCHAR(100) NOT NULL,
   contrat_id INT NOT NULL,
   PRIMARY KEY ( clients_id ),
   CONSTRAINT fk_contrat FOREIGN KEY (contrat_id)  
   REFERENCES contrat(contrat_id) 
);

#Création de la table commande
create table commande(
   commande_id INT NOT NULL AUTO_INCREMENT,
   commande_date datetime NOT NULL,
   clients_id INT NOT NULL,
   article_id INT NOT NULL,
   PRIMARY KEY ( commande_id ),
   CONSTRAINT fk_clients FOREIGN KEY (clients_id)  
   REFERENCES clients(clients_id),
   CONSTRAINT fk_article FOREIGN KEY (article_id)  
   REFERENCES article(article_id)
);

#Insertion de données dans la table article
INSERT INTO article (article_name, article_price)
 VALUES
 ('Embrayage', 556.9),
 ('Culasse', 123.7),
 ('Turbo', 1568.3),
 ('Injecteur', 724.5),
 ('Démarreur', 326.2),
 ('Filtre à air', 56.9),
 ('Bougie', 32.9),
 ('Filtre à carburant', 69.9),
 ('Pot catalytique', 742.8),
 ('Cardans', 213.3),
 ('Amortisseurs', 885.2),
 ('Pneus', 280.9),
 ('Verre de phare', 24.9),
 ('Ampoule', 12.5),
 ('Compresseur', 189.3),
 ('Radiateur', 368.5),
 ('Pare-choc avant', 635.8),
 ('Rétroviseurs', 176.3);
 
 SELECT * FROM article;
 
 #Insertion de données dans la table contrat
 INSERT INTO contrat (contrat_marge)
 VALUES
 (5),
 (10),
 (15),
 (20),
 (25);
 
 SELECT * FROM contrat;
 
 #Insertion de données dans la table clients
 INSERT INTO clients (clients_name, contrat_id)
 VALUES
 ('Dupont', 1),
 ('Metivier', 3),
 ('Fraudeau', 2),
 ('Martin', 4),
 ('Barbeau', 1),
 ('Guill', 2),
 ('Babin', 2),
 ('Delahaye', 4),
 ('Rousselin', 3),
 ('Caravatti', 5),
 ('Pambou', 5),
 ('Paco', 2),
 ('Delhoume-Daudé', 4),
 ('Caunes', 1),
 ('Pouqine', 3),
 ('Jabouille', 3),
 ('Ramiarinirina', 5),
 ('Gomez', 2),
('Albou', 1),
 ('Prevost', 4),
 ('Garnier', 5),
 ('Gallet', 1),
 ('De La Fouchardiere', 5),
 ('Brunet', 3),
 ('Audin', 3);
 
 SELECT * FROM clients;

 
 
 

