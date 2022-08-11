package ReviewDAO;

public class OrderReviewSQL {
	public final static String INSERT_OR
	="insert into order_review(r_no,oi_no) values(?,?)";
	
	public final static String SELECT_OR
	="select count(*) from order_review where oi_no=?";

}
