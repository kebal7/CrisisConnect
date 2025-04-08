package com.crisisconnect.model;

import java.time.LocalDate;

public class DisasterModel {
    private int disasterId;
    private String disasterTitle;
    private String disasterType;
    private String municipalityOrVdc;
    private int ward;
    private String longitudeLatitude;
    private LocalDate dateOfIncident;
    private String reportedBy;
    private String assignedCoordinator;
    private int noOfInjuries;
    private int noOfDeath;
    private int noOfMissing;
    private double estimatedLoss;
    private String otherNotes;

    /**
     * Constructor for creating a DisasterModel object with all required
     * details.
     *
     * @param disasterId The ID of the disaster.
     * @param disasterTitle The title of the disaster.
     * @param disasterType The type of the disaster.
     * @param municipalityOrVdc The municipality or VDC where the disaster
     * occurred.
     * @param ward The ward of the location.
     * @param longitudeLatitude The geographical coordinates (longitude and
     * latitude) of the disaster.
     * @param dateOfIncident The date the disaster occurred.
     * @param reportedBy The person who reported the disaster.
     * @param assignedCoordinator The person assigned to coordinate disaster
     * management.
     * @param noOfInjuries The number of injuries caused by the disaster.
     * @param noOfDeath The number of deaths caused by the disaster.
     * @param noOfMissing The number of people reported missing due to the
     * disaster.
     * @param estimatedLoss The estimated financial loss caused by the disaster.
     * @param otherNotes Additional notes related to the disaster.
     */
    public DisasterModel(int disasterId, String disasterTitle, String disasterType, String municipalityOrVdc, int ward,
            String longitudeLatitude, LocalDate dateOfIncident, String reportedBy, String assignedCoordinator,
            int noOfInjuries, int noOfDeath, int noOfMissing, double estimatedLoss, String otherNotes) {
        this.disasterId = disasterId;
        this.disasterTitle = disasterTitle;
        this.disasterType = disasterType;
        this.municipalityOrVdc = municipalityOrVdc;
        this.ward = ward;
        this.longitudeLatitude = longitudeLatitude;
        this.dateOfIncident = dateOfIncident;
        this.reportedBy = reportedBy;
        this.assignedCoordinator = assignedCoordinator;
        this.noOfInjuries = noOfInjuries;
        this.noOfDeath = noOfDeath;
        this.noOfMissing = noOfMissing;
        this.estimatedLoss = estimatedLoss;
        this.otherNotes = otherNotes;
    }

    // Getter and setter methods for each field
    /**
     * Gets the disaster ID.
     *
     * @return The disaster ID.
     */
    public int getDisasterId() {
        return disasterId;
    }

    /**
     * Sets the disaster ID.
     *
     * @param disasterId The disaster ID to set.
     */
    public void setDisasterId(int disasterId) {
        this.disasterId = disasterId;
    }

    /**
     * Gets the disaster title.
     *
     * @return The title of the disaster.
     */
    public String getDisasterTitle() {
        return disasterTitle;
    }

    /**
     * Sets the disaster title.
     *
     * @param disasterTitle The title of the disaster to set.
     */
    public void setDisasterTitle(String disasterTitle) {
        this.disasterTitle = disasterTitle;
    }

    /**
     * Gets the disaster type.
     *
     * @return The type of disaster.
     */
    public String getDisasterType() {
        return disasterType;
    }

    /**
     * Sets the disaster type.
     *
     * @param disasterType The type of disaster to set.
     */
    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    /**
     * Gets the municipality or VDC of the disaster.
     *
     * @return The municipality or VDC where the disaster occurred.
     */
    public String getMunicipalityOrVdc() {
        return municipalityOrVdc;
    }

    /**
     * Sets the municipality or VDC where the disaster occurred.
     *
     * @param municipalityOrVdc The municipality or VDC to set.
     */
    public void setMunicipalityOrVdc(String municipalityOrVdc) {
        this.municipalityOrVdc = municipalityOrVdc;
    }

