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

	// ��ɾ�� ó��Ŭ������ ���εǾ��ִ� properties ������ �о Map��ü�� commandMap�� ����
	// ��ɾ�� ó��Ŭ������ ���εǾ��ִ� properties ������ Command.properties����
	public void init(ServletConfig config) throws ServletException {

		// web.xml���� �ʱ�ȭ�Ķ���Ͱ��̸��� propertyConfig�� ���� ������
		String props = config.getInitParameter("propertyConfig");
		//��ɾ�� ó��Ŭ������ ���������� ������ properties ��ü ����
		Properties pr = new Properties();
		FileInputStream fis = null;

		
		
		try {
			
			//��θ� �̿��� �� ����(��ü��� �����ϴ� configFilePath)
			app = config.getServletContext();
			String configFilePath = app.getRealPath(props);
			fis = new FileInputStream(configFilePath);
			
			//commandHandlerURI.properties ��ü����
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
		
		//��ü�� �ϳ��������� �� ��ü������ properties��ü�� ����� ��ü�� ����
		while (keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			
			try {
				Class commandClass = Class.forName(className);
				//newInstance() ��ü���� �޼���
				Object commandInstance = commandClass.newInstance();
				
				//Map��ü�� Ű�� ��� ����
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
	
	//����� ��û�� �м��ؼ� �ش� �۾��� ó�� (Action Ŭ������)
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
			
			//�������� ��� ������ 
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
