

create table store_table(

store_id number constraint store_id_pk primary key
, user_id number
, store_name varchar2(200)
, store_address varchar2(200)
, store_road_address varchar2(200)
, store_tel varchar2(40)
, store_info varchar2(200)
, store_lat number
, store_lng number
, constraint store_user_fk foreign key (user_id) references meber(user_id)
,
)

create sequence store_seq
INCREMENT BY 1
START WITH 1 
MINVALUE 1 
NOCYCLE 
NOCACHE;