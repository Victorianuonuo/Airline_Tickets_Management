drop trigger ia_z;
delimiter $$
create trigger ia_z
before insert on datetable
for each row
begin
	if(new.date_index <0 ) then insert into xxxx value(1,1,1);
    end if;
end;
$$

drop trigger upnot_z;
delimiter $$
create trigger upnot_z
before update on datetable
for each row
begin
	if(new.date_index <0 ) then insert into xxxx value(1,1,1);
    end if;
end;
$$

drop trigger li_not_z;
delimiter $$
create trigger li_not_z
before insert on flight_class
for each row
begin
	if(new.price <0 or new.remain<0 or new.take < 0 ) then insert into xxxx value(1,1,1);
    end if;
end;
$$

drop trigger lu_not_z;
delimiter $$
create trigger lu_not_z
before update on flight_class
for each row
begin
	if(new.price <0 or new.remain<0 or new.take < 0 ) then insert into xxxx value(1,1,1);
    end if;
end;
$$

drop trigger l2u_not_z;
delimiter $$
create trigger l2u_not_z
before update on passenger
for each row
begin
	if(new.balance <0 ) then insert into xxxx value(1,1,1);
    end if;
end;
$$

drop trigger l2i_not_z;
delimiter $$
create trigger l2i_not_z
before insert on passenger
for each row
begin
	if(new.balance <0 ) then insert into xxxx value(1,1,1);
    end if;
end;
$$

drop trigger l3u_not_z;
delimiter $$
create trigger l3u_not_z
before update on plane_class
for each row
begin
	if(new.class_quantity <0 or new.class_column < 0 ) then insert into xxxx value(1,1,1);
    end if;
end;
$$


drop trigger l3i_not_z;
delimiter $$
create trigger l3i_not_z
before insert on plane_class
for each row
begin
	if(new.class_quantity <0 or new.class_column < 0) then insert into xxxx value(1,1,1);
    end if;
end;
$$

drop trigger l4u_not_z;
delimiter $$
create trigger l4u_not_z
before update on route
for each row
begin
	if(new.frequency < 0 or new.basic_index < 0) then insert into xxxx value(1,1,1);
    end if;
end;
$$


drop trigger l4i_not_z;
delimiter $$
create trigger l4i_not_z
before insert on route
for each row
begin
	if(new.frequency < 0 or new.basic_index < 0) then insert into xxxx value(1,1,1);
    end if;
end;
$$

drop trigger l5u_not_z;
delimiter $$
create trigger l5u_not_z
before update on ticket
for each row
begin
	if(new.booking_reference < 0 or new.worth < 0) then insert into xxxx value(1,1,1);
    end if;
end;
$$


drop trigger l5i_not_z;
delimiter $$
create trigger l5i_not_z
before insert on ticket
for each row
begin
	if(new.booking_reference < 0 or new.worth < 0) then insert into xxxx value(1,1,1);
    end if;
end;
$$



