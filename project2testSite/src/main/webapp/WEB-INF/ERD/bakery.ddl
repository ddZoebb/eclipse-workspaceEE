DROP TABLE order_review CASCADE CONSTRAINTS;
DROP TABLE coupon CASCADE CONSTRAINTS;
DROP TABLE QnA CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE order_item CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE address CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE category CASCADE CONSTRAINTS;
DROP TABLE user_info CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: user_info */
/**********************************/
CREATE TABLE user_info(
		user_id                       		VARCHAR2(100)		 NULL ,
		user_password                 		VARCHAR2(10)		 NULL ,
		user_name                     		VARCHAR2(100)		 NULL ,
		user_email                    		VARCHAR2(100)		 NULL ,
		user_phone                    		VARCHAR2(20)		 NULL ,
		user_point                    		NUMBER(10)		 NULL 
);

COMMENT ON TABLE user_info is 'user_info';
COMMENT ON COLUMN user_info.user_id is 'user_id';
COMMENT ON COLUMN user_info.user_password is 'user_password';
COMMENT ON COLUMN user_info.user_name is 'user_name';
COMMENT ON COLUMN user_info.user_email is 'user_email';
COMMENT ON COLUMN user_info.user_phone is 'user_phone';
COMMENT ON COLUMN user_info.user_point is 'user_point';


