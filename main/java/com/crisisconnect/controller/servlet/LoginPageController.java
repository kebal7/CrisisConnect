package com.crisisconnect.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(loginService.getDbConn() == null) {
			handleError("Couldn't Connect to Database, Please Try Again Later", request, response);
		}
		
		String formUserName = request.getParameter("username");
		String formPassword = request.getParameter("password");
		
		LoginModel loginModel = new LoginModel(formUserName, formPassword);
		
		try {
			int loginResult = loginService.getUserLoginInfo(loginModel);
			
			if(loginResult == -2) {
				handleError("Sorry Internal Error Occured Please Try Again Later", request, response);
			}else if(loginResult == -1) {
				handleError("Invalid Username", request, response);
			}else if(loginResult == 0) {
				handleError("Invalid username or password", request, response);
			}else{
		            // Login successful
				 	String userType = loginService.getUserRole(loginModel);
				 	
		        	HttpSession userSession = request.getSession();
					userSession.setAttribute("username", formUserName);
					userSession.setAttribute("usertype", userType);
					
					userSession.setMaxInactiveInterval(30*60);
					
					Cookie userCookie= new Cookie("username", formUserName);
					userCookie.setMaxAge(30*60);
					response.addCookie(userCookie);
					
					response.sendRedirect(request.getContextPath() + "/home");
			 }
			
		} catch (ClassNotFoundException e) {
			handleError("Sorry Internal Error Occured Please Try Again Later", request, response);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void handleError(String errorMessage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("login_error", errorMessage);
		request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
		return;
	}

}
