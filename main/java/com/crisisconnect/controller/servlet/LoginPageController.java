package com.crisisconnect.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.crisisconnect.model.LoginModel;
import com.crisisconnect.service.LoginService;
import com.crisisconnect.service.RegistrationService;

/**
 * Servlet implementation class LoginPageController
 */
@WebServlet("/login")
public class LoginPageController extends HttpServlet {
	
	private final LoginService loginService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageController() {
        super();
        this.loginService = new LoginService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formUserName = request.getParameter("username");
		String formPassword = request.getParameter("password");
		
		LoginModel loginModel = new LoginModel(formUserName, formPassword);
		
		try {
			int loginResult = loginService.getUserLoginInfo(loginModel);
			
			 if (loginResult == 1) {
		            // Login successful
				 	String userType = loginService.getUserRole(loginModel);
				 	
		        	HttpSession userSession = request.getSession();
					userSession.setAttribute("username", formUserName);
					userSession.setAttribute("usertype", userType);
					
					userSession.setMaxInactiveInterval(30*60);
					
					System.out.println(request.getSession().getAttribute("username"));
					System.out.println(request.getSession().getAttribute("usertype"));
					
					response.sendRedirect(request.getContextPath() + "/home");
			 }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
