CREATE TABLE KUNDE (
  id SERIAL PRIMARY KEY NOT NULL,
  firstname varchar(30) DEFAULT NULL,
  lastname varchar(30) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  reg_date varchar(10) NOT NULL
);

CREATE TABLE PRODUCT (
  id SERIAL PRIMARY KEY NOT NULL,
  name varchar(30) NOT NULL,
  description varchar(30) DEFAULT NULL,
  price int NOT NULL
);

CREATE TABLE SHOPPINGCART (
  id SERIAL PRIMARY KEY NOT NULL,

)