create table tag
(
	id bigserial not null,
	label character varying(30)
);
alter table tag add constraint tag_pk primary key (id);

create table person
(
	id bigserial not null,
	name character varying(200),
	middle_name character varying(200),
	surname character varying(200),
	title bigint,
	gender bigint,
	birth_date date,
	social_security character varying(15),
	contact_phone character varying(1),
	contact_email character varying(1),
	contact_address character varying(1)
);
alter table person add constraint person_pk primary key (id);

create table person_tag
(
	id bigserial not null,
	person_id bigint not null,
	tag_id bigint not null
);
alter table person_tag add constraint person_tag_pk primary key (id);
alter table person_tag add constraint person_tag_person_id foreign key (person_id) references person(id);
alter table person_tag add constraint person_tag_tag_id foreign key (tag_id) references tag(id);

create table agent
(
	id bigserial not null,
	title character varying(100) not null
);
alter table agent add constraint agent_pk primary key (id);

create table account
(
	id bigserial not null,
	name character varying(200) not null,
	person_id bigint,
	agent_id bigint,
	pin_number character varying(200)
);
alter table account add constraint account_pk primary key (id);
alter table account add constraint account_person_id foreign key (person_id) references person(id);
alter table account add constraint account_agent_id foreign key (agent_id) references agent(id);

create table email
(
	id bigserial NOT NULL ,
	account_id bigint not null,
	address character varying(200) not null
);
alter table email add constraint email_pk primary key (id);
alter table email add constraint email_account_id foreign key (account_id) references account(id); 

create table address
(
	id bigserial NOT NULL ,
	account_id bigint not null,
	country character varying(2),
	city character varying(100),
	state character varying(100),
	address_line_1 character varying(50),
	address_line_2 character varying(50),
	address_line_3 character varying(50),
	po_box character varying(10),
	zip_code character varying(10)
);
alter table address add constraint address_pk primary key (id);
alter table address add constraint address_account_id foreign key (account_id) references account(id); 

create table phone
(
	id bigserial NOT NULL ,
	account_id bigint not null,
	country_code character varying(5),
	area_code character varying(5),
	number character varying(11),
	ext character varying(5)
);
alter table phone add constraint phone_pk primary key (id);
alter table phone add constraint phone_account_id foreign key (account_id) references account(id); 

create table currency
(
	id bigserial not null,
	code character varying(3),
	name character varying(20)
);
alter table currency add constraint currency_pk primary key (id);

create table partner
(
	id bigserial not null,
	code bigint not null,
	name character varying(100) not null
);
alter table partner add constraint partner_pk primary key (id);

create table transaction
(
	id bigserial not null,
	account_id bigint not null,
	partner_id bigint not null,
	amount	bigint not null,
	currency_id bigint not null,
	create_date timestamp,
	transaction_date timestamp,
	valid_until timestamp
);
alter table transaction add constraint transaction_pk primary key (id);
alter table transaction add constraint transaction_account_id foreign key (account_id) references account(id);
alter table transaction add constraint transaction_currency_id foreign key (currency_id) references currency(id); 
alter table transaction add constraint transaction_partner_id foreign key (partner_id) references partner(id); 

