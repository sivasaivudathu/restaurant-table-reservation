create database applicationdb;

use applicationdb;

create table user (

 user_id int NOT NULL AUTO_INCREMENT,
 active boolean ,
 name varchar(255) NOT NULL,
 password varchar(255) NOT NULL,
 phone_no varchar(255) NOT NULL,
 email_id varchar(255) NOT NULL,
 address varchar(255) NOT NULL,
 description varchar(255) NOT NULL,
 PRIMARY KEY (user_id)
);

CREATE TABLE role (
  role_id int NOT NULL AUTO_INCREMENT,
  role_name varchar(255) NOT NULL,
  PRIMARY KEY (role_id)
) ;


CREATE TABLE user_role (
  user_id int NOT NULL,
  role_id int NOT NULL,
  PRIMARY KEY (user_id,role_id),
  
  FOREIGN KEY (user_id) REFERENCES user (user_id),
  FOREIGN KEY (role_id) REFERENCES role (role_id)
) ;

create table restaurant (
restaurant_id int  not null AUTO_INCREMENT,
name varchar(255) NOT NULL,
primary key(restaurant_id)
);

create table restaurant_status(
rest_status_id int not null auto_increment,

status ENUM('OPEN', 'CLOSED', 'OPENING_SHORTLY') unique,
primary key(rest_status_id)
);

create table restaurant_branch(
branch_id int  auto_increment,
restaurant_id int ,
city varchar(255) not null,
address varchar(255) not null,
capacity int not null,
opens_at varchar(255) not null,
closes_at varchar(255) not null,
rest_status_id int not null,

primary key(branch_id),
FOREIGN KEY (restaurant_id) REFERENCES restaurant (restaurant_id),
FOREIGN KEY (rest_status_id) REFERENCES restaurant_status (rest_status_id)
);

create table branch_phonenumber(
id int not null auto_increment,
number varchar(255) not null,
branch_id int ,


primary key(id),
FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)
);

create table branch_admin(
  user_id int NOT NULL,
  branch_id int NOT NULL,
  PRIMARY KEY (user_id,branch_id),
  
  FOREIGN KEY (user_id) REFERENCES user (user_id),
  FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)
);

create table review(

id int not null auto_increment,
user_id int not null,
branch_id int not null,
description varchar(255) not null,

primary key (id),
FOREIGN KEY (user_id) REFERENCES user (user_id),
  FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)
);

create table slot_status(
id int not null auto_increment,
status ENUM('AVAILABLE','NOT_AVAILABLE') unique,
primary key (id)
);

create table reservation_slot(
slot_id int not null auto_increment,
branch_id int ,
slot_time varchar(255) not null,
status_id int not null,

primary key (slot_id),
FOREIGN KEY (status_id) REFERENCES slot_status(id),
FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)
);



create table seating_type(
id int not null auto_increment,
type varchar(255) not null,
primary key(id)
);

create table branch_seating_type(
seating_type_id int not null,
branch_id int not null,

primary key(branch_id,seating_type_id),
FOREIGN KEY (seating_type_id) REFERENCES seating_type(id),
FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)
);

create table cuisine(
id int not null auto_increment,
name varchar(255) not null unique,

primary key(id)

);
 
create table branch_cuisine(
branch_id int not null,
cuisine_id int not null,

primary key(branch_id,cuisine_id),
FOREIGN KEY (cuisine_id) REFERENCES cuisine(id),
FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)
);



create table restaurant_type(
id int not null auto_increment,
type varchar(255) not null unique,

primary key(id)
);

create table branch_type(
type_id int not null,
branch_id int not null,

primary key(branch_id,type_id),
FOREIGN KEY (type_id) REFERENCES restaurant_type(id),
FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)
);


create table payment_type(
id int not null auto_increment,
type varchar(255) not null unique,

primary key(id)
);


create table branch_payment_type(
payment_type_id int not null,
branch_id int not null,

primary key(branch_id,payment_type_id),
FOREIGN KEY (payment_type_id) REFERENCES payment_type(id),
FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)
);

create table reservation_status(

id int not null auto_increment,
status varchar(255) not null,

primary key(id)
);

create table reservation(

reservation_id int not null auto_increment,
user_id int not null,
branch_id int not null,
booked_at datetime not null,
name varchar(255) not null,
phone_no varchar(255) not null,
guests int not null,
seating_type_id int not null,
smoking_preference varchar(255) default null, 
booking_date date not null,
slot_id int not null,
reservation_status_id int not null,
comments varchar(255)  ,

primary key (reservation_id),

FOREIGN KEY (user_id) REFERENCES user(user_id),
FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id),
FOREIGN KEY (seating_type_id) REFERENCES seating_type(id),
FOREIGN KEY (reservation_status_id) REFERENCES reservation_status (id),
FOREIGN KEY (slot_id) REFERENCES reservation_slot(slot_id)
);


create table reservartion_cancellation(

id int not null auto_increment,
reservation_id int not null,
reason varchar(255) ,

primary key(id),
FOREIGN KEY (reservation_id) REFERENCES reservation (reservation_id)


);

create table menu_category(

id int not null auto_increment,
name varchar(255) not null,
description varchar(255),

primary key(id)

);

create table menu_item(
id int not null auto_increment,
name varchar(255) not null,
item_category_id int not null,
description varchar(255),
cost int not null,
branch_id int ,

primary key(id),

FOREIGN KEY (item_category_id) REFERENCES menu_category(id),
FOREIGN KEY (branch_id) REFERENCES restaurant_branch (branch_id)

);