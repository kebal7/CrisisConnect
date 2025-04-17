package com.crisisconnect.controller.servlet;

import com.crisisconnect.model.UserModel;
import com.crisisconnect.service.RegistrationService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegisterPageController
 */
@WebServlet("/register")
public class RegisterPageController extends HttpServlet {
	
	private final RegistrationService registrationService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPageController() {
        super();
        this.registrationService = new RegistrationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String userType = request.getParameter("usertype");
		String imagePath = "null";
        
        UserModel user = new UserModel(userName, fullName, userType, password, email, phoneNumber, dob, address, imagePath);
        
		// Call RegistrationService to register the student
		try {
			int result = registrationService.registerUser(user);
			
			if(result == 0) {
				System.out.print("Registration Failed");			
			}else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
