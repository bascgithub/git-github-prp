DROP TABLE IF EXISTS User;
 
CREATE TABLE User (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);
 
INSERT INTO user (name, email) VALUES
  ('Aliko', 'Dangote@g.com'),
  ('Bill', 'Gates@g.com'),
  ('Folrunsho', 'Alakija@g.com');