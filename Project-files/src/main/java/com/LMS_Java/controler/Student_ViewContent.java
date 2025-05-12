package com.LMS_Java.controler;

import java.io.IOException;
import java.util.List;

import com.LMS_Java.dao.DAO_ST_Request;
import com.LMS_Java.model.MD_ST_Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/HTML_JSP/STUDENT/Student_ViewContent")
public class Student_ViewContent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String stId = request.getParameter("stId");
        String crId = request.getParameter("crId");
        String bName = request.getParameter("bName");
        
        System.out.println(stId);
        System.out.println(crId);
        System.out.println(bName);

        
        MD_ST_Request mdstr =new MD_ST_Request();
        mdstr.setStId(stId);
        mdstr.setCrId(crId);
        mdstr.setBname(bName);
        
        String st_req =(stId+"/"+bName+"/"+crId);
        
        DAO_ST_Request da = new DAO_ST_Request();
        List<MD_ST_Request> currentStudentDetails = da.retrive_ST("currentStudentDetails",stId);
        List<MD_ST_Request> teacherList = da.retrive_ST("teacherList",crId);
        List<MD_ST_Request> teacherUploadedContent = da.retrive_ST("teacherUploadedContent",st_req);
        List<MD_ST_Request> currentStDetails = da.retrive_ST("contentList",stId);	    
	    
        request.setAttribute("currentStudentDetails", currentStudentDetails); 
        request.setAttribute("teacherList", teacherList);
        request.setAttribute("currentStDetails", currentStDetails);
        request.setAttribute("teacherUploadedContent", teacherUploadedContent);
        
        RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/STUDENT/student_View.jsp");
	    rd.forward(request, response);
        
    }
}
