create database Final;
use Final;

create table address_tbl(
add_id int primary key,
add_1 varchar(100) not null,
add_2 varchar(100) not null,
add_city varchar(50)  not null,
add_state varchar(50) not null,
add_pincode int  not null
);

create table user_tbl(
u_id int auto_increment primary key,
u_name varchar(50) not null,
u_password varchar(100) not null,
u_email varchar(100) not null unique,
u_address_id int not null,
u_contact long not null,
constraint fk_user_add foreign key(u_address_id) references address_tbl(add_id)
);
show tables;
drop table user_tbl;
select * from user_tbl;

create table admin_tbl(
a_id int primary key,
a_name varchar(50) not null,
a_email varchar(50) not null unique,
a_password varchar(50) not null,
a_address_id int not null,
a_contact long not null,
constraint fk_admin_add foreign key(a_address_id) references address_tbl(add_id)
);
select * from admin_tbl;
drop table admin_tbl;

create table turf_tbl(
t_id int primary key,
t_name int not null,
t_location varchar(500) not null,
t_contact long not null
);
drop table turf_tbl;

create table manager_tbl(
m_id int primary key,
m_name varchar(50) not null,
m_email varchar(50) not null unique,
m_password varchar(50) not null,
m_address_id int not null,
m_contact long not null,
t_id int not null,
constraint fk_manager_add foreign key(m_address_id) references address_tbl(add_id),
constraint fk_manager_turf foreign key(t_id) references turf_tbl(t_id)
);
drop table manager_tbl;


create table sport_tbl(
s_id int primary key,
s_name varchar(20) not null,
t_id int,
constraint fk_sport_turf foreign key(t_id) references turf_tbl(t_id)
);
drop table sport_tbl;

create table bookingDetails_tbl(
b_id int auto_increment primary key,
u_id int not null,
s_id int not null,
p_id int not null,
b_date date not null,
slot_date date not null,
slot_time varchar(50) not null,
constraint fk_bkdtls_user foreign key(u_id) references user_tbl(u_id),
constraint fk_bkdtls_sport foreign key(s_id) references sport_tbl(s_id),
constraint fk_bkdtls_payment foreign key(p_id) references payment_tbl(p_id)
);
drop table slot_tbl;


create table payment_tbl(
p_id int primary key auto_increment,
p_status varchar(100) not null,
p_date date not null,
p_amount decimal(10,2) not null
);

show tables;
drop table sports_tbl;
drop table court_tbl;







