alter table TAG add VALUE varchar(50)
alter table tag add code varchar(50)
alter table tag add sort int;

alter table category add sort int;
alter table brand add sort int;
alter table brand add code varchar(50);

insert into tag (id, type, name, code, value, sort) values
('e7839b08-730d-437d-a136-6cdba7a028bd', 'COLOR', '黑'      , 'BLACK'       , '#252525', 1),
('1ccaac06-4424-419d-8253-0c22618ce1c0', 'COLOR', '紫'      , 'PURPLE'      , '#8230E3', 2),
('f1f77e4f-2443-4672-9518-e8ca966e0a85', 'COLOR', '藍'      , 'BLUE'        , '#2773BE', 3),
('2a9d7653-19f6-4c95-bdf5-6a496b12a052', 'COLOR', '紅'      , 'RED'         , '#DC3232', 4),
('147a29a3-05ba-4af3-821f-7f1f70f36599', 'COLOR', '綠'      , 'GREEN'       , '#81D742', 5),
('7cfa6004-5721-4cb2-aea9-7b1f2f20658f', 'COLOR', '黃'      , 'YELLOW'      , '#EEEE21', 6),
('0372e43e-9c3b-40ed-bfdf-0e2e1f530a39', 'SIZE' , 'XS'      , 'XS'          , null     , 1),
('0be4a7c8-f57f-4ab2-9f30-cab53a2334d8', 'SIZE' , 'S'       , 'S'           , null     , 2),
('41bf9adc-5e42-41de-8830-8e6856f53660', 'SIZE' , 'M'       , 'M'           , null     , 3),
('23a8c486-4185-4f48-8c98-213eac7860ef', 'SIZE' , 'L'       , 'L'           , null     , 4),
('0df12eab-65d5-425e-803d-87cca27368b1', 'SIZE' , 'XL'      , 'XL'          , null     , 5),
('b3a8bf05-7ec7-4d34-a3d9-17e9833ee016', 'TAG'  , '超耐用'  , 'DURABLE'     , null     , 1),
('974d2eea-1a26-4fe9-a6ff-678e923570d4', 'TAG'  , '名人代言', 'CELEBRITIES' , null     , 2),
('02e16b15-2d26-489c-8afd-4423e94a3284', 'TAG'  , '官方'    , 'OFFICIAL'    , null     , 3),
('cbc93902-4788-4d17-b121-ad4b5cd5d584', 'TAG'  , '防水'    , 'WATER_PROOF' , null     , 4),
('46dab9e3-08ec-4092-9a1b-7731c0619366', 'TAG'  , '復古'    , 'RETRO'       , null     , 5),
('7172e670-de74-446e-923a-7e1932886264', 'TAG'  , '時髦'    , 'FASHION'     , null     , 6),
('0382db3b-a29e-4fa6-9130-259480418e9e', 'TAG'  , '超值'    , 'VALUABLE'    , null     , 7)
;

insert into brand (id, name, code, sort) values 
('39328be7-1493-4e02-9945-83fa5318865c', 'Uniqlo'        , 'UNIQLO'  , 1),
('091f40e8-f55e-4ba4-8c87-0c39bf86bce4', 'NET'           , 'NET'     , 2),
('f961c446-24b8-4d91-8cfb-4decbbbdd2c8', 'Nike'          , 'NIKE'    , 3),
('9a1a2c7c-190b-40ff-a8fe-71f707568325', 'Polo'          , 'POLO'    , 4),
('0d803252-1fe8-4c02-91ad-741b14b3f011', 'Calvin Klein'  , 'CK'      , 5),
('a6510380-996b-4bd5-bbd7-c3dd035deeac', 'Hand Ten'      , 'HAND_TEN', 6),
('944cdb60-e98f-4300-a911-65de9793a3af', 'Lativ'         , 'LATIV'   , 7),
('aafc9994-cee8-4716-b79d-74c3cbd6790f', 'GIORDANO'      , 'GIORDANO', 8)
;