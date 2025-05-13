package com.crisisconnect.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crisisconnect.config.DbConfig;
import com.crisisconnect.model.DisasterModel;

public class DisasterService {
	private Connection dbConn;
	
	public DisasterService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public Connection getDbConn() {
		if(dbConn == null) {
			try {
				this.dbConn = DbConfig.getDbConnection();
			}catch(SQLException | ClassNotFoundException ex) {
				System.err.println("Database connection error:"+ ex.getMessage());
				ex.printStackTrace();
			}
		}
		return dbConn;
	}
	
	public int addDisaster(DisasterModel formDisaster){
		String query_add_disaster = "INSERT INTO disasterrecord (disasterTitle, disasterType, municipalityOrVdc,"
									+ " ward, longitudeLatitude, dateOfIncident, reportedBy, assignedCoordinator, "
									+ "noOfInjuries, noOfDeath, noOfMissing, estimatedLoss, otherNotes) "
									+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = dbConn.prepareStatement(query_add_disaster);
			
			stmt.setString(1, formDisaster.getDisasterTitle());
			stmt.setString(2, formDisaster.getDisasterType());
			stmt.setString(3, formDisaster.getMunicipalityOrVdc());
			stmt.setString(4, String.valueOf(formDisaster.getWard()));
			stmt.setString(5, formDisaster.getLongitudeLatitude());
			stmt.setDate(6, java.sql.Date.valueOf(formDisaster.getDateOfIncident()));
			stmt.setString(7, formDisaster.getReportedBy());
			stmt.setString(8, formDisaster.getAssignedCoordinator());
			stmt.setInt(9, formDisaster.getNoOfInjuries());
			stmt.setInt(10, formDisaster.getNoOfDeath());
			stmt.setInt(11, formDisaster.getNoOfMissing());
			stmt.setDouble(12, formDisaster.getEstimatedLoss());
			stmt.setString(13, formDisaster.getOtherNotes());
			
			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // adding disaster successful successful
			} else {
				return 0; // adding failed (no rows affected)
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1; // Internal error
		}							
	}
	
}
