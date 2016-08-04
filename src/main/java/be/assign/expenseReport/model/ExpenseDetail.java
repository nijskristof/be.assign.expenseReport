package be.assign.expenseReport.model;

import java.util.Calendar;

import javax.persistence.*;


public class ExpenseDetail {
	@Id
	@GeneratedValue
	@Column(name="DETAILS_ID")
	private long id;
	@ManyToOne
	@JoinColumn(name="FILE_ID")
	private File file;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="DATE")
	private Calendar date;
	@Column(name="SUBSISTENCE_COSTS")
	private Double subsistenceCosts;
	@Column(name="RESTAURANT_COSTS")
	private Double restaurantCosts;
	@Column(name="TRANSPORT_COSTS")
	private Double transportCosts;
	@Column(name="PARIKING_COSTS")
	private Double parkingCosts;
	@Column(name="OTHER_COSTS")
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

	@Override
	public String toString() {
		return "ExpenseDetail [id=" + id + ", file=" + file + ", description=" + description + ", date=" + date
				+ ", subsistenceCosts=" + subsistenceCosts + ", restaurantCosts=" + restaurantCosts
				+ ", transportCosts=" + transportCosts + ", parkingCosts=" + parkingCosts + ", otherCosts=" + otherCosts
				+ "]";
	}

}
