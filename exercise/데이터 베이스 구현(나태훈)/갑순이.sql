create sequence soonA_seq 
increment by 1 start with 1;

create table BranchA(
    id number,
    name varchar2(30),
    publisher varchar2(30),
    price number
    );
    
insert into BranchA values(soonA_seq.nextval, '야구의 역사', '데일리 스포츠', 1000);
insert into BranchA values(soonA_seq.nextval, '월간 축구', '가나 출판사', 2000);
insert into BranchA values(soonA_seq.nextval, '스포츠의 이해', '대한 출판사', 3000);
    
create sequence soonB_seq 
increment by 1 start with 1;

create table BranchB(
    id number,
    name varchar2(30),
    publisher varchar2(30),
    price number
    );
    
insert into BranchB values(soonB_seq.nextval, '야구의 역사', '데일리 스포츠', 1000);
insert into BranchB values(soonB_seq.nextval, '당구 교본', '대한 출판사', 4000);
insert into BranchB values(soonB_seq.nextval, '호신술', '데일리 스포츠', 5000);


create table MyBranch as select BranchA.id as Id, BranchA.name as Name, BranchA.publisher as Publisher, BranchA.price as Price from BranchA
union
select BranchB.id as Id, BranchB.name as Name, BranchB.publisher as Publisher, BranchB.price as Price from BranchB;


