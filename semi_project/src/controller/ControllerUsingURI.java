package controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class ControllerUsingURI extends HttpServlet {
	
	private Map<String, Object> commandMap=new HashMap<String, Object>();
	
	public void init(ServletConfig config) throws ServletException{
		String props=config.getInitParameter("propertyConfig");
		//web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		
		Properties pr=new Properties();
		//명령어와 클래스의 매핑정보를 저장한 Properties객체 생성
		
		FileInputStream f=null;
		try{
			String configFilePath=config.getServletContext().getRealPath(props);
			f=new FileInputStream(configFilePath);
			pr.load(f);
		}catch(IOException ie){
			throw new ServletException(ie);
		}finally{
			if(f!=null){ 
				try{ f.close();}catch(IOException ie){}
			}
		}
		Iterator<Object> keyIter=pr.keySet().iterator();
		while(keyIter.hasNext()){
			String command=(String)keyIter.next();
			String className=pr.getProperty(command);
			try{
				Class commandClass=Class.forName(className);
				Object commandInstance=commandClass.newInstance();
				commandMap.put(command, commandInstance);
			}catch(ClassNotFoundException e){
				throw new ServletException(e);
			}catch(InstantiationException e){
				throw new ServletException(e);
			}catch(IllegalAccessException e){
				throw new ServletException(e);
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view=null;
	    CommandAction com=null;
		try{
			String command=request.getRequestURI();
			if(command.indexOf(request.getContextPath())==0){
				command=command.substring(request.getContextPath().length());
			}
			com=(CommandAction)commandMap.get(command);
			view=com.requestPro(request, response);
		}catch(Throwable e){
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
