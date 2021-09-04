
alter table brand add CREATE_TIME timestamp;
alter table brand add CREATE_USER_ID varchar(36);
alter table brand add UPDATE_TIME timestamp;
alter table brand add UPDATE_USER_ID varchar(36);
alter table brand add IS_DELETED char(1);


alter table tag add CREATE_TIME timestamp;
alter table tag add CREATE_USER_ID varchar(36);
alter table tag add UPDATE_TIME timestamp;
alter table tag add UPDATE_USER_ID varchar(36);
alter table tag add IS_DELETED char(1);

alter table category add CREATE_TIME timestamp;
alter table category add CREATE_USER_ID varchar(36);
alter table category add UPDATE_TIME timestamp;
alter table category add UPDATE_USER_ID varchar(36);
alter table category add IS_DELETED char(1);