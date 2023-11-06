delimiter //
create procedure calfine(in _roll int,in _book varchar(255))
begin
declare fine int;
declare days int;
declare date_of_issue date;
declare exit handler for not found
begin
select 'not found' as message;
end;
select DOI into date_of_issue from borrower where Book=_book and Roll=_roll;
set days=DATEDIFF(CURDATE(),date_of_issue);
if days<0 then
signal sqlstate '45000'
set message_text='No of days cant be negative';
end if;
if days>=15 and days<=30 then
set fine=(days-15)*5;
elseif days>30 then
set fine=(days-15)*50;
end if;
insert into fine values(_roll,DOI,fine);
end;
//