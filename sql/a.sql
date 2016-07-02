drop schema foo;
create schema foo;

use foo;

create table passenger
	(passenger_id	char(18) primary key,
	passenger_alias varchar(30) unique,
	passenger_password varchar(30) not null,
	passenger_name varchar(30) not null,
	balance decimal(9,2) not null default 0);
    
create table class
	(class_name char(1) primary key,
    class_index double not null,
    class_detail varchar(30));
    
create table plane_class
	(plane_type varchar(30),
    class_name char(1),
    class_quantity int not null,
    class_column int not null,
    primary key(plane_type, class_name),
    foreign key(class_name) references class(class_name)
    );

create table datetable
	(festival date primary key,
    date_index double not null default 1.1);

create table route
	(flight_id varchar(8) primary key,
	start_port varchar(30) not null,
	end_port varchar(30) not null,
	start_time time not null,
	end_time time not null,
    frequency int unsigned not null default 1,
	company varchar(30) not null,
	plane_type varchar(30) not null,
	basic_index decimal(7,2) not null,
	foreign key(plane_type) references plane_class(plane_type));

create table flight
	(flight_id varchar(8),
	flight_date date,
	primary key(flight_id, flight_date),
	foreign key(flight_id) references route(flight_id));
    
create table flight_class
	(flight_id varchar(8),
    flight_date date,
    class_name char(1),
    price decimal(7,2) not null,
    remain int not null,
    take int not null,
    primary key(flight_id, flight_date, class_name),
    foreign key(flight_id, flight_date) references flight(flight_id, flight_date),
    foreign key(class_name) references class(class_name));

create table ticket
	(booking_reference int unsigned not null auto_increment,
	passenger_id varchar(30) not null,
	flight_id varchar(7),
	flight_date date,
	class_name char(1) not null,
    seat varchar(5),
    worth decimal(7,2) not null,
    primary key(booking_reference),
	foreign key(passenger_id) references passenger(passenger_id),
	foreign key(flight_id, flight_date, class_name) references flight_class(flight_id, flight_date, class_name));

create view flight_book_query(flight_id, flight_date, start_port, end_port, start_time, end_time)
as 
	(select flight_id, flight_date, start_port, end_port, start_time, end_time
	from flight
		join route using(flight_id));
        
create view class_book_query(flight_id, flight_date, start_port, end_port, class_name, price, remain)
as
	(select flight_id, flight_date, start_port, end_port, class_name, price, remain
    from flight
		join flight_class using(flight_id, flight_date)
        join route using(flight_id));
        
create view ticket_query(booking_reference, flight_id, flight_date, class_name, worth)
as
	(select booking_reference, flight_id, flight_date, class_name, worth
    from ticket
    where seat is null);
    
create view print_query(company, booking_reference, passenger_name, start_port, end_port, flight_id, class_name, flight_date, start_time, end_time, seat)
as
	(select company, booking_reference, passenger_name, start_port, end_port, flight_id, class_name, flight_date, start_time, end_time, seat
    from ticket
		join route using (flight_id)
        join passenger using (passenger_id)
    );

