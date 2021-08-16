create table PRODUCT (
    ID varchar(36) not null,
    NAME varchar(200),
    PRICE int,
    ALIAS varchar(200)
);

ALTER TABLE PRODUCT ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (ID);