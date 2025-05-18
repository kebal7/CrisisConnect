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
 * Servlet implementation class ViewPageController
 */
@WebServlet("/view")
public class ViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final DisasterService disasterService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPageController() {
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
        request.getRequestDispatcher("/WEB-INF/pages/view.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    String searchQuery = request.getParameter("searchQuery");
	    
	    String sortBy = request.getParameter("sortBy");
	    String sortType = request.getParameter("sortType");
		
	    // If Search button was clicked
	    if ("search".equals(action)) {
	    	if(searchQuery == null || searchQuery.trim().isEmpty()) {
	    		doGet(request, response);
	    		return;
	    	}
	    	
	        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
	            String trimmedLowerQuery = searchQuery.toLowerCase().trim();
	            
	            List<DisasterModel> disasterList = disasterService.getDisasterByName(trimmedLowerQuery);
	            
	            // Set the disaster list according to search as an attribute in the request
	            request.setAttribute("disasters", disasterList);

	            // Forward the request to the JSP page
	            request.getRequestDispatcher("/WEB-INF/pages/view.jsp").forward(request, response);
	        }
	    }
	    
	    if ("sort".equals(action)) {	    	
	        if (sortBy == null || sortBy.trim().isEmpty()) {
	            sortBy = "disasterId";
	        }
	        if (sortType == null || sortType.trim().isEmpty()) {
	            sortType = "ascending";
	        }

	        String trimmedLowerSortBy = sortBy.toLowerCase().trim().replaceAll("\\s+", "");
	        String trimmedLowerSortType = sortType.toLowerCase().trim().replaceAll("\\s+", "");
	        
	        List<DisasterModel> disasterList = disasterService.getSortedList(trimmedLowerSortBy, trimmedLowerSortType);
	        
            // Set the sorted disaster list an attribute in the request
            request.setAttribute("disasters", disasterList);

            // Forward the request to the JSP page
            request.getRequestDispatcher("/WEB-INF/pages/view.jsp").forward(request, response);
	    }
	}

}
