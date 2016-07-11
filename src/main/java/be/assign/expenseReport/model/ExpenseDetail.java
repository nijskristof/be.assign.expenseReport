package be.assign.expenseReport.model;

import java.util.Calendar;

import javax.persistence.Column;

public class ExpenseDetail {
	private long id;
	private File file;
	private String description;
	private Calendar date;
	private Double subsistenceCosts;
	private Double restaurantCosts;
	private Double transportCosts;
	private Double parkingCosts;
	private Double otherCosts;

	public ExpenseDetail() {

	}

	public ExpenseDetail(long id, File file, String description, Calendar date, Double subsistenceCosts,
			Double restaurantCosts, Double transportCosts, Double parkingCosts, Double otherCosts) {
		super();
		this.id = id;
		this.file = file;
		this.description = description;
		this.date = date;
		this.subsistenceCosts = subsistenceCosts;
		this.restaurantCosts = restaurantCosts;
		this.transportCosts = transportCosts;
		this.parkingCosts = parkingCosts;
		this.otherCosts = otherCosts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Double getSubsistenceCosts() {
		return subsistenceCosts;
	}

	public void setSubsistenceCosts(Double subsistenceCosts) {
		this.subsistenceCosts = subsistenceCosts;
	}

	public Double getRestaurantCosts() {
		return restaurantCosts;
	}

	public void setRestaurantCosts(Double restaurantCosts) {
		this.restaurantCosts = restaurantCosts;
	}

	public Double getTransportCosts() {
		return transportCosts;
	}

	public void setTransportCosts(Double transportCosts) {
		this.transportCosts = transportCosts;
	}

	public Double getParkingCosts() {
		return parkingCosts;
	}

	public void setParkingCosts(Double parkingCosts) {
		this.parkingCosts = parkingCosts;
	}

	public Double getOtherCosts() {
		return otherCosts;
	}

	public void setOtherCosts(Double otherCosts) {
		this.otherCosts = otherCosts;
	}

}
