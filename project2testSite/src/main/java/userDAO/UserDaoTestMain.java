package userDAO;

import userDTO.Address;
import userDTO.User_info;

public class UserDaoTestMain {
	public static void main(String[] args) throws Exception {
		UserDAO userDao=new UserDAO();
		String id="insert";
		System.out.println("회원 가입");
		//System.out.println(userDao.createUser(new User_info("insert", "insert", "인서트", "insert@email.com", "2223333", 1000, null)));
		System.out.println("주소록 추가");
		System.out.println(userDao.createAddress(new Address(0, "새로운 주소2","insert")));
		System.out.println("회원정보수정");
		System.out.println(userDao.updateUser(new User_info("insert", "update", "업데이트", "updatetest", "99999", 0, null)));
		System.out.println("주소 1개 수정");
		System.out.println(userDao.updateAddress(new Address(3, "변경되는 주소", null)));
		
		System.out.println("포인트 10000원 증가");
		//System.out.println(userDao.updatePoint(new User_info(id, null, null, null, null, 10000, null)));
		
		System.out.println("포인트 5000원 감소");
		//System.out.println(userDao.updatePoint(new User_info(id, null, null, null, null, -5000, null)));
	
		System.out.println("회원 검색");
		System.out.println(userDao.selectUser(new User_info(id, null, null, null, null, 0, null)));
		
		System.out.println("회원의 주소록 검색");
		System.out.println(userDao.selectAddress(new User_info(id, null, null, null, null, 0, null)));
	
		System.out.println("아이디 존재여부");
		System.out.println(userDao.checkId(id));
		
		System.out.println("주소록 1개 삭제");
		System.out.println(userDao.deleteAddress(new Address(7, null, null)));
		
		System.out.println("회원탈퇴");
		System.out.println(userDao.deleteUser(new User_info(id, null, null, null, null, 0, null)));
	}

}
