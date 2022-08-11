insert into orders values(orders_o_no_SEQ.nextval,'배송중',sysdate,10000,'juhee13',1);
insert into orders values(orders_o_no_SEQ.nextval,'배송중',sysdate,5000,'juhee13',3);
insert into orders values(orders_o_no_SEQ.nextval,'배송준비',sysdate,3000,'jungwook1234',4);
insert into orders values(orders_o_no_SEQ.nextval,'배송완료',sysdate,10000,'jungwook1234',2);
insert into orders values(orders_o_no_SEQ.nextval,'배송중',sysdate,2000,'jungwook1234',3);
insert into orders values(orders_o_no_SEQ.nextval,'배송준비',sysdate,4000,'juhee13',5);
insert into orders values(orders_o_no_SEQ.nextval,'배송완료',sysdate,10000,'jungwook1234',8);

------------------------------order_item---------------------------------
insert into order_item values(order_item_oi_no_SEQ.nextval,2,1,1);
insert into order_item values(order_item_oi_no_SEQ.nextval,1,2,2);
insert into order_item values(order_item_oi_no_SEQ.nextval,2,3,7);
insert into order_item values(order_item_oi_no_SEQ.nextval,3,4,8);
insert into order_item values(order_item_oi_no_SEQ.nextval,4,5,9);
insert into order_item values(order_item_oi_no_SEQ.nextval,5,6,10);

desc order_review;
/*
이름    널? 유형         
----- -- ---------- 
R_NO     NUMBER(10) 
OI_NO    NUMBER(10) 
*/

--insert 
-- 리뷰작성시 
insert into order_review(r_no,oi_no) values(2,33);

select * from order_review o 
join order_item oi
on o.oi_no=oi.oi_no
join orders os
on oi.o_no= os.o_no
where o.oi_no=33;