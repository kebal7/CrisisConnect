package com.crisisconnect.controller.servlet;

import com.crisisconnect.model.UserModel;
import com.crisisconnect.service.RegistrationService;
import com.crisisconnect.util.PasswordUtil;

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
		request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(registrationService.getDbConn() == null) {
			handleError("Couldn't Connect to Database, Please Try Again Later", request, response);
		}
		
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
        
        int isUniqueUsername = registrationService.isUniqueUsername(userName);
        int isUniqueEmail = registrationService.isUniqueEmail(email);
        int isUniquePhoneNo = registrationService.isUniquePhoneNo(phoneNumber);
        
        if(isUniqueUsername == -1 || isUniqueEmail == -1 || isUniquePhoneNo == -1) {
        	handleError("Sorry Internal Error Occured Please Try Again Later", request, response);
        }else if(isUniqueUsername == 0) {
        	handleError("Sorry Username already taken", request, response);
        }else if(isUniqueEmail == 0) {
        	handleError("Email is already in used by another account", request, response);
        } else if(isUniquePhoneNo == 0){
        	handleError("Phone No. is already in used by another account", request, response);
        }else {
    		// Call RegistrationService to register the student
    		try {
    			user.setPassword(PasswordUtil.encrypt((user.getUsername()), user.getPassword()));
    			int result = registrationService.registerUser(user);
    			
    			if(result == -1) {
    				handleError("Sorry Internal Error Occured Please Try Again Later", request, response);
    			}
    			else if(result == 0) {
    				handleError("Registration Failed", request, response);			
    			}
    			else {
    				request.setAttribute("registration_error", null);
    				response.sendRedirect(request.getContextPath() + "/login");
    			}
    			
    		} catch (ClassNotFoundException e) {
    			handleError("Sorry Internal Error Occured Please Try Again Later", request, response);
    			e.printStackTrace();
    		}
        }
        
	}
	
	private void handleError(String errorMessage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("registration_error", errorMessage);
		request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
		return;
	}

}