    /**
     * Gets the ward of the disaster location.
     *
     * @return The ward where the disaster occurred.
     */
    public int getWard() {
        return ward;
    }

    /**
     * Sets the ward of the disaster location.
     *
     * @param ward The ward to set.
     */
    public void setWard(int ward) {
        this.ward = ward;
    }

    /**
     * Gets the longitude and latitude of the disaster location.
     *
     * @return The geographical coordinates (longitude, latitude).
     */
    public String getLongitudeLatitude() {
        return longitudeLatitude;
    }

    /**
     * Sets the longitude and latitude of the disaster location.
     *
     * @param longitudeLatitude The coordinates to set.
     */
    public void setLongitudeLatitude(String longitudeLatitude) {
        this.longitudeLatitude = longitudeLatitude;
    }

    /**
     * Gets the date of the disaster incident.
     *
     * @return The date the disaster occurred.
     */
    public LocalDate getDateOfIncident() {
        return dateOfIncident;
    }

    /**
     * Sets the date of the disaster incident.
     *
     * @param dateOfIncident The date to set.
     */
    public void setDateOfIncident(LocalDate dateOfIncident) {
        this.dateOfIncident = dateOfIncident;
    }

    /**
     * Gets the name of the person who reported the disaster.
     *
     * @return The name of the reporter.
     */
    public String getReportedBy() {
        return reportedBy;
    }

    /**
     * Sets the name of the person who reported the disaster.
     *
     * @param reportedBy The name of the reporter to set.
     */
    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    /**
     * Gets the name of the person assigned to coordinate disaster management.
     *
     * @return The assigned coordinator's name.
     */
    public String getAssignedCoordinator() {
        return assignedCoordinator;
    }

    /**
     * Sets the name of the person assigned to coordinate disaster management.
     *
     * @param assignedCoordinator The coordinator's name to set.
     */
    public void setAssignedCoordinator(String assignedCoordinator) {
        this.assignedCoordinator = assignedCoordinator;
    }

    /**
     * Gets the number of injuries caused by the disaster.
     *
     * @return The number of injuries.
     */
    public int getNoOfInjuries() {
        return noOfInjuries;
    }

    /**
     * Sets the number of injuries caused by the disaster.
     *
     * @param noOfInjuries The number of injuries to set.
     */
    public void setNoOfInjuries(int noOfInjuries) {
        this.noOfInjuries = noOfInjuries;
    }

    /**
     * Gets the number of deaths caused by the disaster.
     *
     * @return The number of deaths.
     */
    public int getNoOfDeath() {
        return noOfDeath;
    }

    /**
     * Sets the number of deaths caused by the disaster.
     *
     * @param noOfDeath The number of deaths to set.
     */
    public void setNoOfDeath(int noOfDeath) {
        this.noOfDeath = noOfDeath;
    }

    /**
     * Gets the number of people reported missing due to the disaster.
     *
     * @return The number of missing persons.
     */
    public int getNoOfMissing() {
        return noOfMissing;
    }

    /**
     * Sets the number of people reported missing due to the disaster.
     *
     * @param noOfMissing The number of missing persons to set.
     */
    public void setNoOfMissing(int noOfMissing) {
        this.noOfMissing = noOfMissing;
    }

    /**
     * Gets the estimated financial loss caused by the disaster.
     *
     * @return The estimated loss in monetary value.
     */
    public double getEstimatedLoss() {
        return estimatedLoss;
    }

    /**
     * Sets the estimated financial loss caused by the disaster.
     *
     * @param estimatedLoss The estimated loss to set.
     */
    public void setEstimatedLoss(double estimatedLoss) {
        this.estimatedLoss = estimatedLoss;
    }

    /**
     * Gets additional notes related to the disaster.
     *
     * @return Additional notes about the disaster.
     */
    public String getOtherNotes() {
        return otherNotes;
    }

    /**
     * Sets additional notes related to the disaster.
     *
     * @param otherNotes The notes to set.
     */
    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }
}
