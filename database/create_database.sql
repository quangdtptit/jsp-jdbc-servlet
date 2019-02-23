create database quanlynews;
use quanlynews;
create table role
(
	id bigint not null auto_increment primary key,
    name varchar(255) not null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby nvarchar(255) null,
    modifiedby nvarchar(255) null
);

create table user
(
	id bigint not null auto_increment primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    fullname nvarchar(255) null,
    status int not null ,
    roleid bigint,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby nvarchar(255) null,
    modifiedby nvarchar(255) null,
    constraint fk_user_role foreign key (roleid) references role(id)
);

create table category
(
	id bigint not null auto_increment primary key,
    name nvarchar(255) null,
    code varchar(255) null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby nvarchar(255) null,
    modifiedby nvarchar(255) null
);

create table news
(
	id bigint not null auto_increment primary key,
    title nvarchar(255) null,
    thumbnail varchar(255) null,
    shortdescription text null,
    content text null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby nvarchar(255) null,
    modifiedby nvarchar(255) null,
    categoryid bigint,
    constraint fk_news_category foreign key (categoryid) references category(id)
);

create table comment
(
	id bigint not null auto_increment primary key,
    content text not null,
    user_id bigint not null ,
    news_id bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby nvarchar(255) null,
    modifiedby nvarchar(255) null,
    constraint fk_comment_user foreign key (user_id) references user(id),
    constraint fk_comment_news foreign key (news_id) references news(id)
);



