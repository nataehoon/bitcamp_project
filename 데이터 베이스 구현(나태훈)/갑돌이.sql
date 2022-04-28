create user dori identified by dori account unlock ;
alter user dori default tablespace users ;
grant connect, resource to dori ;

create table members(
    id varchar2(10) primary key,
    name varchar2(30) not null,
    address varchar2(15),
    hobby varchar2(30) check(hobby in('�籸', '��Ʈ', '�°�')),
    salary number default 100
    );

insert into members values('hong', 'ȫ�浿', '���� ����', '�籸', 100);
insert into members values('park', '�ڿ���', '��� ����', '��Ʈ', 200);
insert into members values('kim', '��ö��', '���� ����', '�°�', 300);
insert into members values('choi', '�����', '������', '�°�', 400);
    
create table boards(
    writer varchar2(10),
    subject varchar2(30),
    password varchar2(15),
    content varchar2(50),
    readhit number default 0
    );
    
insert into boards values('hong', 'jsp�����', '1234', '���� �������', 0);
insert into boards values('hong', '� ��', '1234', '���� ������', 5);
insert into boards values('hong', '�����սô�', '1234', '�۸۸�', 2);
insert into boards values('hong', '� ��', '1234', '������������', 0);
insert into boards values('hong', '���� �սô�', '1234', '��������', 5);

alter table boards
add constraint asdf_fk
foreign key(writer) references members(id) on delete set null;


create user soon identified by soon account unlock ;
alter user soon default tablespace users ;
grant connect, resource to soon ;

alter table members drop column hobby;
alter table members add hobby varchar(30);
alter table members modify address varchar(30);

insert into members values('lee', '�̼���', '���빮 ����', '����', 500);
insert into members values('shin', '�Ż��Ӵ�', '���빮 ����', '����', 30);

alter table members rename constraint SYS_C007377 to members_writer_fk;