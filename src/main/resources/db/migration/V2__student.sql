create table Student(
  id bigint not null primary key auto_increment,
  firstName varchar(64),
  lastName varchar(64),
  idClass long not null
);

insert into Student values(1, 'Mickey', 'Mouse', 1);
insert into Student values(2, 'Donald', 'Duck', 1);
insert into Student values(3, 'Minnie', 'Mouse', 2);
insert into Student values(4, 'Daisy', 'Duck', 2);
