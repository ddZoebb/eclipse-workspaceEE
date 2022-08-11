package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception{
		GuestDao guestDao=new GuestDao();
		System.out.println("insert");
		System.out.println(guestDao.insertGuest(new Guest(0,"이름",null ,"guard@naver.com","http://www.naver.com","타이틀","콘텐츠")));
		System.out.println("update");
		System.out.println(guestDao.updateGuest(new Guest(3, "변경이름", null, "update@na.com", "http://update", "타이틀", "업데이트")));
		System.out.println("delete");
		System.out.println(guestDao.deleteGuest(2));
		
		System.out.println("select");
		System.out.println(guestDao.selectByNo(3));
		
		System.out.println("selectAll");
		System.out.println(guestDao.selectAll());
	}

}
