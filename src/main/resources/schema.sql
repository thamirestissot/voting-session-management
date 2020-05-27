create table associate (
	id serial  primary key,
	user_name varchar(255) not null
);
create table topic (
  id serial primary key,
  title varchar(255) not null,
  description varchar(255)
);
create table votingsession (
  id serial primary key,
  createdDate timestamp,
  title varchar(255) not null,
  closeDate timestamp,
  id_topic int not null,
  foreign key (id_topic) references topic (id)
);
create table vote (
  id serial primary key,
  choice boolean not null,
  id_associate int not null,
  id_votingsession int not null,
  foreign key (id_associate) references associate (id),
  foreign key (id_votingsession) references votingsession (id)
);
