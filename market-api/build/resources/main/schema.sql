create table survey
(
   subject varchar(255) not null,
   country varchar(3) not null,
   primary key(subject)
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
   survey_id varchar(255) not null,
   target_id bigint not null,
   primary key(id),
foreign key (survey_id) references SURVEY(subject),
foreign key (target_id) references TARGET(id)
);

create table provider
(
   id VARCHAR(5),
   name VARCHAR(255) not null,
   email VARCHAR(255),
   api_url VARCHAR(255),
   ftp_url VARCHAR(255),
   primary key(id)
);