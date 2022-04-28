create sequence soonA_seq 
increment by 1 start with 1;

create table BranchA(
    id number,
    name varchar2(30),
    publisher varchar2(30),
    price number
    );
    
insert into BranchA values(soonA_seq.nextval, '�߱��� ����', '���ϸ� ������', 1000);
insert into BranchA values(soonA_seq.nextval, '���� �౸', '���� ���ǻ�', 2000);
insert into BranchA values(soonA_seq.nextval, '�������� ����', '���� ���ǻ�', 3000);
    
create sequence soonB_seq 
increment by 1 start with 1;

create table BranchB(
    id number,
    name varchar2(30),
    publisher varchar2(30),
    price number
    );
    
insert into BranchB values(soonB_seq.nextval, '�߱��� ����', '���ϸ� ������', 1000);
insert into BranchB values(soonB_seq.nextval, '�籸 ����', '���� ���ǻ�', 4000);
insert into BranchB values(soonB_seq.nextval, 'ȣ�ż�', '���ϸ� ������', 5000);


create table MyBranch as select BranchA.id as Id, BranchA.name as Name, BranchA.publisher as Publisher, BranchA.price as Price from BranchA
union
select BranchB.id as Id, BranchB.name as Name, BranchB.publisher as Publisher, BranchB.price as Price from BranchB;


