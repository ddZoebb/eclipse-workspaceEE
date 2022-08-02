package ReviewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import reviewDTO.Review;

public class ReviewDAO {

	private DataSource dataSource;

	public ReviewDAO() throws Exception {
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("user"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}

	public int createReview(Review review) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReviewSQL.REVIEW_CREATE);
			pstmt.setString(1, review.getR_title());
			pstmt.setInt(2, review.getR_stargrade());
			pstmt.setString(3, review.getR_content());
			pstmt.setString(4, review.getUser_id());
			pstmt.setInt(5, review.getProduct().getP_no());

			rowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

		return rowCount;
	}

	public int updateReview(Review review) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReviewSQL.REVIEW_UPDATE);
			//update review set r_stargrade=?, r_title=?,r_content=? where r_no=?
			pstmt.setInt(1, review.getR_stargrade());
			pstmt.setString(2, review.getR_title());
			pstmt.setString(3, review.getR_content());
			pstmt.setInt(4, review.getR_no());
			rowCount=pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		
		return rowCount;
	}
	
	public int deleteReview(Review review) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(ReviewSQL.REVIEW_DELETE);
			pstmt.setInt(1, review.getR_no());
			rowCount=pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		
		return rowCount;
	}

}
