drop database `doctor-appointment-management-application`;

create database if not exists `doctor-appointment-management-application`;

use `doctor-appointment-management-application`;

create table admin(
	id int primary key auto_increment,
    email varchar(255) not null unique,
    password varchar(255) not null
);

create table doctor(
	id int primary key auto_increment,
    full_name varchar(255) not null,
    email varchar(255) not null unique,
    mobile_number varchar(10) not null,	
    gender varchar(20) not null,
    specialization varchar(255) not null
);

create table patient(
	id int primary key auto_increment,
    full_name varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    mobile_number varchar(10) not null,	
    gender varchar(20) not null,
    dob date not null,
    address varchar(255) not null
);


create table appointment(
	id int primary key auto_increment,
    doctor_id int not null,
    patient_id int not null,
    date date not null,
    description text,
    status varchar(255) default "Pending" not null,
    remarks text,
    foreign key(doctor_id) references Doctor(id) on delete cascade,
    foreign key(patient_id) references Patient(id) on delete cascade
);