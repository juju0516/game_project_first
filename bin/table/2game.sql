
/* Drop Tables */

DROP TABLE customer2 CASCADE CONSTRAINTS;
DROP TABLE rank CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE customer2
(
	c_idx number(10,0) NOT NULL,
	nickname varchar2(50) NOT NULL,
	id varchar2(50) NOT NULL,
	pw varchar2(50) NOT NULL,
	name varchar2(50) NOT NULL,
	phone varchar2(50) NOT NULL,
	birth number(10,0) NOT NULL,
	quiz varchar2(50) NOT NULL,
	quiz_a varchar2(50) NOT NULL,
	PRIMARY KEY (c_idx)
);


CREATE SEQUENCE customer2_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 999999999
NOCYCLE;

GRANT SELECT ON customer2_seq TO C##ictedu;

CREATE TABLE rank
(
	c_idx number(10,0) NOT NULL,
	r_idx number(10,0) NOT NULL,
	topscore number(10,0),
	PRIMARY KEY (c_idx)
);



