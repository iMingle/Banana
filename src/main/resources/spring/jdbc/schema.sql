DROP TABLE IF EXISTS spittle;
DROP TABLE IF EXISTS spitter;

CREATE TABLE spitter (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(25) NOT NULL,
  password VARCHAR(25) NOT NULL,
  fullname VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL,
  update_by_email BOOLEAN NOT NULL
);

INSERT INTO spitter (id, username, password, fullname, email, update_by_email) VALUES (1, 'habuma', 'password', 'Craig Walls', 'craig@habuma.com', false);
INSERT INTO spitter (id, username, password, fullname, email, update_by_email) VALUES (2, 'artnames', 'password', 'Art Names', 'artnames@habuma.com', false);

CREATE TABLE spittle (
  id INT PRIMARY KEY AUTO_INCREMENT,
  spitter_id INT NOT NULL,
  spittleText VARCHAR(2000) NOT NULL,
  postedTime DATE NOT NULL,
  FOREIGN KEY (spitter_id) references spitter(id)
);

INSERT INTO spittle (id, spitter_id, spittleText, postedTime) VALUES (1, 1, 'Have you read Spring in Action 3? I hear it is awesome!', '2010-06-09');
INSERT INTO spittle (id, spitter_id, spittleText, postedTime) VALUES (2, 2, 'Trying out Spring''s new expression language.', '2010-06-11');
INSERT INTO spittle (id, spitter_id, spittleText, postedTime) VALUES (3, 1, 'Who''s going to SpringOne/2GX this year?', '2010-06-19');
