package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBHelper.DBHelper;

/**
 * Servlet implementation class LenevoServlet
 */
@WebServlet("/LenevoServlet")
public class LenovoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LenovoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("aaaa");
		response.setContentType("text/html;charset=uft-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        DBHelper dbh=new DBHelper();
        List<String> list=dbh.queryTeacherByName(uname);
        if(null==list||list.size()==0){
        	 List<String> listID=dbh.queryTeacherByID(uname);
        	 if(null==listID||listID.size()==0){
            	 List<String> listDepartment=dbh.queryTeacherByDepartment(uname);
            	 if(null==listDepartment||listDepartment.size()==0){
                	 List<String> listProgramme=dbh.queryTeacherByProgramme(uname);
                	 if(null==listProgramme||listProgramme.size()==0){
                		 List<String> listNull=new ArrayList();
                		 listNull.add("无匹配信息");
                		 HashSet h = new HashSet(listNull);
                         listNull.clear();
                         listNull.addAll(h);
                        
                         request.setAttribute("unames", listNull);
                         request.getRequestDispatcher("divLnsA.jsp").forward(request, response);
                	 }else{
                		 HashSet h = new HashSet(listProgramme);
                         listProgramme.clear();
                         listProgramme.addAll(h);
                        
                         request.setAttribute("unames", listProgramme);
                         request.getRequestDispatcher("divLnsA.jsp").forward(request, response);
                	 }
                }else{
                	 HashSet h = new HashSet(listDepartment);
                     listDepartment.clear();
                     listDepartment.addAll(h);
                    
                     request.setAttribute("unames", listDepartment);
                     request.getRequestDispatcher("divLnsA.jsp").forward(request, response);
                }
            }else{
            	 HashSet h = new HashSet(listID);
                 listID.clear();
                 listID.addAll(h);
                
                 request.setAttribute("unames", listID);
                 request.getRequestDispatcher("divLnsA.jsp").forward(request, response);
            }
        }else{
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
       
        request.setAttribute("unames", list);
        request.getRequestDispatcher("divLnsA.jsp").forward(request, response);
        }
	}

}
