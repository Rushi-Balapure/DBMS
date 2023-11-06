delimiter //
create procedure grade(in _roll int)
begin
declare class varchar(255);
declare _name varchar(255);
declare r int;
declare _marks int;
declare exit handler for not found
begin
select 'not found ' as message;
end;
select marks into _marks , name into _name from stud_marks where roll=_roll;
if _marks<0 then
signal sqlstate '45000'
set message_text='marks cant be -ve';
end if;
if _marks >900 then 
set class='merit';
end if;
set r=res(_roll,_name,class);
end;
//
delimiter;
