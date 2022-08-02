package userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import userDTO.Address;
import userDTO.User_info;

public class UserDAO {
	private DataSource dataSource;
	public UserDAO() throws Exception {
		 Properties properties=new Properties();
		  properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
		  /*** Apache DataSource ***/
		  BasicDataSource basicDataSource = new BasicDataSource();
		  basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		  basicDataSource.setUrl(properties.getProperty("url"));
		  basicDataSource.setUsername(properties.getProperty("user"));
		  basicDataSource.setPassword(properties.getProperty("password")); 
		  dataSource = basicDataSource; 
	}
	
	public int createUser(User_info user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_INSERT);
		//PreparedStatement pstmt2=con.prepareStatement(UserSQL.ADDRESS_INSERT);
		//user_id,user_password,user_name,user_email,user_phone,user_point
		pstmt.setString(1, user.getUser_id());
		pstmt.setString(2, user.getUser_password());
		pstmt.setString(3, user.getUser_name());
		pstmt.setString(4, user.getUser_email());
		pstmt.setString(5, user.getUser_phone());
		pstmt.setInt(6, user.getUser_point());
		
		int rowCount=pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	public int createAddress(Address address) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.ADDRESS_INSERT);
		pstmt.setString(1, address.getAddress());
		pstmt.setString(2, address.getUser_id());
		
		int rowCount=pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	public int updateUser(User_info user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_UPDATE);
		//user_password=?,user_name=?,user_phone=?,user_email=? where user_id=?
		
		pstmt.setString(1, user.getUser_password());
		pstmt.setString(2, user.getUser_name());
		pstmt.setString(3, user.getUser_phone());
		pstmt.setString(4, user.getUser_email());
		pstmt.setString(5, user.getUser_id());
		
		int rowCount=pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	public int updateAddress(Address address) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.ADDRESS_UPDATE);
		pstmt.setString(1, address.getAddress());
		pstmt.setInt(2, address.getAdd_no());
		
		int rowCount=pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	public int updatePoint(User_info user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_POINT_UPDATE);
		pstmt.setInt(1, user.getUser_point());
		pstmt.setString(2, user.getUser_id());
		int rowCount=pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	
	public int checkId(String userId) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_SELECT_ID_COUNT);
		int check=0;
		pstmt.setString(1, userId);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		check=rs.getInt(1);
		return check;
	}
	
	
	public User_info selectUser(User_info user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_SELECT_BY_ID);
		User_info findUser=null;
		pstmt.setString(1, user.getUser_id());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			//String user_id, String user_password, String user_name, String user_email, String user_phone,
			//int user_point, List<Address> addressList
			findUser=new User_info(rs.getString("user_id"), 
					rs.getString("user_password"), 
					rs.getString("user_name"), 
					rs.getString("user_email"), 
					rs.getString("user_phone"), 
					rs.getInt("user_point"), null);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return findUser;
	}
	
	public List<Address> selectAddress(User_info user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.ADDRESS_SELECT_BY_ID);
		List<Address> addressList=new ArrayList<Address>();
		pstmt.setString(1, user.getUser_id());
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			//int add_no, String address, String user_id
			addressList.add(new Address(rs.getInt("add_no"),rs.getString("address"), rs.getString("user_id")));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return addressList;
	}
	
	public List<User_info> selectAllUser(User_info user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_SELECT_ALL);
		List<User_info> userList=new ArrayList<User_info>();
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			userList.add(new User_info(rs.getString("user_id"), 
					rs.getString("user_password"), 
					rs.getString("user_name"), 
					rs.getString("user_email"), 
					rs.getString("user_phone"), 
					rs.getInt("user_point"), null));
			
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return userList;
	}
	
	public int deleteUser(User_info user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_DELETE);
		pstmt.setString(1, user.getUser_id());
		int rowCount=pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public int deleteAddress(Address address)throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.ADDRESS_DELETE_ONE);
		pstmt.setInt(1, address.getAdd_no());
		int rowCount=pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	
	

}
