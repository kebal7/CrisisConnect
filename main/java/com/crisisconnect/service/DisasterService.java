package com.crisisconnect.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<DisasterModel> getAllDisasters() {
		List<DisasterModel> disasters = new ArrayList<>();
		
		String retriever_disaster_query = "SELECT * FROM disasterrecord";
		
		try {
			PreparedStatement stmt = dbConn.prepareStatement(retriever_disaster_query);
			
			ResultSet resultSet = stmt.executeQuery();
			
            // Iterating through the result set and adding DisasterModel objects to the list
            while (resultSet.next()) {
            	int id = resultSet.getInt("disasterId");
            	String title = resultSet.getString("disasterTitle");
            	String type = resultSet.getString("disasterType");
            	String municipality = resultSet.getString("municipalityOrVdc");
            	int ward = Integer.parseInt(resultSet.getString("ward"));
            	String coordinates = resultSet.getString("longitudeLatitude");
            	LocalDate date = resultSet.getDate("dateOfIncident").toLocalDate();
            	String reporter = resultSet.getString("reportedBy");
            	String coordinator = resultSet.getString("assignedCoordinator");
            	int injuries = resultSet.getInt("noOfInjuries");
            	int deaths = resultSet.getInt("noOfDeath");
            	int missing = resultSet.getInt("noOfMissing");
            	double loss = resultSet.getDouble("estimatedLoss");
            	String notes = resultSet.getString("otherNotes");

            	DisasterModel disaster = new DisasterModel(id, title, type, municipality, ward, coordinates,
            	                                           date, reporter, coordinator, injuries, deaths,
            	                                           missing, loss, notes);

                disasters.add(disaster); // Add the disaster object to the list
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return disasters;
	}
	
	public int deleteDisasterRecord(int disasterId) {
		String delete_disaster_query = "DELETE FROM	disasterrecord WHERE disasterId=?";
		
		try {
			PreparedStatement stmt = dbConn.prepareStatement(delete_disaster_query);
			stmt.setInt(1, disasterId);
			
			int result = stmt.executeUpdate();
			
			// Check if the delete was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // delete disaster successful
			} else {
				return 0; // delete failed (no rows affected)
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1; // Internal error
		}
		
	}

	public DisasterModel getDisaster(int disasterId) {
		String retriever_disaster_query = "SELECT * FROM disasterrecord WHERE disasterId= ?";
		
		try {
			PreparedStatement stmt = dbConn.prepareStatement(retriever_disaster_query);
			
			stmt.setInt(1, disasterId);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				int id = result.getInt("disasterId");
				String title = result.getString("disasterTitle");
				String type = result.getString("disasterType");
				String municipality = result.getString("municipalityOrVdc");
				int ward = Integer.parseInt(result.getString("ward"));
				String coordinates = result.getString("longitudeLatitude");
				LocalDate date = result.getDate("dateOfIncident").toLocalDate();
				String reporter = result.getString("reportedBy");
				String coordinator = result.getString("assignedCoordinator");
				int injuries = result.getInt("noOfInjuries");
				int deaths = result.getInt("noOfDeath");
				int missing = result.getInt("noOfMissing");
				double loss = result.getDouble("estimatedLoss");
				String notes = result.getString("otherNotes");

            	DisasterModel disaster = new DisasterModel(id, title, type, municipality, ward, coordinates,
                        date, reporter, coordinator, injuries, deaths,
                        missing, loss, notes);
            	return disaster;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
