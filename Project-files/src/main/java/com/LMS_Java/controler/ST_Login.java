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

@WebServlet("/ST_Login")
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
        
//        System.out.println(stId);
//        System.out.println(stName);
//        System.out.println(stPsw);
//        System.out.println(stCpsw);
//        System.out.println(crId);
//        System.out.println(bName);
//        System.out.println(stType);
        
        MD_ST_Request mdstr =new MD_ST_Request();
        mdstr.setStId(stId);
        mdstr.setStName(stName);
        mdstr.setStPsw(stPsw);
        mdstr.setStCpsw(stCpsw);
        mdstr.setCrId(crId);
        mdstr.setBname(bName);
        mdstr.setStType(stType);
        
        String st_Req=stType+"Login";
        
        DAO_ST_Request da = new DAO_ST_Request();
        boolean status = da.request_ST(mdstr, st_Req);
        
        if(status) {
            HttpSession session = request.getSession();
            session.setAttribute("stId", stId);
            session.setAttribute("stName", stName);
            session.setAttribute("bName", bName);
            session.setAttribute("crId", crId);
            session.setAttribute("stType", stType);

         // Redirect to view controller
         response.sendRedirect(request.getContextPath() + "/ST_ViewList");
        	
        	        
        } else {

            RequestDispatcher rd = request.getRequestDispatcher("/st_Login.html");
            rd.forward(request, response);
        }

        
        
    }
}
