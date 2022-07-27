package com.itwill.user;
/*
 * - 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴포넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
public class UserService {
	private UserDao userDao;
	public UserService() throws Exception {
		userDao=new UserDao();
	}
	/*
	 * 회원가입
	 */
	public int create(User user) throws Exception{
		/*
		 * -1: 아이디중복
		 * 1: 회원가입성공
		 */
		//1. 아이디중복체크
		if(userDao.existedUser(user.getUserId())) {
			//아이디중복 o
			return -1;
		}else {
			//아이디중복 x 
			//2.회원가입 
			int insertRowCount=userDao.create(user);
			return insertRowCount;
		}
	
	}
	
	public int login(String userid,String password) throws Exception{
		int result=-1;
		//1.아이디존재여부 
		
		User user=userDao.findUser(userid);
		if(user==null) {
			//아이디존재안함
			result=0;
		}else {
			//아이디존재함
			if(user.isMatchPassword(password)) {
				//패스워드까지 일치
				result=2;
			}else {
				//패스워드 불일치 
				result=1;
			}
		}
		return result;
	}
	
	public User findUser(String userid) throws Exception{
		return userDao.findUser(userid);
	}
	
	public int update(User user)throws Exception{
		return userDao.update(user);
	}
	
	public int remove(String userId)throws Exception{
		return userDao.remove(userId);
	}
	

}
