package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_LC_Request;
import com.LMS_Java.model.MD_LC_Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LC_ConUpload")
public class LC_ConUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lcId = request.getParameter("lcId");
		String crId = request.getParameter("crId");
		String bName = request.getParameter("bName");
		String lctTitle = request.getParameter("lctTitle");
		String lctAssig = request.getParameter("lctAssig");
		String lctCaseStudy = request.getParameter("lctCaseStudy");

		String st_Req = "contentUpload";

		MD_LC_Request mdastu = new MD_LC_Request();
		mdastu.setLcId(lcId);
		mdastu.setCrId(crId);
		mdastu.setBname(bName);
		mdastu.setLctTitle(lctTitle);
		mdastu.setLctAssig(lctAssig);
		mdastu.setLctCaseStudy(lctCaseStudy);


		DAO_LC_Request da = new DAO_LC_Request();
		boolean status = da.request_LC(mdastu, st_Req);

		if (status) {
			System.out.println(lcId + " Content Uploaded sucessfully..!");
			response.sendRedirect(request.getContextPath() + "/LC_ViewList");
		} else {
			System.out.println(lcId + " Content Uploaded Failed..!");
			response.sendRedirect(request.getContextPath() + "/LC_ViewList");
		}

	}
}
