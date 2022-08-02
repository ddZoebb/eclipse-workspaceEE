package ReviewDAO;

import reviewDTO.Review;
import userDTO.Product;

public class ReviewDaoTestMain {
	public static void main(String[] args) throws Exception {
		ReviewDAO reviewDao=new ReviewDAO();
		String id="one";
		System.out.println("리뷰작성");
		//System.out.println(reviewDao.createReview(new Review(0, "테스트리뷰", null, 5, "테스트내용", id, new Product(14, null, 0, null, null, 0, 0))));
		
		System.out.println("리뷰수정");
		System.out.println(reviewDao.updateReview(new Review(19, "업데이트", null, 1, "업데이트내용", null, null)));
	
		System.out.println("리뷰삭제");
		System.out.println(reviewDao.deleteReview(new Review(18, null, null, 0, null, null, null)));
	}
	
	

}
