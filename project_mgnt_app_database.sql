use project_mgnt_app;
create table details(year int,dept varchar(10),roll_no int
,name varchar(100),sub varchar(50));
insert into details values (4,"cse",51,"mahendran","oose"),(4,"cse",85,"tonystrak","fds");
select*from details;
delete from details where year=4;
insert into details values(4,"cse",85,"srihariharan","oose");