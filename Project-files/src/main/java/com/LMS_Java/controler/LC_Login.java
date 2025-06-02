package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_LC_Request;
import com.LMS_Java.model.MD_LC_Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LC_Login")
public class LC_Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String lcId = request.getParameter("lcId");
        String lcName = request.getParameter("lcName");
        String lcPsw = request.getParameter("lcPsw");
        String lcCpsw = request.getParameter("lcCpsw");
        String crId = request.getParameter("crId");
        
//        System.out.println(lcId);
//        System.out.println(lcName);
//        System.out.println(lcPsw);
//        System.out.println(lcCpsw);
//        System.out.println(crId);
        
        
        MD_LC_Request mdlcr =new MD_LC_Request();
        mdlcr.setLcId(lcId);
        mdlcr.setLcName(lcName);
        mdlcr.setLcPsw(lcPsw);
        mdlcr.setLcCpsw(lcCpsw);
        mdlcr.setCrId(crId);
       
        
        String st_Req="labCord"+"Login";
        
        DAO_LC_Request da = new DAO_LC_Request();
        boolean status = da.request_LC(mdlcr, st_Req);
        
        if(status) {
            HttpSession session = request.getSession();
            session.setAttribute("lcId", lcId);
            session.setAttribute("lcName", lcName);
            session.setAttribute("crId", crId);

         // Redirect to view controller
         response.sendRedirect(request.getContextPath() + "/LC_ViewList");
         
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/labCord_Login.html");
            rd.forward(request, response);
        }

        
        
    }
}
