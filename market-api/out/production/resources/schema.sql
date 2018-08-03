create table survey
(
   id bigint auto_increment,
   subject varchar(255) not null,
   country varchar(3) not null,
   primary key(id)
);



create table target
(
   id bigint auto_increment,
   gender CHAR(1) not null,
   age Integer,
   income_currency VARCHAR(100),
   income_quantity FLOAT,
   primary key(id)
);

create table survey_data
(
   id bigint auto_increment,
   survey_id bigint not null,
   target_id bigint not null,
   primary key(id),
foreign key (survey_id) references SURVEY(id),
foreign key (target_id) references TARGET(id)
);