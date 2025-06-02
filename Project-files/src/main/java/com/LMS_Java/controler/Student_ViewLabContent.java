package com.LMS_Java.controler;

import java.io.IOException;
import java.util.List;

import com.LMS_Java.dao.DAO_ST_Request;
import com.LMS_Java.model.MD_ST_Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Student_ViewLabContent")
public class Student_ViewLabContent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String lcId = request.getParameter("lcId");
        String crId = request.getParameter("crId");
        String bName = request.getParameter("bName");
        
        
        MD_ST_Request mdstr =new MD_ST_Request();
        mdstr.setStId(lcId);
        mdstr.setCrId(crId);
        mdstr.setBname(bName);
        
        String st_req =(lcId+"/"+bName+"/"+crId);
        
        DAO_ST_Request da = new DAO_ST_Request();
        List<MD_ST_Request> labCordUploadedContent = da.retrive_ST("labCordUploadedContent",st_req);
              
        HttpSession session = request.getSession(false);
        session.setAttribute("labCordUploadedContent", labCordUploadedContent);
        
     // Redirect to view controller
        response.sendRedirect(request.getContextPath() + "/ST_ViewList");
        
    }
}
