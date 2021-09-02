create table CUSTOMER (
    ID char(36) not null,
    EMAIL varchar(100),
    USERNAME varchar(50),
    NAME varchar(50),
    PASSWORD varchar(100),
    STATUS varchar(20),
    CUSTOMER_GROUP_ID char(36),
    CREATE_TIME timestamp,
    CREATE_USER_ID varchar(36),
    UPDATE_TIME timestamp,
    UPDATE_USER_ID varchar(36),
    IS_DELETED char(1)
);

ALTER TABLE CUSTOMER ADD CONSTRAINT PK_CUSTOMER PRIMARY KEY (ID);

create unique index IDX_CUSTOMER_0 on CUSTOMER(USERNAME);
create unique index IDX_CUSTOMER_1 on CUSTOMER(EMAIL);


create table CUSTOMER_ATTRIBUTE (
    ID char(36) not null,
    NAME varchar(50),
    DISPLAY_NAME varchar(100),
    CODE varchar(50),
    CUSTOMER_GROUP_ID char(36),
    CREATE_TIME timestamp,
    CREATE_USER_ID varchar(36),
    UPDATE_TIME timestamp,
    UPDATE_USER_ID varchar(36),
    IS_DELETED char(1)
);

ALTER TABLE CUSTOMER_ATTRIBUTE ADD CONSTRAINT PK_CUSTOMER_ATTRIBUTE PRIMARY KEY (ID);

create table CUSTOMER_ATTRIBUTE_MAP (
    ID char(36) not null,
    CUSTOMER_ID char(36),
    CUSTOMER_ATTRIBUTE_ID char(36),
    VALUE varchar(100)
);

ALTER TABLE CUSTOMER_ATTRIBUTE_MAP ADD CONSTRAINT PK_CUSTOMER_ATTRIBUTE_MAP PRIMARY KEY (ID);


create table CUSTOMER_GROUP (
    ID char(36) not null,
    NAME varchar(50),
    CODE varchar(50),
    CREATE_TIME timestamp,
    CREATE_USER_ID varchar(36),
    UPDATE_TIME timestamp,
    UPDATE_USER_ID varchar(36),
    IS_DELETED char(1)
);

ALTER TABLE CUSTOMER_GROUP ADD CONSTRAINT PK_CUSTOMER_GROUP PRIMARY KEY (ID);


ALTER TABLE CUSTOMER ADD CONSTRAINT FK_CUSTOMER_0 FOREIGN KEY (CUSTOMER_GROUP_ID) REFERENCES CUSTOMER_GROUP (ID);

ALTER TABLE CUSTOMER_ATTRIBUTE ADD CONSTRAINT FK_CUSTOMER_ATTRIBUTE_0 FOREIGN KEY (CUSTOMER_GROUP_ID) REFERENCES CUSTOMER_GROUP (ID);

ALTER TABLE CUSTOMER_ATTRIBUTE_MAP ADD CONSTRAINT FK_CUSTOMER_ATTRIBUTE_MAP_0 FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID);
ALTER TABLE CUSTOMER_ATTRIBUTE_MAP ADD CONSTRAINT FK_CUSTOMER_ATTRIBUTE_MAP_1 FOREIGN KEY (CUSTOMER_ATTRIBUTE_ID) REFERENCES CUSTOMER_ATTRIBUTE (ID);
-- data
INSERT INTO CUSTOMER_GROUP (id,name,code) VALUES ('60411a19-4e2a-4e12-9ba5-5126200da1df','會員','MEMBER');
