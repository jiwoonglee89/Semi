package file.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import DB.FileBean;
import action.*;

public class OrderFileAction implements CommandAction{ //��� ó��

    public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
    	
    	Connection con=new Connection();
    	SqlSession session=con.connection();
    	String pageNum = request.getParameter("pageNum");
        String order=null;
          
        
        if (pageNum == null) {
            pageNum = "1";
        }
       
        int pageSize = 10;//�� �������� ���� ����
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
        int count = 0;
        int number=0;
        
        Map map=new HashMap();
        map.put("start", startRow);
        map.put("end", endRow);
        map.put("order", order);
        
        
        List FileList = null;
        List forcount=null;
        
       
        
        if(count>=0){
        	forcount=session.selectList("co_board.all_file");
        	count = forcount.size();
        }
        if (count > 0) {
            FileList = session.selectList("co_board.getFileInfo", map);
        } else {
            FileList = Collections.EMPTY_LIST;
        }     
        if(request.getParameter("order")!=null){
        	order=request.getParameter("order");
        	count=session.selectOne("co_board.OrderCount", map);
        	FileList=session.selectList("co_board.OrderList", map);
        	request.setAttribute("order", new String(order));
            
        }
        
        if(order.equals("0")){
        	order=request.getParameter("order");
        	count=session.selectOne("co_board.Date_OrderCount", map);
        	FileList=session.selectList("co_board.Date_OrderList", map);
        	request.setAttribute("order", new String(order));
        }
        if(order.equals("1")){
        	order=request.getParameter("order");
        	count=session.selectOne("co_board.Read_OrderCount", map);
        	FileList=session.selectList("co_board.Read_OrderList", map);
        	request.setAttribute("order", new String(order));
        }
        
       
       // �� ī���ڸ� �� ��µǴ� ���ϼ��� ���¶� �ٸ��� �ϱ� ����
        
        number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
        
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("FileList", FileList);
       
        return "co_main.jsp";//�ش� ��
    }
}