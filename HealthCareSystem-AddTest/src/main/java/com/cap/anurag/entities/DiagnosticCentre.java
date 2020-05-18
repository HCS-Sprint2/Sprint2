package com.cap.anurag.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "diagnostic_centres12")
public class DiagnosticCentre {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String centreId;
	private String centreName;

	public DiagnosticCentre() {

	}

	public DiagnosticCentre(String centreName) {
		this.centreName = centreName;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	@Override
	public String toString() {
		return "DiagnosticCentre [centreId=" + centreId + ", centreName=" + centreName + "]";
	}

}