package ReviewDAO;

import reviewDTO.Order_ReviewDto;

public class OrderReviewDaoTestMain {
	public static void main(String[] args) throws Exception {
		OrderReviewDAO orDao = new OrderReviewDAO();
		System.out.println("1. 리뷰작성시 or 테이블에 insert");
		//System.out.println(orDao.insertOR(new Order_ReviewDto(33, 2)));
		
		System.out.println("2. 해당 order item 리뷰작성했었는지 check ");
		System.out.println(orDao.checkOR(33));
		System.out.println(orDao.checkOR(36));
		System.out.println(orDao.checkOR(40));

	}

}
