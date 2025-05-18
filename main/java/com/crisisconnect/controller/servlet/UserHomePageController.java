package com.crisisconnect.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.crisisconnect.model.DisasterModel;
import com.crisisconnect.service.DisasterService;

/**
 * Servlet implementation class UserHomePageController
 */
@WebServlet("/userhome")
public class UserHomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final DisasterService disasterService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHomePageController() {
        super();
        this.disasterService = new DisasterService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the list of DisasterModel objects
        List<DisasterModel> disasterList = disasterService.getAllDisasters();

        // Set the disaster list as an attribute in the request
        request.setAttribute("disasters", disasterList);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/WEB-INF/pages/userhome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
