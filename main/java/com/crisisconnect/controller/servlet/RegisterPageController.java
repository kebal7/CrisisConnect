package com.crisisconnect.controller.servlet;

import com.crisisconnect.model.UserModel;
import com.crisisconnect.service.RegistrationService;
import com.crisisconnect.util.PasswordUtil;
import com.crisisconnect.util.ValidationUtil;

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
			return;
		}
		
		String userName = request.getParameter("username");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String phoneNumber = request.getParameter("phoneNumber");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String userType = request.getParameter("usertype");
		userType = "user";
		String imagePath = "null";
        
		// 🛡️ FIELD VALIDATIONS
		if (userName == null || !ValidationUtil.isAlphanumeric(userName)) {
			handleError("Username must be alphanumeric and cannot be empty.", request, response);
			return;
		}

		if (fullName == null || !ValidationUtil.isTextOnly(fullName)) {
			handleError("Full Name must contain only letters and spaces.", request, response);
			return;
		}

		if (email == null || !ValidationUtil.isEmail(email)) {
			handleError("Please enter a valid email address.", request, response);
			return;
		}
		
		if(password == null || confirmPassword == null) {
			handleError("Please enter valid password", request, response);
			return;
		}
		
		if (!ValidationUtil.doPasswordsMatch(password, confirmPassword)) {
			handleError("Passwords do not match.", request, response);
			return;
		}
		
		if (password == null || !ValidationUtil.isValidPassword(password)) {
			handleError("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.", request, response);
			return;
		}
		
		
		if (phoneNumber == null || !ValidationUtil.isValidPhoneNumber(phoneNumber)) {
			handleError("Phone number must start with 97 or 98 and be 10 digits long.", request, response);
			return;
		}

		if (dob == null || dob.trim().isEmpty()) {
			handleError("Date of Birth cannot be empty.", request, response);
			return;
		}

		if (address == null || address.trim().isEmpty() || !ValidationUtil.hasNoSpecialCharacters(address)) {
			handleError("Address cannot be empty and must not contain special characters.", request, response);
			return;
		}

		if (userType == null || (!userType.equalsIgnoreCase("admin") && !userType.equalsIgnoreCase("user"))) {
			handleError("Invalid user type selected.", request, response);
			return;
		}
		
        UserModel user = new UserModel(userName, fullName, userType, password, email, phoneNumber, dob, address, imagePath);
        
        int isUniqueUsername = registrationService.isUniqueUsername(userName);
        int isUniqueEmail = registrationService.isUniqueEmail(email);
        int isUniquePhoneNo = registrationService.isUniquePhoneNo(phoneNumber);
        
        if(isUniqueUsername == -1 || isUniqueEmail == -1 || isUniquePhoneNo == -1) {
        	handleError("Sorry Internal Error Occured Please Try Again Later", request, response);
        	return;
        }else if(isUniqueUsername == 0) {
        	handleError("Sorry Username already taken", request, response);
        	return;
        }else if(isUniqueEmail == 0) {
        	handleError("Email is already in used by another account", request, response);
        	return;
        } else if(isUniquePhoneNo == 0){
        	handleError("Phone No. is already in used by another account", request, response);
        	return;
        }else {
    		// Call RegistrationService to register the student
    		try {
    			user.setPassword(PasswordUtil.encrypt((user.getUsername()), user.getPassword()));
    			int result = registrationService.registerUser(user);
    			
    			if(result == -1) {
    				handleError("Sorry Internal Error Occured Please Try Again Later", request, response);
    				return;
    			}
    			else if(result == 0) {
    				handleError("Registration Failed Due to Unexpected Internal Error", request, response);		
    				return;
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
		
	    // Store form fields to repopulate form
	    request.setAttribute("username_val", request.getParameter("username"));
	    request.setAttribute("fullname_val", request.getParameter("fullName"));
	    request.setAttribute("email_val", request.getParameter("email"));
	    request.setAttribute("password_val", request.getParameter("password"));
	    request.setAttribute("confirm_password_val", request.getParameter("confirmPassword"));
	    request.setAttribute("phone_val", request.getParameter("phoneNumber"));
	    request.setAttribute("dob_val", request.getParameter("dob"));
	    request.setAttribute("address_val", request.getParameter("address"));
	    request.setAttribute("usertype_val", request.getParameter("usertype"));
		
		request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		return;
	}

}
