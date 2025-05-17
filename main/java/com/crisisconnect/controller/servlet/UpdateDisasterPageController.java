package com.crisisconnect.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import com.crisisconnect.model.DisasterModel;
import com.crisisconnect.service.DisasterService;
import com.crisisconnect.service.ProfileUpdateService;
import com.crisisconnect.util.ValidationUtil;

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
	        	handleError("Invalid Disaster Id", request, response);
	        	return;
	        } catch (Exception e) {
	        	handleError("Failed to load disaster", request, response);
	        	return;
	        }
	    }else {
        	handleError("Invalid Disaster Id", request, response);
        	return;
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String disasterIdStr = request.getParameter("disasterId");
		String disasterTitle = request.getParameter("disasterTitle");
		String disasterType = request.getParameter("disasterType");
		String municipalityOrVdc = request.getParameter("municipalityOrVdc");
		String wardStr = request.getParameter("ward");
		String longitudeLatitude = request.getParameter("longitudeLatitude");
		String dateOfIncidentStr = request.getParameter("dateOfIncident");
		String reportedBy = request.getParameter("reportedBy");
		String assignedCoordinator = request.getParameter("assignedCoordinator");
		String noOfInjuriesStr = request.getParameter("noOfInjuries");
		String noOfDeathStr = request.getParameter("noOfDeath");
		String noOfMissingStr = request.getParameter("noOfMissing");
		String estimatedLossStr = request.getParameter("estimatedLoss");
		String otherNotes = request.getParameter("otherNotes");
		
		//Validates compulsory fields
		if(disasterTitle == null || !ValidationUtil.isAlphanumericWithSpaces(disasterTitle)) {
			handleError("Disaster title must be alphanumeric and cannot be empty.", request, response);
			return;
		}
		
		if (dateOfIncidentStr == null || dateOfIncidentStr.trim().isEmpty()) {
			handleError("Date of Incident cannot be empty.", request, response);
			return;
		}
		
	    // === Optional field validations (only if not empty) ===
	    if (!ValidationUtil.isNullOrEmpty(disasterType) && !ValidationUtil.isTextOnly(disasterType)) {
	        handleError("Disaster Type must be text only.", request, response);
	        return;
	    }

	    if (!ValidationUtil.isNullOrEmpty(municipalityOrVdc) && !ValidationUtil.isTextOnly(municipalityOrVdc)) {
	        handleError("Municipality or VDC must be text only.", request, response);
	        return;
	    }

	    if (!ValidationUtil.isNullOrEmpty(wardStr) && !ValidationUtil.isNumbersOnly(wardStr)) {
	        handleError("Ward must be a number.", request, response);
	        return;
	    }

	    if (!ValidationUtil.isNullOrEmpty(noOfInjuriesStr) && !ValidationUtil.isNumbersOnly(noOfInjuriesStr)) {
	        handleError("Number of Injuries must be numeric.", request, response);
	        return;
	    }

	    if (!ValidationUtil.isNullOrEmpty(noOfDeathStr) && !ValidationUtil.isNumbersOnly(noOfDeathStr)) {
	        handleError("Number of Deaths must be numeric.", request, response);
	        return;
	    }

	    if (!ValidationUtil.isNullOrEmpty(noOfMissingStr) && !ValidationUtil.isNumbersOnly(noOfMissingStr)) {
	        handleError("Number of Missing must be numeric.", request, response);
	        return;
	    }

	    if (!ValidationUtil.isNullOrEmpty(estimatedLossStr) && !ValidationUtil.isValidDecimal(estimatedLossStr)) {
	        handleError("Estimated Loss must be a valid number (decimal).", request, response);
	        return;
	    }

	    if (!ValidationUtil.isNullOrEmpty(longitudeLatitude) && !ValidationUtil.isValidLatLon(longitudeLatitude)) {
	        handleError("Latitude/Longitude must be in valid format: latitude(26 to 31),longitude(80 to 90)", request, response);
	        return;
	    }
		
		int disasterId = Integer.parseInt(disasterIdStr);
		
	    // === Parse fields, using defaults for empty optional fields ===
	    int ward = ValidationUtil.isNullOrEmpty(wardStr) ? 0 : Integer.parseInt(wardStr);
	    int noOfInjuries = ValidationUtil.isNullOrEmpty(noOfInjuriesStr) ? 0 : Integer.parseInt(noOfInjuriesStr);
	    int noOfDeath = ValidationUtil.isNullOrEmpty(noOfDeathStr) ? 0 : Integer.parseInt(noOfDeathStr);
	    int noOfMissing = ValidationUtil.isNullOrEmpty(noOfMissingStr) ? 0 : Integer.parseInt(noOfMissingStr);
	    double estimatedLoss = ValidationUtil.isNullOrEmpty(estimatedLossStr) ? 0.0 : Double.parseDouble(estimatedLossStr);
	    LocalDate dateOfIncident = LocalDate.parse(dateOfIncidentStr);
	    disasterType = ValidationUtil.isNullOrEmpty(disasterType) ? "" : disasterType;
	    municipalityOrVdc = ValidationUtil.isNullOrEmpty(municipalityOrVdc) ? "" : municipalityOrVdc;
	    assignedCoordinator = ValidationUtil.isNullOrEmpty(assignedCoordinator) ? "" : assignedCoordinator;
	    longitudeLatitude = ValidationUtil.isNullOrEmpty(longitudeLatitude) ? "" : longitudeLatitude;
	    otherNotes = ValidationUtil.isNullOrEmpty(otherNotes) ? "" : otherNotes;
		
		DisasterModel formDisaster = new DisasterModel(
			    disasterId, disasterTitle, disasterType,
			    municipalityOrVdc, ward,longitudeLatitude,dateOfIncident,
			    reportedBy,assignedCoordinator,
			    noOfInjuries,noOfDeath,noOfMissing,
			    estimatedLoss,
			    otherNotes
			);
		
		disasterService.updateDisaster(formDisaster);
		
		doGet(request, response);
	}

	private void handleError(String errorMessage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("update_disaster_error", errorMessage);
		  request.getRequestDispatcher("/WEB-INF/pages/updateDisaster.jsp").forward(request, response);
		return;
	}

}
