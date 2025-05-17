package com.crisisconnect.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.crisisconnect.model.UserModel;
import com.crisisconnect.service.ProfileUpdateService;
import com.crisisconnect.service.RegistrationService;
import com.crisisconnect.service.UserInfoService;
import com.crisisconnect.util.PasswordUtil;
import com.crisisconnect.util.ValidationUtil;

/**
 * Servlet implementation class ProfilePageController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/profile" })
public class ProfilePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final ProfileUpdateService profileUpdateService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePageController() {
        super();
        this.profileUpdateService = new ProfileUpdateService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession userSession = request.getSession();
		String sessionUsername = (String) userSession.getAttribute("username");
		
		UserInfoService userInfoService = new UserInfoService();
		
		try {
			int result = userInfoService.getUserInfo(sessionUsername);
			
			if(result == 1) {
				UserModel sessionUser = userInfoService.getSessionUserMode();
				
				if(sessionUser != null) {
					request.setAttribute("username", sessionUser.getUsername());
					request.setAttribute("fullName", sessionUser.getFullName());
					request.setAttribute("usertype", sessionUser.getUserType());
					request.setAttribute("email", sessionUser.getEmail());
					request.setAttribute("password", PasswordUtil.decrypt(sessionUser.getPassword(), sessionUsername));
					request.setAttribute("phoneNumber", sessionUser.getPhoneNumber());
					request.setAttribute("dateOfBirth", sessionUser.getDateOfBirth());
					request.setAttribute("address", sessionUser.getAddress());
					request.setAttribute("imagePath", sessionUser.getImagePath());
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession userSession = request.getSession();
		String sessionUsername = (String) userSession.getAttribute("username");
		String userType = (String) userSession.getAttribute("usertype");

		String userName = sessionUsername;
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String imagePath = "null";
		
		// 🛡️ FIELD VALIDATIONS
		if (fullName == null || !ValidationUtil.isTextOnly(fullName)) {
			handleError("Full Name must contain only letters and spaces.", request, response);
			return;
		}

		if (email == null || !ValidationUtil.isEmail(email)) {
			handleError("Please enter a valid email address.", request, response);
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
		
		
		UserModel user = new UserModel(userName, fullName, userType, password, email, phoneNumber, dob, address, imagePath);
		
		user.setPassword(PasswordUtil.encrypt((user.getUsername()), user.getPassword()));
		
		try {
			int result = profileUpdateService.updateUser(user, sessionUsername);
			
			if(result == 1) {
				response.sendRedirect(request.getContextPath() + "/profile");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void handleError(String errorMessage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("profile_update_error", errorMessage);
		doGet(request, response);
		return;
	}

}
