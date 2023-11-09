CREATE TABLE CLIENT (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(100),
    DOCUMENT_NUMBER VARCHAR(11)
);

CREATE TABLE PRODUCT (
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  DESCRIPTION VARCHAR(100),
  UNIT_PRICE NUMERIC(20,2)
);

CREATE TABLE ORDER (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    CLIENT_ID INTEGER REFERENCES CLIENT(ID),
    ORDER_DATE TIMESTAMP,
    TOTAL NUMERIC(20, 2),
    STATUS VARCHAR(20)
);

CREATE TABLE ORDER_ITEM (
  ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  ORDER_ID INTEGER REFERENCES ORDER(ID),
  PRODUCT_ID INTEGER REFERENCES PRODUCT(ID),
  QUANTITY INTEGER
)