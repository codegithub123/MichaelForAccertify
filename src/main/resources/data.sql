DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS state;


CREATE TABLE country (
  country_cd VARCHAR(3) PRIMARY KEY,  
  country_name VARCHAR(100) NOT NULL,    
  currency_cd VARCHAR(3) NOT NULL
);
CREATE UNIQUE INDEX currency_cd_index ON country (currency_cd);

CREATE TABLE state (
  country_cd VARCHAR(3) NOT NULL,
  state_name VARCHAR(100) NOT NULL,
  state_cd VARCHAR(3) NOT NULL,
  state_population number(12) NOT NULL,
  PRIMARY KEY (country_cd, state_cd)
);
CREATE INDEX state_pl_index ON state(state_population);


INSERT INTO country (country_cd, country_name, currency_cd) VALUES
  ('BLD', 'Big Land', 'CHK'),
  ('MDR', 'Mordor', 'GUL'),
  ('NUM', 'Numberland', 'DIG');


INSERT INTO state (country_cd, state_name, state_cd, state_population) VALUES
  ('BLD', 'Left Province','LEF',10100),
  ('BLD', 'Right Province','RIG',778030),
  ('BLD', 'Topside','TSD',2200340),
  ('BLD', 'Center Province','CTR',1340922),
  ('MDR', 'Udun','UDN',2000110),
  ('MDR', 'Gorgoroth','GOR',3120900),
  ('MDR', 'Nurn','NRN',1100000),
  ('MDR', 'Kand','KND',2500000),
  ('NUM', 'One','ONE',1150000),
  ('NUM', 'Two','TWO',25320000),
  ('NUM', 'Three','TRE',310000),
  ('NUM', 'Four','FOR',400000);


