package com.pdw.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment_table")
public class Appointment{
	
	@Id
	@GeneratedValue
	@Column(length=10)
	private int appointmentId;
	@Column(length=20)
	private String dateTimeSlot;
	@Column(length=10)
	private boolean approved;
	@Column(length=10)
	private String userId;
	@Column(length=30)
	private String test;
	@Column(length=30)
	private String center;
	
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getDateTimeSlot() {
		return dateTimeSlot;
	}
	public void setDateTimeSlot(String dateTimeSlot) {
		this.dateTimeSlot = dateTimeSlot;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	@Override
	public String toString() {
		return "appointmentId=" + appointmentId + ", dateTimeSlot=" + dateTimeSlot + ", approved="
				+ approved + ", userId=" + userId + ", test=" + test + ", center=" + center + "]";
	}
	
	public Appointment() {
		
	}
	

}
