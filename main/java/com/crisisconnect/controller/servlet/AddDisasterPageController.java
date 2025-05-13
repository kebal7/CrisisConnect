package com.crisisconnect.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import com.crisisconnect.model.DisasterModel;
import com.crisisconnect.service.DisasterService;
import com.crisisconnect.service.RegistrationService;

/**
 * Servlet implementation class AdminPanelController
 */
@WebServlet("/admin/adddisaster")
public class AddDisasterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final DisasterService disasterService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDisasterPageController() {
        super();
        this.disasterService = new DisasterService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/addDisaster.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession();
		String sessionUser = (String) userSession.getAttribute("username");
		
		String disasterIdStr = "1";
		String disasterTitle = request.getParameter("disasterTitle");
		String disasterType = request.getParameter("disasterType");
		String municipalityOrVdc = request.getParameter("municipalityOrVdc");
		String wardStr = request.getParameter("ward");
		String longitudeLatitude = request.getParameter("longitudeLatitude");
		String dateOfIncidentStr = request.getParameter("dateOfIncident");
		String reportedBy = sessionUser;
		String assignedCoordinator = request.getParameter("assignedCoordinator");
		String noOfInjuriesStr = request.getParameter("noOfInjuries");
		String noOfDeathStr = request.getParameter("noOfDeath");
		String noOfMissingStr = request.getParameter("noOfMissing");
		String estimatedLossStr = request.getParameter("estimatedLoss");
		String otherNotes = request.getParameter("otherNotes");
		
		// parse to appropriate data types
		int disasterId = Integer.parseInt(disasterIdStr);
		int ward = Integer.parseInt(wardStr);
		LocalDate dateOfIncident = LocalDate.parse(dateOfIncidentStr);
		int noOfInjuries = Integer.parseInt(noOfInjuriesStr);
		int noOfDeath = Integer.parseInt(noOfDeathStr);
		int noOfMissing = Integer.parseInt(noOfMissingStr);
		double estimatedLoss = Double.parseDouble(estimatedLossStr);
		
		DisasterModel formDisaster = new DisasterModel(
			    disasterId,
			    disasterTitle,
			    disasterType,
			    municipalityOrVdc,
			    ward,
			    longitudeLatitude,
			    dateOfIncident,
			    reportedBy,
			    assignedCoordinator,
			    noOfInjuries,
			    noOfDeath,
			    noOfMissing,
			    estimatedLoss,
			    otherNotes
			);
		
		disasterService.addDisaster(formDisaster);
 
		doGet(request, response);
	}

}