/**********************************/
/* Table Name: category */
/**********************************/
CREATE TABLE category(
		category_no                   		NUMBER(10)		 NULL ,
		category_name                 		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE category_category_no_SEQ;

CREATE SEQUENCE category_category_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE category is 'category';
COMMENT ON COLUMN category.category_no is 'category_no';
COMMENT ON COLUMN category.category_name is 'category_name';


/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_image                       		VARCHAR2(100)		 NULL ,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_click_count                 		NUMBER(10)		 NULL ,
		category_no                   		NUMBER(10)		 NULL 
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


COMMENT ON TABLE product is 'product';
COMMENT ON COLUMN product.p_no is 'p_no';
COMMENT ON COLUMN product.p_name is 'p_name';
COMMENT ON COLUMN product.p_price is 'p_price';
COMMENT ON COLUMN product.p_image is 'p_image';
COMMENT ON COLUMN product.p_desc is 'p_desc';
COMMENT ON COLUMN product.p_click_count is 'p_click_count';
COMMENT ON COLUMN product.category_no is 'category_no';


/**********************************/
/* Table Name: cart */
/**********************************/
CREATE TABLE cart(
		cart_no                       		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_cart_no_SEQ;

CREATE SEQUENCE cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE cart is 'cart';
COMMENT ON COLUMN cart.cart_no is 'cart_no';
COMMENT ON COLUMN cart.cart_qty is 'cart_qty';
COMMENT ON COLUMN cart.user_id is 'user_id';
COMMENT ON COLUMN cart.p_no is 'p_no';


/**********************************/
/* Table Name: address */
/**********************************/
CREATE TABLE address(
		add_no                        		NUMBER(10)		 NULL ,
		address                       		VARCHAR2(50)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE address_add_no_SEQ;

CREATE SEQUENCE address_add_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE address is 'address';
COMMENT ON COLUMN address.add_no is 'add_no';
COMMENT ON COLUMN address.address is 'address';
COMMENT ON COLUMN address.user_id is 'user_id';


/**********************************/
/* Table Name: orders */
/**********************************/
CREATE TABLE orders(
		o_no                          		NUMBER(10)		 NULL ,
		o_desc                        		VARCHAR2(50)		 NULL ,
		o_date                        		DATE		 NULL ,
		o_price                       		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL ,
		add_no                        		NUMBER(10)		 NULL 
);

DROP SEQUENCE orders_o_no_SEQ;

CREATE SEQUENCE orders_o_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE orders is 'orders';
COMMENT ON COLUMN orders.o_no is 'o_no';
COMMENT ON COLUMN orders.o_desc is 'o_desc';
COMMENT ON COLUMN orders.o_date is 'o_date';
COMMENT ON COLUMN orders.o_price is 'o_price';
COMMENT ON COLUMN orders.user_id is 'user_id';
COMMENT ON COLUMN orders.add_no is 'add_no';


/**********************************/
/* Table Name: order_item */
/**********************************/
CREATE TABLE order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		oi_qty                        		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		o_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE order_item_oi_no_SEQ;

CREATE SEQUENCE order_item_oi_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


COMMENT ON TABLE order_item is 'order_item';
COMMENT ON COLUMN order_item.oi_no is 'oi_no';
COMMENT ON COLUMN order_item.oi_qty is 'oi_qty';
COMMENT ON COLUMN order_item.p_no is 'p_no';
COMMENT ON COLUMN order_item.o_no is 'o_no';


/**********************************/
/* Table Name: review */
/**********************************/
CREATE TABLE review(
		r_no                          		NUMBER(10)		 NULL ,
		r_title                       		VARCHAR2(100)		 NULL ,
		r_date                        		DATE		 NULL ,
		r_starGrade                   		NUMBER(10)		 NULL ,
		r_content                     		VARCHAR2(300)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE review_r_no_SEQ;

CREATE SEQUENCE review_r_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE review is 'review';
COMMENT ON COLUMN review.r_no is 'r_no';
COMMENT ON COLUMN review.r_title is 'r_title';
COMMENT ON COLUMN review.r_date is 'r_date';
COMMENT ON COLUMN review.r_starGrade is 'r_starGrade';
COMMENT ON COLUMN review.r_content is 'r_content';
COMMENT ON COLUMN review.user_id is 'user_id';
COMMENT ON COLUMN review.p_no is 'p_no';


/**********************************/
/* Table Name: notice */
/**********************************/
CREATE TABLE notice(
		notice_no                     		NUMBER(10)		 NULL ,
		notice_title                  		VARCHAR2(100)		 NULL ,
		notice_date                   		DATE		 NULL ,
		notice_content                		VARCHAR2(200)		 NULL 
);

DROP SEQUENCE notice_notice_no_SEQ;

CREATE SEQUENCE notice_notice_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE notice is 'notice';
COMMENT ON COLUMN notice.notice_no is 'notice_no';
COMMENT ON COLUMN notice.notice_title is 'notice_title';
COMMENT ON COLUMN notice.notice_date is 'notice_date';
COMMENT ON COLUMN notice.notice_content is 'notice_content';


/**********************************/
/* Table Name: QnA */
/**********************************/
CREATE TABLE QnA(
		qna_no                        		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL ,
		qna_title                     		VARCHAR2(100)		 NULL ,
		qna_date                      		DATE		 DEFAULT sysdate		 NULL ,
		qna_content                   		VARCHAR2(200)		 NULL ,
		qna_readcount                 		NUMBER(10)		 DEFAULT 0		 NULL ,
		groupno                       		NUMBER(10)		 NULL ,
		step                          		NUMBER(10)		 NULL ,
		depth                         		NUMBER(10)		 DEFAULT 0		 NULL 
);

DROP SEQUENCE QnA_qna_no_SEQ;

CREATE SEQUENCE QnA_qna_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE QnA is 'QnA';
COMMENT ON COLUMN QnA.qna_no is 'qna_no';
COMMENT ON COLUMN QnA.user_id is 'user_id';
COMMENT ON COLUMN QnA.qna_title is 'qna_title';
COMMENT ON COLUMN QnA.qna_date is 'qna_date';
COMMENT ON COLUMN QnA.qna_content is 'qna_content';
COMMENT ON COLUMN QnA.qna_readcount is 'qna_readcount';
COMMENT ON COLUMN QnA.groupno is 'groupno';
COMMENT ON COLUMN QnA.step is 'step';
COMMENT ON COLUMN QnA.depth is 'depth';


/**********************************/
/* Table Name: coupon */
/**********************************/
CREATE TABLE coupon(
		c_no                          		NUMBER(10)		 NULL ,
		c_start_date                  		DATE		 NULL ,
		c_end_date                    		DATE		 NULL ,
		c_discount                    		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE coupon_c_no_SEQ;

CREATE SEQUENCE coupon_c_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE coupon is 'coupon';
COMMENT ON COLUMN coupon.c_no is 'c_no';
COMMENT ON COLUMN coupon.c_start_date is 'c_start_date';
COMMENT ON COLUMN coupon.c_end_date is 'c_end_date';
COMMENT ON COLUMN coupon.c_discount is 'c_discount';
COMMENT ON COLUMN coupon.user_id is 'user_id';


/**********************************/
/* Table Name: order_review */
/**********************************/
CREATE TABLE order_review(
		r_no                          		NUMBER(10)		 NULL ,
		oi_no                         		NUMBER(10)		 NULL 
);

COMMENT ON TABLE order_review is 'order_review';
COMMENT ON COLUMN order_review.r_no is 'r_no';
COMMENT ON COLUMN order_review.oi_no is 'oi_no';



ALTER TABLE user_info ADD CONSTRAINT IDX_user_info_PK PRIMARY KEY (user_id);

ALTER TABLE category ADD CONSTRAINT IDX_category_PK PRIMARY KEY (category_no);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);
ALTER TABLE product ADD CONSTRAINT IDX_product_FK0 FOREIGN KEY (category_no) REFERENCES category (category_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE address ADD CONSTRAINT IDX_address_PK PRIMARY KEY (add_no);
ALTER TABLE address ADD CONSTRAINT IDX_address_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (o_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK1 FOREIGN KEY (add_no) REFERENCES address (add_no);

ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (p_no) REFERENCES product (p_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (o_no) REFERENCES orders (o_no);

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (r_no);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE notice ADD CONSTRAINT IDX_notice_PK PRIMARY KEY (notice_no);

ALTER TABLE QnA ADD CONSTRAINT IDX_QnA_PK PRIMARY KEY (qna_no);
ALTER TABLE QnA ADD CONSTRAINT IDX_QnA_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id);

ALTER TABLE coupon ADD CONSTRAINT IDX_coupon_PK PRIMARY KEY (c_no);
ALTER TABLE coupon ADD CONSTRAINT IDX_coupon_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id);

ALTER TABLE order_review ADD CONSTRAINT IDX_order_review_FK0 FOREIGN KEY (r_no) REFERENCES review (r_no)on delete CASCADE;
ALTER TABLE order_review ADD CONSTRAINT IDX_order_review_FK1 FOREIGN KEY (oi_no) REFERENCES order_item (oi_no)on delete CASCADE;

