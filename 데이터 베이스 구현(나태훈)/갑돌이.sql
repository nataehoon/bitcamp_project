create user dori identified by dori account unlock ;
alter user dori default tablespace users ;
grant connect, resource to dori ;

create table members(
    id varchar2(10) primary key,
    name varchar2(30) not null,
    address varchar2(15),
    hobby varchar2(30) check(hobby in('당구', '퀄트', '맞고')),
    salary number default 100
    );

insert into members values('hong', '홍길동', '마포 공덕', '당구', 100);
insert into members values('park', '박영희', '용산 도원', '퀄트', 200);
insert into members values('kim', '김철수', '강남 역삼', '맞고', 300);
insert into members values('choi', '최재우', '세종시', '맞고', 400);
    
create table boards(
    writer varchar2(10),
    subject varchar2(30),
    password varchar2(15),
    content varchar2(50),
    readhit number default 0
    );
    
insert into boards values('hong', 'jsp어려워', '1234', '정말 어려워요', 0);
insert into boards values('hong', '어떤 글', '1234', '정말 쉬워요', 5);
insert into boards values('hong', '열공합시다', '1234', '멍멍멍', 2);
insert into boards values('hong', '어떤 글', '1234', '하하하하하하', 0);
insert into boards values('hong', '열공 합시다', '1234', '히히히히', 5);

alter table boards
add constraint asdf_fk
foreign key(writer) references members(id) on delete set null;


create user soon identified by soon account unlock ;
alter user soon default tablespace users ;
grant connect, resource to soon ;

alter table members drop column hobby;
alter table members add hobby varchar(30);
alter table members modify address varchar(30);

insert into members values('lee', '이순신', '서대문 신촌', '조깅', 500);
insert into members values('shin', '신사임당', '서대문 신촌', '조깅', 30);

alter table members rename constraint SYS_C007377 to members_writer_fk;