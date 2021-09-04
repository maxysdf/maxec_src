create table AD (
    ID char(36) not null,
    NAME varchar(200),
    CODE varchar(50),
    START_TIME timestamp,
    END_TIME timestamp,
    CREATE_TIME timestamp,
    CREATE_USER_ID varchar(36),
    UPDATE_TIME timestamp,
    UPDATE_USER_ID varchar(36),
    IS_DELETED char(1)
);

ALTER TABLE AD ADD CONSTRAINT PK_AD PRIMARY KEY (ID);

create table AD_ITEM (
    ID char(36) not null,
    IMAGE_PATH varchar(200),
    IMAGE_LINK varchar(500),
    IMAGE_ALT varchar(100),
    IS_OPEN_NEW char(1),
    SORT int,
    AD_ID char(36)
);

ALTER TABLE AD_ITEM ADD CONSTRAINT PK_AD_ITEM PRIMARY KEY (ID);

ALTER TABLE AD_ITEM ADD CONSTRAINT FK_AD_ITEM_0 FOREIGN KEY (AD_ID ) REFERENCES AD (ID);


-- test data
--   insert into ad (id, name, code, start_time, end_time) values
--   ('82991cdd-9229-485d-89d0-7c3643b14505', '首頁上方廣告', 'INDEX_TOP', '2021-08-01 00:00:00', '2021-12-31 00:00:00');
--   
--   insert into ad_item (id, image_path, image_alt, image_link, is_open_new, sort, ad_id) values
--   ('50714ec7-c2a0-4662-9bd2-7f82831ad534', 'cart'  , '/content/ad/82991cdd-9229-485d-89d0-7c3643b14505/1.jpg', '/cart'                , 'N', 1, '82991cdd-9229-485d-89d0-7c3643b14505'),
--   ('ec89be0a-5cd7-4fd5-a2a2-d080d66da97f', 'google', '/content/ad/82991cdd-9229-485d-89d0-7c3643b14505/2.jpg', 'http://www.google.com', 'Y', 2, '82991cdd-9229-485d-89d0-7c3643b14505'),
--   ('058ca271-3084-40cf-bfba-5af4101e8b00', 'other1','/content/ad/82991cdd-9229-485d-89d0-7c3643b14505/3.jpg', '/cart'                , 'N', 3, '82991cdd-9229-485d-89d0-7c3643b14505'),
--   ('6e7505f4-945e-40aa-907f-813f38b359b1', 'other2','/content/ad/82991cdd-9229-485d-89d0-7c3643b14505/4.jpg', '/cart'                , 'N', 4, '82991cdd-9229-485d-89d0-7c3643b14505'),
--   ('a64805a5-4fa0-4ff5-b70e-883df3bedc21', 'other3','/content/ad/82991cdd-9229-485d-89d0-7c3643b14505/5.jpg', '/cart'                , 'N', 5, '82991cdd-9229-485d-89d0-7c3643b14505')
--   ;