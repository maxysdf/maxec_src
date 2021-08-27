alter table product add SALE_AMOUNT int;
alter table product add SALE_DATE date;
alter table product add ONSALE_TIME timestamp;
alter table product add OFFSALE_TIME timestamp;

alter table product add CREATE_TIME timestamp;
alter table product add CREATE_USER_ID varchar(36);
alter table product add UPDATE_TIME timestamp;
alter table product add UPDATE_USER_ID varchar(36);
alter table product add IS_DELETED char(1);

