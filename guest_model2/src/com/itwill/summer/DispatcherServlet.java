package com.itwill.summer;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itwill.guest.GuestService;
import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;
/*
 * 1. 클라이언트(웹브라우져)의 모든요청을 받는 서블릿작성(front Controller)
 * 2. 확장자가 *.do인 모든클라이언트의 요청이 서블릿을 실행하도록 web.xml에 url pattern mapping
   << web.xml >>
    <servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>com.itwill.summer.DispatcherServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
 */
public class DispatcherServlet extends HttpServlet {
	/*
	 * Controller 객체를 저장할 맵
	 */
	private HashMap<String, Controller> handlerMapping;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		handlerMapping=new HashMap<String, Controller>();
		
		/*
		<<web.xml에설정된 파일이름 파라메타값 가져오기>>
		<servlet>
			<servlet-name>dispatcher</servlet-name>
			<servlet-class>com.itwill.summer.DispatcherServlet</servlet-class>
			<init-param>
				<param-name>configFile</param-name>
				<param-value>/WEB-INF/guest_controller_mapping.properties</param-value>
			</init-param>
			....
		</servlet>	
		 */
		
		
		//설정파일
		String configFile=config.getInitParameter("configFile");
		String siteRootRealPath=this.getServletContext().getRealPath("/");
		String configFileRealPath=siteRootRealPath+configFile;
		try {
			/*
			설정파일(guest_controller_mapping.properties)을 읽어서 Properties객체생성
			 */
			FileInputStream fis=new FileInputStream(configFileRealPath);
			Properties controllerMappingProperties=new Properties();
			controllerMappingProperties.load(fis);
			/*
			 <<Properties객체>>
			 --------------------------------------------
			 |key(String)      |      value(String)     |
			 --------------------------------------------
			 |/guest_main.do   |com..GuestMainController|	
			  -------------------------------------------
			 |/guest_list.do   |com..GuestListController|		
			  -------------------------------------------
			 |/guest_view.do   |com..GuestViewController|		
			 --------------------------------------------	
			*/
			Set commandKeySet=controllerMappingProperties.keySet();
			Iterator commandKeyIterator=commandKeySet.iterator();
			System.out.println("-------------설정파일["+configFile+"]을 이용해 handlerMapping 객체 생성---------");
			while(commandKeyIterator.hasNext()) {
				String commandKey=(String)commandKeyIterator.next();
				String controllerClassName=controllerMappingProperties.getProperty(commandKey);
				/*
				 * Controller클래스이름을 사용해 Controller객체 생성 
				 * 1. controller 클래스이름을 사용해 class를 메모리 로딩
				 * 2. 메모리에 로딩된 클래스의 객체 생성 
				 */
				Class controllerClass=Class.forName(controllerClassName);
				Controller controllerObject=(Controller)controllerClass.newInstance();
				handlerMapping.put(commandKey, controllerObject);
			}
			System.out.println(handlerMapping);
			System.out.println("---------------------------------------------------------31");
			
			
			/*
			 << HashMap<String, Controller> handlerMapping>>
			 ------------------------------------------------
			 |key(String)      |      value(Controller객체) |
			 ------------------------------------------------
			 |/guest_main.do   |com..GuestMainController객체|	
			  -----------------------------------------------
			 |/guest_list.do   |com..GuestListController객체|		
			  -----------------------------------------------
			 |/guest_view.do   |com..GuestViewController객체|		
			 ------------------------------------------------
			 */
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * handlerMapping.put("/guest_list.do", new GuestListController());
		 * handlerMapping.put("/guest_error.do", new GuestErrorController());
		 * handlerMapping.put("/guest_main.do", new GuestMainController());
		 * handlerMapping.put("/guest_view.do", new GuestViewController());
		 * handlerMapping.put("/guest_write_form.do", new GuestWriteFormController());
		 * handlerMapping.put("/guest_write_action.do", new
		 * GuestWriteActionController()); handlerMapping.put("/guest_modify_form.do",
		 * new GuestModifyFormController());
		 * handlerMapping.put("/guest_modify_action.do", new
		 * GuestModifyActionController()); handlerMapping.put("/guest_remove_action.do",
		 * new GuestRemoveActionController());
		 */
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		/*****************************
		<<클라이언트 요청 url(command)>>
		/guest_main.do  		
		/guest_list.do			
		/guest_view.do			
		/guest_write_form.do	
		/guest_write_action.do	
		/guest_modify_form.do	
		/guest_modify_action.do	
		/guest_remove_action.do	
		 ***************************/
		/*
		 * 1.DispatcherServlet이 클라이언트 요청URI를 사용해서 요청분석
		 */
		String requestURI = request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		/*
		 * 2-1.DispatcherServlet이 클라이언트 요청에따른 업무실행할 Controller객체생성
		 */
		Controller controller=handlerMapping.get(command);
		
		
		/*
		  2-2.DispatcherServlet이 Controller객체의 handlerRequest메쏘드호출(비지니스실행)
		  2-3.DispatcherServlet이 Controller객체의 handlerRequest메쏘드반환값인 forwardPath를 받는다.
		 */
		String forwardPath=controller.handleRequest(request, response);
		/*
		 * 3.DispatcherServlet이 forwardPath데이타를가지고 forward 혹은 redirect를한다
		 */
		/********************forward,redirect**************/
		/*
			forward --> forward:/WEB-INF/views/guest_xxx.jsp
			redirect--> redirect:guest_xxx.do
		 */
		String[] pathArray=forwardPath.split(":");
		/*
		  << pathArray >>
		  |----0---|-----------------1------------|
		  |forward |/WEB-INF/views/guest_main.jsp |
		  |--------|------------------------------|
		  
		  |----0---|-------1-----|
		  |redirect|guest_main.do|
		  |--------|-------------|
		 */
		
		String forwardOrRedirect = pathArray[0];
		String path=pathArray[1];
		if(forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		}else if(forwardOrRedirect.equals("forward")){	
			RequestDispatcher rd=
					request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		/*************************************************/
	}
}