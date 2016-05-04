package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import admin_action.*;


public class Controller extends HttpServlet {
	static ServletContext app;
	private Map commandMap = new HashMap();

	// 명령어와 처리클래스가 매핑되어있는 properties 파일을 읽어서 Map객체인 commandMap에 저장
	// 명령어와 처리클래스가 매핑되어있는 properties 파일은 Command.properties파일
	public void init(ServletConfig config) throws ServletException {

		// web.xml에서 초기화파라미터값이름이 propertyConfig인 값을 가져옴
		String props = config.getInitParameter("propertyConfig");
		//명령어와 처리클래스의 매핑정보를 저장할 properties 객체 생성
		Properties pr = new Properties();
		FileInputStream fis = null;

		
		
		try {
			
			//경로를 이용해 모델 선택(전체경로 설정하는 configFilePath)
			app = config.getServletContext();
			String configFilePath = app.getRealPath(props);
			fis = new FileInputStream(configFilePath);
			
			//commandHandlerURI.properties 객체생성
			pr.load(fis);
			//System.out.println(pr);
			
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
		
		Iterator keyIter = pr.keySet().iterator();
		
		//객체를 하나씩꺼내서 그 객체명으로 properties객체에 저장된 객체에 접근
		while (keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			
			try {
				Class commandClass = Class.forName(className);
				//newInstance() 객체생성 메서드
				Object commandInstance = commandClass.newInstance();
				
				//Map객체에 키와 밸류 저장
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
                throw new ServletException(e);
            } catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
		}
		
	}
	
	//사용자 요청을 분석해서 해당 작업을 처리 (Action 클래스로)
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		request.setAttribute("app", app);
		
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI();
			if (command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandAction)commandMap.get(command);
			
			//뷰페이지 경로 가져옴 
			view = com.requestPro(request,response);
		} catch (Throwable e) {
			// TODO: handle exception 
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		requestPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

}
