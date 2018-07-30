DROP TABLE IF EXISTS carmodel

CREATE TABLE carmodel(
    CAR_ID Bigserial PRIMARY KEY NOT NULL,
    BRAND varchar(100) NOT NULL,
    YEAR smallint NOT NULL);