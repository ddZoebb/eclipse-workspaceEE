DROP TABLE ADDRESS CASCADE CONSTRAINTS;
DROP TABLE LOGIN CASCADE CONSTRAINTS;
DROP TABLE USERIN CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: USERIN */
/**********************************/
CREATE TABLE USERIN(
		id                            		VARCHAR2(30)		 NULL ,
		name                          		VARCHAR2(10)		 NULL ,
		phone                         		VARCHAR2(10)		 NULL ,
		email                         		VARCHAR2(10)		 NULL 
);

COMMENT ON TABLE USERIN is 'USERIN';
COMMENT ON COLUMN USERIN.id is 'id';
COMMENT ON COLUMN USERIN.name is 'name';
COMMENT ON COLUMN USERIN.phone is 'phone';
COMMENT ON COLUMN USERIN.email is 'email';


/**********************************/
/* Table Name: LOGIN */
/**********************************/
CREATE TABLE LOGIN(
		pass                          		VARCHAR2(10)		 NOT NULL,
		id                            		VARCHAR2(30)		 NULL 
);

COMMENT ON TABLE LOGIN is 'LOGIN';
COMMENT ON COLUMN LOGIN.pass is 'pass';
COMMENT ON COLUMN LOGIN.id is 'id';


/**********************************/
/* Table Name: ADDRESS */
/**********************************/
CREATE TABLE ADDRESS(
		adre                          		VARCHAR2(10)		 NULL ,
		id                            		VARCHAR2(30)		 NULL ,
		ad_no                         		NUMBER(10)		 NULL 
);

DROP SEQUENCE ADDRESS_ad_no_SEQ;

CREATE SEQUENCE ADDRESS_ad_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


BEGIN
IF :NEW.ad_no IS NOT NULL THEN
  SELECT ADDRESS_ad_no_SEQ.NEXTVAL INTO :NEW.ad_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE ADDRESS is 'ADDRESS';
COMMENT ON COLUMN ADDRESS.adre is 'adr';
COMMENT ON COLUMN ADDRESS.id is 'id';
COMMENT ON COLUMN ADDRESS.ad_no is 'ad_no';



ALTER TABLE USERIN ADD CONSTRAINT IDX_USERIN_PK PRIMARY KEY (id);

ALTER TABLE LOGIN ADD CONSTRAINT IDX_LOGIN_PK PRIMARY KEY (id);
ALTER TABLE LOGIN ADD CONSTRAINT IDX_LOGIN_FK0 FOREIGN KEY (id) REFERENCES USERIN (id);

ALTER TABLE ADDRESS ADD CONSTRAINT IDX_ADDRESS_PK PRIMARY KEY (ad_no);
ALTER TABLE ADDRESS ADD CONSTRAINT IDX_ADDRESS_FK0 FOREIGN KEY (id) REFERENCES USERIN (id);

