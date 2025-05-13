package com.crisisconnect.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.crisisconnect.model.DisasterModel;
import com.crisisconnect.service.DisasterService;
import com.crisisconnect.service.ProfileUpdateService;

/**
 * Servlet implementation class UpdateDisasterPageController
 */
@WebServlet("/updatedisaster")
public class UpdateDisasterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final DisasterService disasterService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDisasterPageController() {
        super();
        this.disasterService = new DisasterService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		
	    if (idParam != null) {
	        try {
	            int disasterId = Integer.parseInt(idParam);
	            
	            DisasterModel disaster = disasterService.getDisaster(disasterId);
	            
	            request.setAttribute("disasterId", disaster.getDisasterId());
	            request.setAttribute("disasterTitle", disaster.getDisasterTitle());
	            request.setAttribute("disasterType", disaster.getDisasterType());
	            request.setAttribute("municipalityOrVdc", disaster.getMunicipalityOrVdc());
	            request.setAttribute("ward", disaster.getWard());
	            request.setAttribute("longitudeLatitude", disaster.getLongitudeLatitude());
	            request.setAttribute("dateOfIncident", disaster.getDateOfIncident());
	            request.setAttribute("reportedBy", disaster.getReportedBy());
	            request.setAttribute("assignedCoordinator", disaster.getAssignedCoordinator());
	            request.setAttribute("noOfInjuries", disaster.getNoOfInjuries());
	            request.setAttribute("noOfDeath", disaster.getNoOfDeath());
	            request.setAttribute("noOfMissing", disaster.getNoOfMissing());
	            request.setAttribute("estimatedLoss", disaster.getEstimatedLoss());
	            request.setAttribute("otherNotes", disaster.getOtherNotes());

	            request.getRequestDispatcher("/WEB-INF/pages/updateDisaster.jsp").forward(request, response);

	        } catch (NumberFormatException e) {
	        	//show error
	        }
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
