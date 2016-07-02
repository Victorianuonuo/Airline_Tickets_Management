delimiter $$
create procedure update_flight()
begin
	declare cnt int(10);
    declare c   int(10);
	declare id varchar(20);
    declare fre int(10);
    declare b_index decimal(7,2);
    declare d_index double;
    declare c_index double;
    declare temp double;
    declare old_date date;
    declare now_date date;
    declare name varchar(8);
    declare ptype varchar(30);
    declare quantity int(10);
    declare cur_rte cursor for select flight_id, basic_index , class_name , class_quantity from  route join plane_class using (plane_type);
    declare cur_flc cursor for select flight_id,flight_date,class_name from flight_class;
		set now_date = curdate();
        open cur_flc;
        repeat 
			fetch cur_flc into id, old_date,name;
            if(datediff(old_date,now_date)>0) then 
				delete 
                from flight_class 
                where flight_id = id and datediff(old_date,flight_date)=0 and class_name = name;
            else
				select basic_index from route where id = route.flight_id into b_index;
				select class_index from class where name = class_name into c_index;
                select date_index from datetable where old_date = festival into d_index;
                set b_index = b_index * c_index * d_index - b_index * datediff(old_date,now_date) * 0.005 ;
                update flight_class set price = b_index where flight_id = id and datediff(old_date,flight_date)=0 and class_name = name;
            end if;
		until done end repeat; 
        close cur_flc;
        
        delete from flight;
        
        open cur_rte;
        repeat
			fetch cur_rte into id, b_index,name,quantity;
            set c = 0;
            while c <=30 do
				select count(*) from flight_class group by date_add(now_date,interval c day) into cnt;
                if(cnt = 0) then 
					select basic_index from route where id = route.flight_id into b_index;
					select count(*) from datetable where date_add(now_date,interval c day) = festival into cnt;
                    if(cnt !=0 ) then
						select date_index from datetable where date_add(now_date,interval c day) = festival into d_index;
						select class_index from class where name = class_name into c_index;
                        set temp = b_index * c_index * d_index - b_index * c * 0.005 ;
						insert into flight_class value(id,date_add(now_date,interval c day),name,temp,quantity,0);
                    else
						select class_index from class where name = class_name into c_index;
                        set temp = b_index * c_index  - b_index * c * 0.005 ;
						insert into flight_class value(id,date_add(now_date,interval c day),name,temp,quantity,0);
                    end if;
				end if;
                set c = c + 1;
            end while;
		until done end repeat;
end$$