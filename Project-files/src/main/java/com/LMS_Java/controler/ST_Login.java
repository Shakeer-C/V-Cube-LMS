package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_ST_Request;
import com.LMS_Java.model.MD_ST_Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HTML_JSP/ST_Login")
public class ST_Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String stId = request.getParameter("stId");
        String stName = request.getParameter("stName");
        String stPsw = request.getParameter("stPsw");
        String stCpsw = request.getParameter("stCpsw");
        String crId = request.getParameter("crId");
        String bName = request.getParameter("bName");
        String stType = request.getParameter("stType");
        
        MD_ST_Request mdstr =new MD_ST_Request();
        mdstr.setStId(stId);
        mdstr.setStName(stName);
        mdstr.setStPsw(stPsw);
        mdstr.setStCpsw(stCpsw);
        mdstr.setCrId(crId);
        mdstr.setBname(bName);
        mdstr.setStType(stType);
        
        String ad_Req=stType+"Login";
        
        DAO_ST_Request da = new DAO_ST_Request();
        boolean status = da.request_Admin(mdstr, ad_Req);
        
        if(status) {
        	if ("student".equals(stType)) {
        		HttpSession session = request.getSession();
        		session.setAttribute("studentId", stId);
    		    session.setAttribute("studentName", stName);
    		    session.setAttribute("studentBatch", bName);
    		    RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/STUDENT/student_View.jsp");
    		    rd.forward(request, response);
        	} else if ("teacher".equals(stType)) {
        		HttpSession session = request.getSession();
        		session.setAttribute("teacherId", stId);
    		    session.setAttribute("teacherName", stName);
    		    RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/TEACHER/teacher_View.jsp");
    		    rd.forward(request, response);
        	}else {
        		
        	}

        	
        }else {
        	
        }
        
        
    }
}
