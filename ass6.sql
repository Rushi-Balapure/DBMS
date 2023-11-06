delimiter //
create procedure copy(int _roll int)
begin
declare flag boolean;
declare c1 cursor for select roll from stud_marks where roll=_roll;
open c1;
fetch c1 into _roll;
set flag=False;
if not exists(select * from n_stud_marks where roll=_roll) then
set flag=True;
insert into n_stud_marks
select * from stud_marks
where roll=_roll;
end if;
if not flag then
select "recored " as message;
else
select * from n_stud_marks;
end if;
close c1;
end //