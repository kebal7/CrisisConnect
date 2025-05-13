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
 * Servlet implementation class ManageDisasterRecordController
 */
@WebServlet("/admin/managedisasterrecord")
public class ManageDisasterRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final DisasterService disasterService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageDisasterRecordController() {
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
        request.getRequestDispatcher("/WEB-INF/pages/managedisastersrecord.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int disasterId = Integer.parseInt(request.getParameter("id"));
		
		if(action.equals("delete")) {
			int result = disasterService.deleteDisasterRecord(disasterId);
			doGet(request, response);
		}else if(action.equals("edit")) {
			 response.sendRedirect(request.getContextPath() + "/updatedisaster?id=" + disasterId);
		}
	}

}
